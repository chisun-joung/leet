package prob29

import org.junit.Test
import kotlin.test.assertEquals

/*Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
       */


class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        var divid = dividend
        var result = 0
        var divis = divisor
        if (dividend == divisor) return 1
        if (dividend == Int.MIN_VALUE && divisor == -1 ) return Int.MAX_VALUE
        if (dividend == Int.MIN_VALUE){
            if (divisor < 0) divis = -divisor
            while (divid + divis <=0 ){
                divid += divis
                result++
            }
            if (divisor < 0) return result
            else return -result
        }

        if (divid < 0) divid = -divid
        if (divisor < 0) divis = -divisor
        if (divid < divis) return 0
        while (divid - divis >= 0) {
            divid -= divis
            result++
        }
        if (divisor < 0 && dividend > 0) result = -result
        if (dividend < 0 && divisor > 0) result = - result
        return result
    }
}


class Tests {
    @Test fun divide_two0(){
        assertEquals(3,Solution().divide(10,3))
    }
    @Test fun divide_two1(){
        assertEquals(-2,Solution().divide(7,-3))
    }

    @Test fun divide_two2(){
        assertEquals(3,Solution().divide(-10,-3))
    }

    @Test fun divide_two3(){
        assertEquals(-3,Solution().divide(-10,3))
    }
}