package com.vero.firemessager.model

data class ChatChannel(val userIds: MutableList<String>) {
    constructor() : this(mutableListOf())
}