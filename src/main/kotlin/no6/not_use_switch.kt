package no6

/**
 * 爆発的に増殖するswitch分岐の重複の対策
 * （KotlinではWhenで対応する）
 */

fun main() {
    // bad
    val name = MagicManager().getName(MagitType.fire)
    println("magic name: $name")

    // good
    val magic = Fire()
    println("magic name: ${magic.name}")
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
    override val name: String
        get() = "ファイア"
    override val contMagicPoint: Int
        get() = 1
    override val attachPower: Int
        get() = 2
    override val costTechnicalPoint: Int
        get() = 3

}

class Shiden : Magic {
    override val name: String
        get() = "紫電"
    override val contMagicPoint: Int
        get() = 4
    override val attachPower: Int
        get() = 5
    override val costTechnicalPoint: Int
        get() = 6

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
            MagitType.fire -> "ファイア"
            MagitType.shiden -> "紫電"
        }
    }

    // 消費魔法寮を返す
    fun contMagicPoint(magicType: MagitType): Int {
        return when (magicType) {
            MagitType.fire -> 2
            MagitType.shiden -> 3
        }
    }
}

/**
 * 魔法の種類の定義
 */
enum class MagitType {
    fire,  // ファイア、炎の魔法
    shiden // 紫電、雷の魔法
}