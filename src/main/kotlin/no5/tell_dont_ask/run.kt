package no5.tell_dont_ask

fun main() {

    //    NGな例、呼び出し側からオブジェクトの内部状態を尋ねるべきではない
    //    （EquipmentsのcanChange変数をifで判定している部分）

    //    val equipments = no5.tell_dont_ask.Equipments()
    //    if (equipments.canChange) {
    //        equipments.deactivateAll()
    //    }


    // OKな例、メソッドを呼び出すだけで内部状態はしらなくてよい
    // equipments.deactivateAll()
}

/***
 * 例として、装備中の防具一覧を表現するクラスがあったとする
 */
data class Equipments(
    private var canChange: Boolean,
    private var head: Equipment,
    private var armor: Equipment,
    private var arm: Equipment,
) {

    /**
     * 鎧を装備する
     * @param newArmor 装備する鎧
     */
    fun equipArmor(newArmor: Equipment) {
        if (!canChange) return

        armor = newArmor
    }

    /**
     * 全装備解除
     */
    fun deactivateAll() {
        if (!canChange) return

        head = Equipment.EMPTY
        armor = Equipment.EMPTY
        arm = Equipment.EMPTY
    }
}

/**
 * 装備できる防具クラス
 */
data class Equipment(
    val name: String,
    val price: Int,
    val defence: Int,
    val magicDefence: Int,
) {
    companion object {
        // EMPTYの仕様は適当
        val EMPTY = Equipment(
            name = "",
            price = 0,
            defence = 0,
            magicDefence = 0,
        )
    }
}