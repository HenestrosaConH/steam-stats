package com.josecarloslh.sdk.serializer

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.josecarloslh.sdk.TopRated
import java.lang.reflect.Type

class TopRatedDeserializer : JsonDeserializer<TopRated> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): TopRated {
        val gson = Gson()

        val topRated = gson.fromJson(json, TopRated::class.java)

        val jsonGame = json.asJsonObject
        val appId = jsonGame["appid"].asInt.toString()

        val rawRating = jsonGame["score_rank"].asString
        val steamRating = if (rawRating.isEmpty()) 0 else rawRating.toInt()

        val thumb = String.format(BASE_URL_IMG, appId)
        topRated.thumb = thumb
        topRated.steamRating = steamRating
        topRated.price = topRated.price / 100

        return topRated
    }

    companion object {
        const val BASE_URL_IMG =
            "https://cdn.cloudflare.steamstatic.com/steam/apps/%s/capsule_184x69.jpg"
    }

}