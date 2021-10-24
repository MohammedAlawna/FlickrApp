package com.mua.flickrapp;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

enum DownloadStatus {IDLE, PROCESSING, NOT_INSTALLED, FAILED_OR_EMPTY, OK}

class GetRawData extends AsyncTaskLoader<String,Void,String> {
    private static final String TAG = "GetRawData";

    private DownloadStatus mDownloadStatus;



    public GetRawData(@NonNull Context context) {

        super(context);
        this.mDownloadStatus = DownloadStatus.IDLE;
    }


    @Nullable
    @Override
    public String loadInBackground(String... strings) {
        HttpURLConnection urlCon = null;
        BufferedReader reader = null;

        if(strings == null) {
           mDownloadStatus = DownloadStatus.NOT_INSTALLED;
           return  null;
        }

        try {
            mDownloadStatus = DownloadStatus.PROCESSING;
            URL url = new URL(strings[0]);

            urlCon = (HttpURLConnection) url.openConnection();
            urlCon.setRequestMethod("GET");
            urlCon.connect();
            int response = urlCon.getResponseCode();
            Log.d(TAG, "loadInBackground: "+ response);

            StringBuilder result = new StringBuilder();

            reader = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

            String line;
            while(line = reader)

        }
        catch (MalformedURLException e) {
            Log.e(TAG, "loadInBackground: " + e.getMessage());
        }
        catch (IOException e) {
            Log.e(TAG, "loadInBackground: " + e.getMessage());

        }
        catch (SecurityException e) {
            Log.e(TAG, "loadInBackground: " + e.getMessage());
        }
        return null;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return null;
    }
}
