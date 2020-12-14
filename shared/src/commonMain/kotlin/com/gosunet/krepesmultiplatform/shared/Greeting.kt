package com.gosunet.krepesmultiplatform.shared

class Greeting {
    fun greeting(): String {
        return "${Platform().platform} app !"
    }
}
