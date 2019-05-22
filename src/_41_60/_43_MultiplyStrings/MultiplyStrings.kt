package _41_60._43_MultiplyStrings

import org.junit.Test
import kotlin.test.assertEquals

/*


Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.*/


class Solution {
    fun multiply(num1: String, num2: String): String {
        val result = StringBuilder()
        val n = num1.length
        val m = num2.length
        val tempResult = mutableListOf<String>()
        var carry = 0
        for ((index,i) in num2.reversed().withIndex()){
            val num_i = i.toInt() - 48
            for (z in 0 until index) {
                result.append('0')
            }
            for (j in num1.reversed()){
                val num_j = j.toInt() - 48
                val digit = (num_i * num_j + carry) % 10
                carry = (num_i * num_j + carry) / 10
                result.append(digit)
            }
            if(carry != 0) result.append(carry)
            tempResult.add(result.toString())
            result.clear()
        }

        

        return tempResult[0].reversed().toString()
    }
}

class Tests {
    @Test
    fun multiply1(){
        assertEquals("6",Solution().multiply("2","3"))
    }

    @Test
    fun multiply2(){
        assertEquals("16",Solution().multiply("2","8"))
    }

    @Test
    fun multiply3(){
        assertEquals("176",Solution().multiply("22","8"))
    }



}