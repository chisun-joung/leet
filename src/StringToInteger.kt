package prob8

import org.junit.Test
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.test.assertEquals


//Implement atoi which converts a string to an integer.
//
//The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//
//The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//
//If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//
//If no valid conversion could be performed, a zero value is returned.
//
//Note:
//
//Only the space character ' ' is considered as whitespace character.
//Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.





class Solution {
    fun myAtoi(str: String): Int {
        var temp = str
        var sign = 0
        var Conv = true
        var result = BigInteger.ZERO
        if (temp.length == 0) return 0

        while (temp.length != 0 && temp[0] == ' '){
            temp = temp.removePrefix(" ")
        }

        if (temp.length == 0) return 0
        when(temp[0]) {
            '+' -> {
                sign = 1
                temp = temp.removePrefix("+")
            }
            '-' -> {
                sign = -1
                temp = temp.removePrefix("-")
            }
            else -> {
                sign = 1
            }
        }
        if(temp.length == 0 ) return 0

        for (i in 0 until temp.length) {
            if (!temp[i].isDigit()){
                if (i > 0 ) {
                    temp = temp.take(i)
                    Conv = true
                }
                else{
                    Conv = false
                }
                break
            }
        }
        if(Conv){
            if (sign == 1 )
                result = temp.toBigInteger()
            if (sign == -1 )
                result = result - temp.toBigInteger()
            if (result < Int.MIN_VALUE.toBigInteger()) result = Int.MIN_VALUE.toBigInteger()
            if (result > Int.MAX_VALUE.toBigInteger()) result = Int.MAX_VALUE.toBigInteger()
        }
        return result.toInt()
    }
}



class Tests {
    @Test fun WhenInputBigNumber(){
        assertEquals(Int.MAX_VALUE, Solution().myAtoi("20000000000000000000"))
    }

    @Test fun WhenInputOneWhiteSpace() {
        assertEquals(0, Solution().myAtoi(" "))
    }
    @Test fun WhenInvalidResultZero() {
        assertEquals(0, Solution().myAtoi("words and 987"))
    }

    @Test fun RemoveWhiteSpace() {
        assertEquals(123, Solution().myAtoi("     123"))
    }

    @Test fun RemoveWhiteSpacePlus() {
        assertEquals(123, Solution().myAtoi("     +123"))
    }

    @Test fun RemoveWhiteSpaceMinus() {
        assertEquals(123, Solution().myAtoi("     +123"))
    }

    @Test fun RemoveNonIntegral() {
        assertEquals(4193, Solution().myAtoi("4193 with words"))
    }

    @Test fun MoreThanIntMax() {
        assertEquals(Int.MAX_VALUE, Solution().myAtoi("91283472332"))
    }

    @Test fun LessThanIntMin() {
        assertEquals(Int.MIN_VALUE, Solution().myAtoi("-91283472332"))
    }






}