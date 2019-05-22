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

        if (num1 == "0" || num2 == "0") return "0"

        val result = StringBuilder()
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
            result.setLength(0)
            carry=0
        }

        for(i in 0 until tempResult.last().length){
            var digit = 0
            var tempsum = 0
            for (temp in tempResult){
                if (i < temp.length) {
                    tempsum += temp[i].toInt() - 48
                }
            }
            digit = (tempsum + carry) % 10
            carry = (tempsum + carry) / 10
            result.append(digit)
        }
        if (carry!=0) result.append(carry)


        return result.reversed().toString()
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

    @Test
    fun multiply4(){
        assertEquals("176",Solution().multiply("8","22"))
    }

    @Test
    fun multiply5(){
        assertEquals("56088",Solution().multiply("123","456"))
    }

    @Test
    fun multiply6(){
        assertEquals("4282869185670",Solution().multiply("12389765","345678"))
    }

    @Test
    fun multiply7(){
        assertEquals("0",Solution().multiply("9133","0"))
    }


}