package com.josecarloslh.sdk

import com.google.gson.annotations.SerializedName

data class Deals(
    var title: String,
    @SerializedName("savings") var discountPercentage: Float,
    var salePrice: Float,
    var normalPrice: Float,
    @SerializedName("metacriticScore") var metacriticRating: Int,
    @SerializedName("steamRatingPercent") var steamRating: Int,
    var thumb: String
)

data class TopRated(
    @SerializedName("name") var title: String,
    var owners: Int,
    var steamRating: Int,
    var price: Float,
    var position: Int,
    var thumb: String
)