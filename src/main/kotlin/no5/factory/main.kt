package no5.factory

fun main() {
    val standardPoint = GiftPoint.forStandardMembership()
    println("standard point is ${standardPoint.value}")

    val premiumPoint = GiftPoint.forPremiumMembership()
    println("premiumPoint point is ${premiumPoint.value}")

    val totalPoint = standardPoint + premiumPoint
    println("standardPoint + premiumPoint = ${totalPoint.value}")
}
