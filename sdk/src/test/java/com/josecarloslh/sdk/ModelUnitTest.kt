package com.josecarloslh.sdk

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.josecarloslh.sdk.serializer.TopRatedDeserializer
import org.junit.Assert
import org.junit.Test

class ModelUnitTest {

    val JSON_DEAL = "{" +
            "\"internalName\": \"TOKITORI\"," +
            "\"title\": \"Toki Tori\"," +
            "\"metacriticLink\": \"/game/pc/toki-tori\"," +
            "\"dealID\": \"Ws%2B0c2sUsDPpqLQB7ToTCNhVsyc5uBSRe50G3FFDt58%3D\"," +
            "\"storeID\": \"1\"," +
            "\"gameID\": \"574\"," +
            "\"salePrice\": \"0.49\"," +
            "\"normalPrice\": \"4.99\"," +
            "\"isOnSale\": \"1\"," +
            "\"savings\": \"90.180361\"," +
            "\"metacriticScore\": \"80\"," +
            "\"steamRatingText\": \"Very Positive\"," +
            "\"steamRatingPercent\": \"88\"," +
            "\"steamRatingCount\": \"1289\"," +
            "\"releaseDate\": 1264636800," +
            "\"lastChange\": 1499708988," +
            "\"dealRating\": \"9.2\"," +
            "\"thumb\": \"http://cdn.akamai.steamstatic.com/steam/apps/38700/capsule_sm_120.jpg?t=1488471030\"" +
            "}"

    val JSON_TOP_GAME = "{" +
            "\"appid\": 10," +
            "\"name\": \"Counter-Strike\"," +
            "\"developer\": \"Valve\"," +
            "\"publisher\": \"Valve\"," +
            "\"score_rank\": 97," +
            "\"owners\": 13364200," +
            "\"owners_variance\": 105566," +
            "\"players_forever\": 9404662," +
            "\"players_forever_variance\": 88993," +
            "\"players_2weeks\": 393588," +
            "\"players_2weeks_variance\": 18406," +
            "\"average_forever\": 11259," +
            "\"average_2weeks\": 698," +
            "\"median_forever\": 429," +
            "\"median_2weeks\": 66," +
            "\"ccu\": 18288," +
            "\"price\": \"999\"," +
            "\"tags\": {" +
            "\"Action\": 2510," +
            "\"FPS\": 1887," +
            "\"Multiplayer\": 1524," +
            "\"Shooter\": 1301," +
            "\"Classic\": 1248," +
            "\"Team-Based\": 849," +
            "\"Competitive\": 719," +
            "\"First-Person\": 713," +
            "\"Tactical\": 664," +
            "\"1990's\": 513," +
            "\"e-sports\": 487," +
            "\"PvP\": 402," +
            "\"Military\": 309," +
            "\"Strategy\": 287," +
            "\"Score Attack\": 171," +
            "\"Survival\": 156," +
            "\"Assassin\": 133," +
            "\"1980s\": 123," +
            "\"Ninja\": 106," +
            "\"Tower Defense\": 71" +
            "}}"

    @Test
    fun dealParsingTest() {
        val gson = Gson()
        val deal = gson.fromJson(JSON_DEAL, Deals::class.java)

        //If an assert returns a false, the compilation of the test will stop
        Assert.assertEquals(deal.title, "Toki Tori")
        Assert.assertEquals(deal.metacriticRating, 80)
        Assert.assertEquals(deal.discountPercentage.toInt(), 90)
        Assert.assertEquals(deal.steamRating, 88)
        Assert.assertEquals(deal.salePrice.toBits(), 0.49.toBits())
        Assert.assertEquals(deal.normalPrice.toBits(), 4.99.toBits())
        Assert.assertEquals(
            deal.thumb,
            "http://cdn.akamai.steamstatic.com/steam/apps/38700/capsule_sm_120.jpg?t=1488471030"
        )
    }

    @Test
    fun topGameParsingTest() {
        val gson = GsonBuilder()
                .registerTypeAdapter(TopRated::class.java, TopRatedDeserializer())
                .create()
        val topRated = gson.fromJson(JSON_TOP_GAME, TopRated::class.java)

        //If an assert returns a false, the compilation of the test will stop
        Assert.assertEquals(topRated.title, "Counter-Strike")
        Assert.assertEquals(topRated.steamRating, 97)
        Assert.assertEquals(topRated.owners, 13364200)
        Assert.assertEquals(topRated.price.toInt(), 999)
    }
}