package com.kamesuta.obstaclecraft

import org.bukkit.ChatColor

/** チャットのプレフィックス */
val CHAT_PREFIX = "${ChatColor.GRAY}◆${ChatColor.RESET}"

/** 分,秒の文字列を返す */
val Int.minuteSecondString: String
    get() {
        val minute = this / 60
        val second = this % 60
        // 1分未満の場合は秒のみ表示、秒数が0の場合は分のみ表示
        return if (minute == 0) {
            "${second}秒"
        } else if (second == 0) {
            "${minute}分"
        } else {
            "${minute}分${second}秒"
        }
    }

