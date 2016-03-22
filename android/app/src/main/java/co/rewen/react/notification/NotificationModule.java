package co.rewen.react.notification;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Copyright (c) 2015-present, Junjun Deng
 * All rights reserved.
 */
public class NotificationModule extends ReactContextBaseJavaModule {
    public static final String ACTION_STATE_CHANGED = "co.rewen.intent.action.STATE_CHANGED";
    private LocalBroadcastManager localBroadcastManager;

    public NotificationModule(ReactApplicationContext reactContext) {
        super(reactContext);
        localBroadcastManager = LocalBroadcastManager.getInstance(reactContext);
    }

    @Override
    public String getName() {
        return "NotificationManager";
    }

    @ReactMethod
    public void postNotification(String event) {
        Intent intent = new Intent(ACTION_STATE_CHANGED);
        Uri uri = uriForKey(event);
        intent.setData(uri);
        localBroadcastManager.sendBroadcast(intent);
    }

    public static final String SCHEME = "state";
    public static final String AUTHORITY = "co.rewen";

    public static Uri uriForKey(String key) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(SCHEME);
        builder.authority(AUTHORITY);
        builder.path(key);
        return builder.build();
    }
}
