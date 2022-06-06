package easy

import java.util.Stack

class ValidParantheses {
    //(){}[]
    //{[()]}
    fun isValid(s: String): Boolean {
        var stack = Stack<Char>()
        for (i in s.indices) {
            when (s[i]) {
                '(', '{', '[' -> {
                    stack.push(s[i])
                }
                ')' -> {
                    if (i == 0 || stack.isEmpty()) return false
                    if(stack.peek() == '{' || stack.peek() == '[') return false
                    if (stack.peek() == '(') stack.pop()
                }
                '}' -> {
                    if (i == 0 || stack.isEmpty()) return false
                    if(stack.peek() == '(' || stack.peek() == '[') return false
                    if (stack.peek() == '{') stack.pop()
                }
                ']' -> {
                    if (i == 0 || stack.isEmpty()) return false
                    if(stack.peek() == '(' || stack.peek() == '{') return false
                    if (stack.peek() == '[') stack.pop()
                }
            }
            if (i == s.lastIndex && stack.isEmpty()) return true
        }
        return false
    }
}