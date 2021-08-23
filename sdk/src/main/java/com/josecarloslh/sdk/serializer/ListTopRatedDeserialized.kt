package com.josecarloslh.sdk.serializer

import com.google.gson.*
import com.josecarloslh.sdk.TopRated
import java.lang.reflect.Type

class ListTopRatedDeserialized : JsonDeserializer<ArrayList<TopRated>> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): ArrayList<TopRated> {
        //EntrySet returns a Collection
        val jsonTopRated =
            json.asJsonObject
                .entrySet().map { (key, json) ->
                    //For each entry of this JsonObject,
                    // you will convert a JsonElement into a JsonObject
                    json.asJsonObject
                }

        //We deserialize the json telling the gson the deserialization adapter.
        //In this case, it's TopRated
        val gson = GsonBuilder()
            .registerTypeAdapter(TopRated::class.java, TopRatedDeserializer())
            .create()

        //Now, we have every TopRated game contained in the JSON
        //that we deserialized stored in the ArrayList that we return
        val topRatedList: List<TopRated> = jsonTopRated.map { json ->
            gson.fromJson(json, TopRated::class.java)
        }

        val topRatedArrayList: ArrayList<TopRated> = arrayListOf()
        topRatedArrayList.addAll(topRatedList)

        return topRatedArrayList
    }

}