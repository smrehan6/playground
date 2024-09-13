package smr.playground.problems

class IntToWords {
    fun numberToWords(num: Int): String {
        if(num ==0) return "Zero"
        var res = ""
        var x = num
        var p = 0
        while(x>0) {
            val n = x%1000
            if(n > 0) {
                res = "${process3(n)} ${pow(p)} $res".trim()
            }
            println(res)
            p++
            x /= 1000
        }
        return res
    }

    fun pow(p:Int): String {
        return when(p) {
            1 -> "Thousand"
            2 -> "Million"
            3 -> "Billion"
            4 -> "Trillion"
            else -> ""
        }
    }

    // 000 - 999
    fun process3(num: Int): String {
        return when(num) {
            0 -> ""
            in 1..9 -> process9(num)
            in 10..19 -> process19(num)
            in 20..99 -> process99(num)
            else -> {
                val h = num/100
                val d = num%100
                process9(h) + " Hundred" + if(d>0) " ${process3(d)}" else ""
            }
        }
    }

    fun process9(num:Int): String {
        return when(num) {
            1 -> "One"
            2 -> "Two"
            3 -> "Three"
            4 -> "Four"
            5 -> "Five"
            6 -> "Six"
            7 -> "Seven"
            8 -> "Eight"
            9 -> "Nine"
            else -> ""
        }
    }

    fun process19(num: Int): String {
        return when(num) {
            10 -> "Ten"
            11 -> "Eleven"
            12 -> "Twelve"
            13 -> "Thirteen"
            14 -> "Fourteen"
            15 -> "Fifteen"
            16 -> "Sixteen"
            17 -> "Seventeen"
            18 -> "Eighteen"
            19 -> "Nineteen"
            else -> "?"
        }
    }

    // 20-99
    fun process99(num:Int): String {
        // 2 - 9
        val t = (num/10)%10
        // 0 - 9
        val x = num%10
        val tt = when(t) {
            2 -> "Twenty"
            3 -> "Thirty"
            4 -> "Forty"
            5 -> "Fifty"
            6 -> "Sixty"
            7 -> "Seventy"
            8 -> "Eighty"
            9 -> "Ninety"
            else -> ""
        }
        val xx = process9(x)
        return "$tt $xx".trim()
    }
}