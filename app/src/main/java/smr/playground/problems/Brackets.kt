package smr.playground.problems

import java.util.*

fun main() {
    Brackets().test("(){}[]").test("{[)").test("{[()]}")
}

class Brackets {
    fun test(s: String): Brackets {
        println("$s : ${isValid(s)}")
        return this
    }

    private fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (ch in s.toCharArray()) {
            try {
                when (ch) {
                    '[' -> stack.push(ch)
                    '{' -> stack.push(ch)
                    '(' -> stack.push(ch)
                    ')' -> if (stack.pop() != '(') return false
                    '}' -> if (stack.pop() != '{') return false
                    ']' -> if (stack.pop() != '[') return false
                }
            } catch (e: EmptyStackException) {
                return false
            }
        }
        return stack.empty()
    }
}

