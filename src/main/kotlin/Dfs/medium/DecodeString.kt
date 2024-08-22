package Dfs.medium

import java.util.*

//@author Usman Fani

//Leetcode: 394

//Example 1:
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"

//Example 2:
//Input: s = "3[a2[c]]"
//Output: "accaccacc"

//Example 3:
//Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
class DecodeString {
    fun decodeString(s: String): String{
        var numStack = Stack<Int>()
        var strStack = Stack<String>()
        var num = 0
        var str:String = ""
        for(i in s){
            if(i in '0'..'9'){
                num = (num*10)+(i-'0')
            }
            else if(i == '['){
                numStack.push(num)
                strStack.push(str)
                num = 0
                str = ""
            }
            else if(i == ']'){
                val tempNum = numStack.peek()
                numStack.pop()
                var tempString = ""
                repeat(tempNum){
                    tempString += str
                }
                str = strStack.peek() + tempString
                strStack.pop()
            }
            else{
                str += i
            }
        }
        return str
    }
}