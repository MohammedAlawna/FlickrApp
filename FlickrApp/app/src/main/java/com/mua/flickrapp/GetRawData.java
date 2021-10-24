package com.mua.flickrapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

enum DownloadStatus {IDLE, PROCESSING, NOT_INSTALLED, FAILED_OR_EMPTY, OK}

class GetRawData extends AsyncTaskLoader<String,Void,String> {
    private static final String TAG = "GetRawData";

    private DownloadStatus mDownloadStatus;

    public GetRawData() {
        this.mDownloadStatus = DownloadStatus.IDLE;
    }
}
