package com.kamesuta.obstaclecraft

import net.kunmc.lab.configlib.BaseConfig
import net.kunmc.lab.configlib.value.IntegerValue
import org.bukkit.plugin.Plugin


/**
 * プラグインの設定
 */
class GameConfig(plugin: Plugin) : BaseConfig(plugin) {
    /** 開始前の待機時間 */
    val cooldown = IntegerValue(5)
        .description("開始前の待機時間")

    /** 終了後の休憩時間の秒数 */
    val interval = IntegerValue(15)
        .description("終了後の休憩時間の秒数")

    /** アイテム選択中の制限時間の秒数 */
    val selecting = IntegerValue(10)
        .description("アイテム選択中の制限時間の秒数")

    /** ゲームの制限時間の秒数 */
    val playing = IntegerValue(120)
        .description("ゲームの制限時間の秒数")
}