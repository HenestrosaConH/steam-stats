package com.josecarloslh.steamstats.utils

object FloatFormatter {
    //TODO: Change currency
    val FORMAT_PRICE = "$%.2f"
    fun formatPrice(price: Float) = String.format(FORMAT_PRICE, price)

    val FORMAT_DISCOUNT_PERCENTAGE = "%.0f%%"
    fun formatPercentage(percentage: Float) = String.format(FORMAT_DISCOUNT_PERCENTAGE, percentage)
}