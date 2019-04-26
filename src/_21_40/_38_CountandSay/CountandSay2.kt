package _21_40._38_CountandSay2

import org.junit.Test
import kotlin.test.assertEquals

/*

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.



Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"*/


class Solution {
    fun countAndSay(n: Int): String {
        var s = "1"
        for (line in 1 until n){
            s = next(s)
        }
        return s
    }

    private fun next(s: String): String {
        var s1 = s
        var length = 1
        var head = s1[0]
        var result = ""
        for (i in 1 until s1.length) {
            if (s1[i] == head) {
                length++
            } else {
                result = "$result$length$head"
                length = 1
                head = s1[i]
            }
        }
        s1 = "$result$length$head"
        return s1
    }
}



class Tests {
    @Test fun test_1() {
        assertEquals("1", Solution().countAndSay(1))
    }

    @Test fun test_2() {
        assertEquals("11", Solution().countAndSay(2))
    }

    @Test fun test_3() {
        assertEquals("21", Solution().countAndSay(3))
    }
    @Test fun test_4() {
        assertEquals("1211", Solution().countAndSay(4))
    }
    @Test fun test_5() {
        assertEquals("111221", Solution().countAndSay(5))
    }
}