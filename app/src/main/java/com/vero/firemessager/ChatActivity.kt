package com.vero.firemessager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.ListenerRegistration
import com.vero.firemessager.util.FirestoreUtil
import com.xwray.groupie.kotlinandroidextensions.Item
import org.jetbrains.anko.toast

class ChatActivity : AppCompatActivity() {

    private lateinit var messageListenerRegistration: ListenerRegistration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = intent.getStringExtra(AppConstants.USER_NAME)

        val otherUserId = intent.getStringExtra(AppConstants.USER_ID)
        FirestoreUtil.getOnCreateChannel(otherUserId) { channelId ->

            messageListenerRegistration = FirestoreUtil.addChatMessagesListener(channelId, this, this::onMessageChanged)
        }
    }

    private fun onMessageChanged(messages: List<Item>) {
        toast("onMessageChangedRunning!")
    }
}
