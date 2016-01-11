package com.r0adkll.hardwired.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.r0adkll.hardwired.data.model.Component;

import java.io.IOException;

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
public class OpenHardwareMonitor {

    private static OkHttpClient _client;
    private static Gson _gson;

    private static OkHttpClient getOkHttp(){
        if(_client == null) _client = new OkHttpClient.Builder()
                .build();
        return _client;
    }

    private static Gson getGson(){
        if(_gson == null) _gson = new GsonBuilder()
                .create();
        return _gson;
    }

    /**
     * Read the data from the Open Hardware Moniter HttpServer
     * and deserialize it into a model object
     *
     * @param baseUri       the base url + port that the OHM is running on
     * @return              the observable to listen to
     */
    public static Observable<Component> read(final String baseUri){
        return Observable.create(new Observable.OnSubscribe<Component>() {
            @Override
            public void call(Subscriber<? super Component> subscriber) {
                OkHttpClient client = getOkHttp();
                Request request = new Request.Builder()
                        .get()
                        .url(getUrl(baseUri))
                        .build();

                try {
                    Response response = client.newCall(request).execute();

                    // Parse Response
                    String responseBody = response.body().string();

                    // Deserialize into object
                    Component component = getGson().fromJson(responseBody, Component.class);

                    // Now, if possible, pump through subscriber
                    if(!subscriber.isUnsubscribed()){
                        subscriber.onNext(component);
                        subscriber.onCompleted();
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

    private static String getUrl(String baseUri){
        return String.format("%s/data.json", baseUri);
    }

}
