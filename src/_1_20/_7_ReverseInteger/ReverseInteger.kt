package prob7

import org.junit.Test
import kotlin.test.assertEquals

//Given a 32-bit signed integer, reverse digits of an integer.
//
//Example 1:
//
//Input: 123
//Output: 321
//Example 2:
//
//Input: -123
//Output: -321
//Example 3:
//
//Input: 120
//Output: 21
//Note:
//Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

class Solution {
    fun reverse(x: Int): Int {
        if (x <= Math.pow(-2.0,31.0)) return 0
        if (x > (Math.pow(2.0,31.0)-1)) return 0
        var temp =0
        if (x < 0) temp = Math.abs(x) else temp = x
        val result = temp.toString().reversed().toLong()
        if (result < Math.pow(-2.0,31.0)) return 0
        if (result > (Math.pow(2.0,31.0)-1)) return 0
        return if (x < 0) (0 - result).toInt() else result.toInt()
    }
}

class Tests {
    @Test
    fun testReverseInteger() {
        assertEquals(-321, Solution().reverse(-123))
    }
}