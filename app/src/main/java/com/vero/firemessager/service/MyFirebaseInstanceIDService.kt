package com.vero.firemessager.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessagingService
import com.vero.firemessager.util.FirestoreUtil
import java.lang.NullPointerException

class MyFirebaseInstanceIDService : FirebaseMessagingService() {

    override fun onNewToken(p0: String?) {

        if (FirebaseAuth.getInstance().currentUser != null)
            addTokenForFirestore(newRegistrationToken = p0)
    }

    companion object {
        fun addTokenForFirestore(newRegistrationToken: String?) {
            if (newRegistrationToken == null) throw NullPointerException("FCM token is null.")

            FirestoreUtil.getFCMRegistrationTokens {tokens ->
                if (tokens.contains(newRegistrationToken))
                    return@getFCMRegistrationTokens

                tokens.add(newRegistrationToken)
                FirestoreUtil.serFCMRegistrationTokens(tokens)
            }
        }
    }



}