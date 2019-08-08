package com.vero.firemessager.recyclerview.item

import android.content.Context
import com.vero.firemessager.R
import com.vero.firemessager.model.TextMessage
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder

class TextMessageItem(val message: TextMessage,
                      val context: Context) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayout() = R.layout.item_text_message
}