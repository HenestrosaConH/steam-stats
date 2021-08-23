package com.josecarloslh.steamstats.toprated

import com.josecarloslh.sdk.TopRated

object TopRatedMapper {
    fun fromSdk(topRated: TopRated, position: Int): TopRatedModel {
        return TopRatedModel(
            topRated.title,
            topRated.owners,
            topRated.steamRating,
            topRated.price,
            position,
            topRated.thumb
        )
    }
}


