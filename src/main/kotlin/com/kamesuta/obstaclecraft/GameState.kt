package com.kamesuta.obstaclecraft

/** ゲームのステート */
class GameState {
    /** カウントダウン */
    private var countDown = 0

    /** ゲームのフェーズ */
    enum class Phase {
        /** 試合前カウントダウン */
        COOLDOWN,

        /** アイテム選択中 */
        SELECTING,

        /** ゲーム中 */
        PLAYING,

        /** インターバル中 */
        INTERVAL,
    }

    /** 現在のフェーズ */
    var phase = Phase.COOLDOWN

    /** ゲーム進行 */
    val playGame = sequence {
        while (true) {
            // 開始前カウントダウン開始
            phase = Phase.COOLDOWN
            countDown = ObstacleCraft.instance.gameConfig.cooldown.value()
            // 開始前カウントダウン
            while (countDown >= 0) {
                // TODO: タイトル出したりする
                countDown--
                yield(true)
            }

            // アイテム選択
            phase = Phase.SELECTING
            countDown = ObstacleCraft.instance.gameConfig.selecting.value()
            // TODO: インベントリ表示させてアイテム選択させる
            // 開始前カウントダウン
            while (countDown >= 0) {
                // TODO: タイトル出したりする
                countDown--
                yield(true)
            }

            // ゲーム開始
            phase = Phase.PLAYING
            countDown = ObstacleCraft.instance.gameConfig.playing.value()
            // TODO: タイトル出したりする
            while (countDown >= 0) {
                // TODO: タイトル出したりする
                countDown--
                yield(true)
            }

            // インターバル
            // TODO: タイトル出したりする
            phase = Phase.INTERVAL
            countDown = ObstacleCraft.instance.gameConfig.interval.value()
            // インターバルカウントダウン
            while (countDown >= 0) {
                // TODO: タイトル出したりする
                countDown--
                yield(true)
            }
        }
    }.iterator()
}