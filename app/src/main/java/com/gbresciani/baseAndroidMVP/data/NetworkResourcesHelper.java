package com.gbresciani.baseAndroidMVP.data;

import android.support.annotation.Nullable;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

public class NetworkResourcesHelper {

    public NetworkResourcesHelper() {
    }

    @Nullable
    public String getGist() throws IOException {
        OkHttpClient client = new OkHttpClient();


        Request req = new Request.Builder()
                .url("https://gist.github.com/brescia123/f0593e16f13033749361")
                .build();

        Timber.i("Starting http call to %s", req.url());
        Response res = client.newCall(req).execute();
        Timber.i("Response code: %d", res.code());

        if (res.isSuccessful()) {
            return res.body().string();
        }

        return String.valueOf(res.code());
    }
}
