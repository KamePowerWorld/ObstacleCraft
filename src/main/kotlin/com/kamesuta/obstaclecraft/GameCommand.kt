package com.kamesuta.obstaclecraft

import net.kunmc.lab.commandlib.Command


/**
 * コマンド
 */
class GameCommand(configCommand: Command) : Command("obstaclecraft") {
    init {
        // サブコマンドを登録
        addChildren(object : Command("start") {
            init {
                execute {
                    // ゲーム開始
                    ObstacleCraft.instance.game.start()
                }
            }
        })
        addChildren(object : Command("stop") {
            init {
                execute {
                    // ゲーム終了
                    ObstacleCraft.instance.game.stop()
                }
            }
        })

        // コンフィグ設定コマンド
        addChildren(configCommand)
    }
}