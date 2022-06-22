package no6

/**
 * 爆発的に増殖するswitch分岐の重複の対策
 * （KotlinではWhenで対応する）
 */

fun main() {
    // bad
    val name = MagicManager().getName(MagitType.Fire)
    println("bad magic name: $name")

    // good 1
    val magic = Fire()
    println("good 1 magic name: ${magic.name}")

    // good 2
    val magic2 = Magic2.Fire2
    println("good 2 magic name: ${magic2.name}")

    // good 3
    val magics = HashMap<MagitType, Magic>()
    magics[MagitType.Fire] = Fire()
    magics[MagitType.Shiden] = Shiden()
    println("good 3 magic name: ${magics[MagitType.Fire]?.name}")
}

/**
 * Goodパターン
 * 条件分岐を一箇所にまとめる
 *
 */

interface Magic {
    val name: String
    val contMagicPoint: Int
    val attachPower: Int
    val costTechnicalPoint: Int
}

class Fire : Magic {
    override val name = "ファイア"
    override val contMagicPoint = 1
    override val attachPower = 2
    override val costTechnicalPoint = 3

}

class Shiden : Magic {
    override val name = "紫電"
    override val contMagicPoint = 4
    override val attachPower = 5
    override val costTechnicalPoint = 6
}

private sealed class Magic2 {
    open val name: String = ""
    open val contMagicPoint: Int = 0
    open val attachPower: Int = 0
    open val costTechnicalPoint: Int = 0

    object Fire2 : Magic2() {
        override val name = "ファイア"
        override val contMagicPoint = 1
        override val attachPower = 2
        override val costTechnicalPoint = 3
    }

    object Shiden : Magic2() {
        override val name = "紫電"
        override val contMagicPoint = 4
        override val attachPower = 5
        override val costTechnicalPoint = 6
    }
}

// -----

/**
 * アンチパターン
 *
 * これだと新たな魔法が追加されるたびに、whenが増えていく
 * さらに、項目が増えるとその分whenがふえていく
 *
 */
private class MagicManager {

    // 名前を返す
    fun getName(magicType: MagitType): String {
        return when (magicType) {
            MagitType.Fire -> "ファイア"
            MagitType.Shiden -> "紫電"
        }
    }

    // 消費魔法寮を返す
    fun contMagicPoint(magicType: MagitType): Int {
        return when (magicType) {
            MagitType.Fire -> 2
            MagitType.Shiden -> 3
        }
    }
}

/**
 * 魔法の種類の定義
 */
private enum class MagitType {
    Fire,  // ファイア、炎の魔法
    Shiden // 紫電、雷の魔法
}