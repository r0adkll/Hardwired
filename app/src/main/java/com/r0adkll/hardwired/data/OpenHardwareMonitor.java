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
                        .url(String.format("http://%s:%d/data.json", ipAddress, port))
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



}
