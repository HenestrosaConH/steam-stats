package com.josecarloslh.steamstats.deals

import com.josecarloslh.sdk.Deals

object DealsMapper {

    /**
     * Receives an instance of Deals from the sdk
     * to convert it into DealsModel
     * @return DealsModel instance
     */
    fun fromSdk(deal: Deals): DealsModel {
        return DealsModel(
            deal.title,
            deal.discountPercentage,
            deal.salePrice,
            deal.normalPrice,
            deal.metacriticRating,
            deal.steamRating,
            deal.thumb
        )
    }
}