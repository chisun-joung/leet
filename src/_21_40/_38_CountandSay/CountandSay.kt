package _21_40._38_CountandSay

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
        var pre = "1"
        var next = ""
        var step = 1
        var count = 0
        while (step < n) {
            var say = pre[0]
            for (i in 0 until pre.length){
                if (say == pre[i]){
                    count++
                    if (i == pre.length-1){
                        next = "$next$count$say"
                    }
                }else if (say != pre[i]) {
                    next = "$next$count$say"
                    count = 1
                    say = pre[i]
                    if (i == pre.length-1){
                        next = "$next$count$say"
                    }
                }
            }
            pre = next
            next = ""
            step++
            count = 0
        }
        return pre
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