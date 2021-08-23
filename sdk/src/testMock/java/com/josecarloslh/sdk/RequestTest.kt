package com.josecarloslh.sdk

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.junit.Assert
import org.junit.Test

class RequestTest {

    @Test
    fun dealsRequest_success() {
        val apiService = ApiService()
        //In runtime, this would return an error because you have to execute the request in an AsyncTask
        val response = apiService.apiClient.getDeals().execute()
        val deals = response.body()

        val jsonResponse: JsonArray =
            JsonParser.parseString(MockResponses.DEALS_RESPONSE).asJsonArray

        Assert.assertTrue(response.isSuccessful)

        //Joins jsonResponse with deals
        deals?.let {
            deals.zip(jsonResponse).forEach { (deal, jsonDeal) ->
                with(jsonDeal.asJsonObject) {
                    Assert.assertEquals(deal.title, this["title"].asString)
                    Assert.assertEquals(deal.metacriticRating, this["metacriticScore"].asInt)
                    Assert.assertEquals(deal.steamRating, this["steamRatingPercent"].asInt)
                    //Assert.assertEquals(deal.discountPercentage, this["title"].asString)
                    Assert.assertEquals(
                        deal.normalPrice,
                        this["normalPrice"].asFloat
                    )
                    //Assert.assertEquals(deal.salePrice, this["title"].asString)
                    Assert.assertEquals(deal.thumb, this["thumb"].asString)
                }
            }
        }
    }

    @Test
    fun topRatedRequest_success() {
        val apiService = ApiService()
        //In runtime, this would return an error because you have to execute the request in an AsyncTask
        val response = apiService.apiClient.getTopRated().execute()
        val topRated = response.body()

        val jsonResponse: List<JsonObject> =
            JsonParser.parseString(MockResponses.TOP_100_GAMES)
                .asJsonObject
                .entrySet()
                .map { (_, json) ->
                    json.asJsonObject
                }

        Assert.assertTrue(response.isSuccessful)

        //Joins jsonResponse with deals
        topRated?.let {
            Assert.assertEquals(topRated.size, jsonResponse.size)

            topRated.zip(jsonResponse).forEach { (topRated, jsonTopRated) ->
                with(jsonTopRated.asJsonObject) {
                    Assert.assertEquals(topRated.title, this["name"].asString)
                    Assert.assertEquals(topRated.owners, this["owners"].asInt)
                    Assert.assertEquals(topRated.steamRating, this["score_rank"].asInt)
                    //Assert.assertEquals(topRated.discountPercentage, this["title"].asString)
                    //Assert.assertEquals(topRated.price.toBits(), this["price"].asDouble.toBits())
                    //Assert.assertEquals(topRated.salePrice, this["title"].asString)
                    Assert.assertEquals(topRated.thumb, "https://cdn.cloudflare.steamstatic.com/steam/apps/${this["appid"]}/capsule_184x69.jpg")
                }
            }
        }
    }

}