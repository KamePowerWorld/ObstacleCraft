package com.kamesuta.obstaclecraft

import org.bukkit.event.Listener


/**
 * ゲーム進行に関する処理
 */
class Game : Listener {
    /** プレイ中かどうか */
    var state: GameState? = null

    /** ゲーム開始 */
    fun start() {
        // 開始
        state = GameState()
    }

    /** ゲーム終了 */
    fun stop() {
        // 終了
        state = null
    }

    /** 毎秒呼ばれる、カウントダウンなどのゲーム進行を行う */
    fun tickState() {
        val state = state ?: return

        // ゲームを進行する
        if (state.playGame.hasNext()) {
            state.playGame.next()
        }
    }
}