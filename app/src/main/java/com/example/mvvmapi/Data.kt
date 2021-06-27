package com.example.mvvmapi

data class Data(
    var exchange_id: String,
    var symbol: String,
    var price_unconverted: Double,
    var price: Double,
    var change_24h: Double,
    var spread: Double,
    var volume_24h: Double,
    var status: String,
     var time: String
)