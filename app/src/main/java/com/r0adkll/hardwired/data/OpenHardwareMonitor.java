package com.r0adkll.hardwired.data;

import android.content.res.Resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.data.model.Computer;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * This class manages the connection and deserialization of data from the Open Hardware Monitor
 * API
 *
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data
 * Created by drew.heavner on 1/11/16.
 */
@Singleton
public class OpenHardwareMonitor {

    private OkHttpClient client;
    private Gson gson;

    @Inject
    public OpenHardwareMonitor(OkHttpClient client, Gson gson){
        this.client = client;
        this.gson = gson;
    }

    /**
     * Test a provided IP Address and Port to see if there is a running instance of
     * Open Hardware Monitor running and return the resulting computer object to save and store
     * for later reference
     *
     * @param ipAddress     the address of the OHM Server to connect to
     * @param port          the port that the OHM Server is running on
     * @return              the Computer object to save for reconnection later
     */
    public Observable<Computer> test(String ipAddress, int port){
        return Observable.create(new Observable.OnSubscribe<Computer>() {
            @Override
            public void call(Subscriber<? super Computer> subscriber) {
                Request request = new Request.Builder()
                        .get()
                        .url(String.format("https://%s:%04d/data.json", ipAddress, port))
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    if(response.isSuccessful()) {

                        // Parse Response
                        String responseBody = response.body().string();
                        Component computer = parseResponse(responseBody);
                        if(computer != null){

                            // Construct Computer object from gathered info
                            Computer c = new Computer.Builder()
                                    .name(computer.title)
                                    .ip(ipAddress)
                                    .port(port)
                                    .build();

                            // Now, if possible, pump through subscriber
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onNext(c);
                                subscriber.onCompleted();
                            }
                        } else {
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onError(new Resources.NotFoundException("No computer was found"));
                                subscriber.onCompleted();
                            }
                        }

                    }else{
                        if(!subscriber.isUnsubscribed()){
                            subscriber.onError(new Exception(String.format("[%d] %s", response.code(), response.message())));
                            subscriber.onCompleted();
                        }
                    }

                } catch (IOException | JsonSyntaxException e) {
                    if(!subscriber.isUnsubscribed()){
                        subscriber.onError(e);
                        subscriber.onCompleted();
                    }
                }


            }
        });
    }

    /**
     * Read the data from the Open Hardware Moniter HttpServer
     * and deserialize it into a model object
     *
     * @param baseUri       the base url + port that the OHM is running on
     * @return              the observable to listen to
     */
    public Observable<Component> read(final String baseUri){
        return Observable.create(new Observable.OnSubscribe<Component>() {
            @Override
            public void call(Subscriber<? super Component> subscriber) {
                Request request = new Request.Builder()
                        .get()
                        .url(getUrl(baseUri))
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    if(response.isSuccessful()) {

                        // Parse Response
                        String responseBody = response.body().string();
                        Component computer = parseResponse(responseBody);
                        if(computer != null){
                            // Now, if possible, pump through subscriber
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onNext(computer);
                                subscriber.onCompleted();
                            }
                        } else {
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onError(new Resources.NotFoundException("No computer was found"));
                                subscriber.onCompleted();
                            }
                        }

                    }else{
                        if(!subscriber.isUnsubscribed()){
                            subscriber.onError(new Exception(String.format("[%d] %s", response.code(), response.message())));
                            subscriber.onCompleted();
                        }
                    }

                } catch (IOException | JsonSyntaxException e) {
                    if(!subscriber.isUnsubscribed()){
                        subscriber.onError(e);
                        subscriber.onCompleted();
                    }
                }

            }
        });
    }

    public Observable<Component> readTest(){
        return Observable.create(new Observable.OnSubscribe<Component>() {
            @Override
            public void call(Subscriber<? super Component> subscriber) {
                Component computer = parseResponse(TEST_DATA);
                if(computer != null){
                    // Now, if possible, pump through subscriber
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(computer);
                        subscriber.onCompleted();
                    }
                } else {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onError(new Resources.NotFoundException("No computer was found"));
                        subscriber.onCompleted();
                    }
                }
            }
        });
    }

    private Component parseResponse(String responseBody){
        // Deserialize into object
        Component component = gson.fromJson(responseBody, Component.class);

        if (component.components != null && !component.components.isEmpty()) {
            return component.components.get(0);
        }

        return null;
    }

    private static String getUrl(String baseUri){
        return String.format("%s/data.json", baseUri);
    }

    private static final String TEST_DATA = "{\n" +
            "   \"id\":0,\n" +
            "   \"Text\":\"Sensor\",\n" +
            "   \"Children\":[\n" +
            "      {\n" +
            "         \"id\":1,\n" +
            "         \"Text\":\"THEBATCOMPUTER\",\n" +
            "         \"Children\":[\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"Text\":\"ASUS Z170-A\",\n" +
            "               \"Children\":[\n" +
            "\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/mainboard.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":3,\n" +
            "               \"Text\":\"Intel Core i5-6600K\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":4,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":5,\n" +
            "                           \"Text\":\"CPU Total\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.4 %\",\n" +
            "                           \"Value\":\"9.4 %\",\n" +
            "                           \"Max\":\"86.7 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":6,\n" +
            "                           \"Text\":\"CPU Core #1\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"21.9 %\",\n" +
            "                           \"Max\":\"100.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":7,\n" +
            "                           \"Text\":\"CPU Core #2\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"12.5 %\",\n" +
            "                           \"Max\":\"90.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":8,\n" +
            "                           \"Text\":\"CPU Core #3\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"3.1 %\",\n" +
            "                           \"Max\":\"90.6 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":9,\n" +
            "                           \"Text\":\"CPU Core #4\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"0.0 %\",\n" +
            "                           \"Max\":\"95.3 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/cpu.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":10,\n" +
            "               \"Text\":\"Generic Memory\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":11,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":12,\n" +
            "                           \"Text\":\"Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"15.3 %\",\n" +
            "                           \"Value\":\"15.4 %\",\n" +
            "                           \"Max\":\"30.9 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":13,\n" +
            "                     \"Text\":\"Data\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":14,\n" +
            "                           \"Text\":\"Used Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"2.4 GB\",\n" +
            "                           \"Value\":\"2.4 GB\",\n" +
            "                           \"Max\":\"4.9 GB\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":15,\n" +
            "                           \"Text\":\"Available Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"11.0 GB\",\n" +
            "                           \"Value\":\"13.5 GB\",\n" +
            "                           \"Max\":\"13.5 GB\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/power.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/ram.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":16,\n" +
            "               \"Text\":\"AMD Radeon R9 200 Series\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":17,\n" +
            "                     \"Text\":\"Clocks\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":18,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"230 MHz\",\n" +
            "                           \"Value\":\"319 MHz\",\n" +
            "                           \"Max\":\"1000 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":19,\n" +
            "                           \"Text\":\"GPU Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"150 MHz\",\n" +
            "                           \"Value\":\"1250 MHz\",\n" +
            "                           \"Max\":\"1250 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/clock.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":20,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":21,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"37.0 Â°C\",\n" +
            "                           \"Value\":\"82.0 Â°C\",\n" +
            "                           \"Max\":\"94.0 Â°C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":22,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":23,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"0.0 %\",\n" +
            "                           \"Max\":\"100.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":24,\n" +
            "                     \"Text\":\"Fans\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":25,\n" +
            "                           \"Text\":\"GPU Fan\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"292 RPM\",\n" +
            "                           \"Value\":\"2052 RPM\",\n" +
            "                           \"Max\":\"2212 RPM\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/fan.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":26,\n" +
            "                     \"Text\":\"Controls\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":27,\n" +
            "                           \"Text\":\"GPU Fan\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"20.0 %\",\n" +
            "                           \"Value\":\"42.0 %\",\n" +
            "                           \"Max\":\"59.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/control.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/ati.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":28,\n" +
            "               \"Text\":\"AMD Radeon R9 200 Series\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":29,\n" +
            "                     \"Text\":\"Clocks\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":30,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"270 MHz\",\n" +
            "                           \"Value\":\"300 MHz\",\n" +
            "                           \"Max\":\"375 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":31,\n" +
            "                           \"Text\":\"GPU Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"150 MHz\",\n" +
            "                           \"Value\":\"150 MHz\",\n" +
            "                           \"Max\":\"150 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/clock.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":32,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":33,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"39.0 Â°C\",\n" +
            "                           \"Value\":\"46.0 Â°C\",\n" +
            "                           \"Max\":\"46.0 Â°C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":34,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":35,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"0.0 %\",\n" +
            "                           \"Max\":\"0.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":36,\n" +
            "                     \"Text\":\"Fans\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":37,\n" +
            "                           \"Text\":\"GPU Fan\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"1036 RPM\",\n" +
            "                           \"Value\":\"1052 RPM\",\n" +
            "                           \"Max\":\"1785 RPM\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/fan.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":38,\n" +
            "                     \"Text\":\"Controls\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":39,\n" +
            "                           \"Text\":\"GPU Fan\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"20.0 %\",\n" +
            "                           \"Value\":\"20.0 %\",\n" +
            "                           \"Max\":\"59.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/control.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/ati.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":40,\n" +
            "               \"Text\":\"Samsung SSD 850 EVO 250GB\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":41,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":42,\n" +
            "                           \"Text\":\"Temperature\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"27.0 Â°C\",\n" +
            "                           \"Value\":\"33.0 Â°C\",\n" +
            "                           \"Max\":\"34.0 Â°C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":43,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":44,\n" +
            "                           \"Text\":\"Used Space\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"53.2 %\",\n" +
            "                           \"Value\":\"53.2 %\",\n" +
            "                           \"Max\":\"53.4 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/hdd.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":45,\n" +
            "               \"Text\":\"WDC WD2003FZEX-00Z4SA0\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":46,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":47,\n" +
            "                           \"Text\":\"Temperature\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"28.0 Â°C\",\n" +
            "                           \"Value\":\"29.0 Â°C\",\n" +
            "                           \"Max\":\"30.0 Â°C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":48,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":49,\n" +
            "                           \"Text\":\"Used Space\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"26.7 %\",\n" +
            "                           \"Value\":\"26.7 %\",\n" +
            "                           \"Max\":\"26.7 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/hdd.png\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"Min\":\"\",\n" +
            "         \"Value\":\"\",\n" +
            "         \"Max\":\"\",\n" +
            "         \"ImageURL\":\"images_icon/computer.png\"\n" +
            "      }\n" +
            "   ],\n" +
            "   \"Min\":\"Min\",\n" +
            "   \"Value\":\"Value\",\n" +
            "   \"Max\":\"Max\",\n" +
            "   \"ImageURL\":\"\"\n" +
            "}";

}
