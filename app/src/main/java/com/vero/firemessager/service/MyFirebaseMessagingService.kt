package com.vero.firemessager.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage : RemoteMessage?) {
        if (remoteMessage?.notification != null) {
            //TODO show notification

            Log.d("FCM", "FCM message received")
        }
    }
}