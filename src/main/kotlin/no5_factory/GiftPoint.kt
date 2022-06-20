package no5_factory

/**
 * 5.2.1 Factoryメソッド
 * 例として、ECサイトで新規入会時に無料お買い物ポイントが付与される、という仕組みを表現している
 *
 * 初期化ロジックの分散を防ぐため、companion objectにFactoryメソッドを用意している。
 *
 */
data class GiftPoint constructor(private var _value: Int = 0) {
    // ポイントの値の取得
    val value: Int
        get() = _value

    init {
        if (_value < 0) {
            throw IllegalArgumentException("ポイントが0以上ではありません")
        }
    }

    companion object {
        // 標準会員向け入会ギフトポイント
        private const val STANDARD_MEMBERSHIP_POINT = 3000

        // プレミア会入会ギフトポイント
        private const val PREMIUM_MEMBERSHIP_POINT = 10000

        // 標準会員入会ギフトポイント Factoryメソッド
        fun forStandardMembership() = GiftPoint(STANDARD_MEMBERSHIP_POINT)

        // プレミア会入会ギフトポイント Factoryメソッド
        fun forPremiumMembership() = GiftPoint(PREMIUM_MEMBERSHIP_POINT)
    }
}
