package com.kamesuta.obstaclecraft

import net.kunmc.lab.commandlib.CommandLib
import net.kunmc.lab.configlib.ConfigCommand
import net.kunmc.lab.configlib.ConfigCommandBuilder
import org.bukkit.plugin.java.JavaPlugin


/**
 * プラグインのメインクラス
 */
class ObstacleCraft : JavaPlugin() {
    /** ゲームの設定 */
    lateinit var gameConfig: GameConfig

    /** ゲーム進行に関する処理 */
    lateinit var game: Game

    override fun onEnable() {
        // Plugin startup logic
        instance = this

        // コンフィグ
        gameConfig = GameConfig(this)

        // コマンド
        val configCommand: ConfigCommand = ConfigCommandBuilder(gameConfig).build()
        CommandLib.register(this, GameCommand(configCommand))

        // ゲーム進行
        game = Game()
        server.pluginManager.registerEvents(game, this)
        server.scheduler.runTaskTimer(this, game::tickState, 0, 20)
    }

    override fun onDisable() {
        // Plugin shutdown logic
        game.stop()
    }

    companion object {
        /** プラグインインスタンス */
        lateinit var instance: ObstacleCraft
            private set
    }
}