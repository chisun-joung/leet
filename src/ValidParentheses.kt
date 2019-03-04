package prob20

import org.junit.Test
import kotlin.test.assertEquals

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Note that an empty string is also considered valid.
//
//Example 1:
//
//Input: "()"
//Output: true
//Example 2:
//
//Input: "()[]{}"
//Output: true
//Example 3:
//
//Input: "(]"
//Output: false
//Example 4:
//
//Input: "([)]"
//Output: false
//Example 5:
//
//Input: "{[]}"
//Output: true

class Solution {
    fun isValid(s: String): Boolean {
        var temp = mutableListOf<String>()
        if (s.isEmpty()) return true
        for(i in 0 until s.length){
            when(s[i]){
                '(' -> temp.add("(")
                '{' -> temp.add("{")
                '[' -> temp.add("[")
                ')' -> if (temp.lastOrNull() == "(") {
                    temp.removeAt(temp.lastIndex)
                } else {
                    return false
                }
                '}' -> if (temp.lastOrNull() == "{") {
                    temp.removeAt(temp.lastIndex)
                } else {
                    return false
                }
                ']' -> if (temp.lastOrNull() == "[") {
                    temp.removeAt(temp.lastIndex)
                } else {
                    return false
                }
                else -> return false
            }
        }
        return temp.isEmpty()
    }
}


class Tests {
    @Test
    fun test_0(){
        assertEquals(true,Solution().isValid(""))
    }

    @Test
    fun test_1(){
        assertEquals(true,Solution().isValid("()"))
    }

    @Test
    fun test_2(){
        assertEquals(true,Solution().isValid("()[]{}"))
    }

    @Test
    fun test_3(){
        assertEquals(false,Solution().isValid("(]"))
    }

    @Test
    fun test_4(){
        assertEquals(false,Solution().isValid("([)]"))
    }

    @Test
    fun test_5(){
        assertEquals(true,Solution().isValid("{[]}"))
    }

    @Test
    fun test_6(){
        assertEquals(false,Solution().isValid("]"))
    }
}