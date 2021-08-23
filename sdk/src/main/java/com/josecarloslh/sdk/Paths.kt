package com.josecarloslh.sdk

object Paths {

    const val CHEAP_SHARK_STEAM_STORE_ID = "1"

    const val BASE_URL = "https://steamspy.com/api.php/"
    const val BASE_URL_STEAM_SPY = "https://steamspy.com/api.php/"
    const val BASE_URL_CHEAP_SHARK = "https://cheapshark.com/api/1.0/"

    const val GET_TOP_100_GAMES = "${BASE_URL_STEAM_SPY}?request=top100forever/"
    const val GET_MOST_OWNED_GAMES = "${BASE_URL_STEAM_SPY}?request=top100owned/"
    const val GET_DEALS = "${BASE_URL_CHEAP_SHARK}/deals?storeID=${CHEAP_SHARK_STEAM_STORE_ID}/"
}