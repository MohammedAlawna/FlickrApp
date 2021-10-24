package com.mua.flickrapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.net.HttpURLConnection;

enum DownloadStatus {IDLE, PROCESSING, NOT_INSTALLED, FAILED_OR_EMPTY, OK}

class GetRawData extends AsyncTaskLoader<String,Void,String> {
    private static final String TAG = "GetRawData";

    private DownloadStatus mDownloadStatus;

    public GetRawData() {
        this.mDownloadStatus = DownloadStatus.IDLE;
    }


    @Nullable
    @Override
    public String loadInBackground(String... strings) {
        HttpURLConnection urlCon = null;
        BufferedReader reader = null;

        if(strings == null) {
           mDownloadStatus = DownloadStatus.NOT_INSTALLED;
        }
        return null;
    }
}
