package com.vero.firemessager.model

class User(val name: String,
           val bio: String,
           val profilePicturePath: String?) {
    constructor(): this("", "", null)
}