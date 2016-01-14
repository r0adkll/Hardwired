package com.r0adkll.hardwired.data;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data
 * Created by drew.heavner on 1/14/16.
 */
public class MockIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        HttpUrl url = chain.request().url();
        String _url = url.url().toString();

        Response.Builder response = new Response.Builder()
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .code(404)
                .message("Cannot connect to server");

        String json = MockOhmData.OHM_DATA.get(_url);
        if(!TextUtils.isEmpty(json)){
            response.code(200)
                    .message("")
                    .body(ResponseBody.create(MediaType.parse("application/json"), json));
        }

        return response.build();
    }
}
