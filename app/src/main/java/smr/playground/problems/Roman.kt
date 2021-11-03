package smr.playground.problems

import java.util.*

fun main() {
//    test("I")
//    test("II")
//    test("III")
//    test("IV")
//    test("V")
//    test("VI")
//    test("VII")
//    test("VIII")
//    test("IX")
//    test("X")
    test("XLV")
    test("XCV")
}

fun test(s: String) {
    println("$s : ${romanToInt(s)}")
}

fun romanToInt(s: String): Int {
    var result = 0
    val map : Map<Char,Int> = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )
    for (i in 0 until s.length - 1) {
        val num = map[s[i]]!!
        val nxt = map[s[i+1]]!!
        if (num < nxt) {
            result -= num
        } else {
            result += num
        }
    }
    result+=map[s.last()]!!
    return result
}

fun old(s: String): Int {
    var result = 0
    val stack = Stack<Char>()
    for (ch in s.toCharArray()) {
        stack.push(ch)
    }
    var ch: Char? = stack.pop()
    var lastChar: Char? = null
    while (ch != null) {
        result += when (ch) {
            'I' -> {
                when (lastChar) {
                    'V', 'X' -> -1
                    else -> 1
                }
            }
            'V' -> 5
            'X' -> {
                when (lastChar) {
                    'L', 'C' -> -10
                    else -> 10
                }
            }
            'L' -> 50
            'C' -> {
                when (lastChar) {
                    'D', 'M' -> -100
                    else -> 100
                }
            }
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
        //result += getIntForChar(ch)
        lastChar = ch
        try {
            ch = stack.pop()
        } catch (e: EmptyStackException) {
            break
        }
    }
    return result
}



