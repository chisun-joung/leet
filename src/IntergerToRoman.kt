package prob12

import org.junit.Test
import java.lang.StringBuilder
import kotlin.test.assertEquals

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
//
//Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.
//Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
//
//Example 1:
//
//Input: 3
//Output: "III"
//Example 2:
//
//Input: 4
//Output: "IV"
//Example 3:
//
//Input: 9
//Output: "IX"
//Example 4:
//
//Input: 58
//Output: "LVIII"
//Explanation: L = 50, V = 5, III = 3.
//Example 5:
//
//Input: 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

class Solution {
    fun intToRoman(num: Int): String {
        if (num < 1 || num > 3999) return ""
        var temp = num
        var result = StringBuilder()
        var roman = temp / 1000
        temp %= 1000

        when(roman){
            1 -> result.append("M")
            2 -> result.append("MM")
            3 -> result.append("MMM")
            else -> ""
        }

        roman = temp / 100
        temp = temp % 100

        when(roman){
            1 -> result.append("C")
            2 -> result.append("CC")
            3 -> result.append("CCC")
            4 -> result.append("CD")
            5 -> result.append("D")
            6 -> result.append("DC")
            7 -> result.append("DCC")
            8 -> result.append("DCCC")
            9 -> result.append("CM")
            else -> ""
        }

        roman = temp / 10
        temp = temp % 10

        when(roman){
            1 -> result.append("X")
            2 -> result.append("XX")
            3 -> result.append("XXX")
            4 -> result.append("XL")
            5 -> result.append("L")
            6 -> result.append("LX")
            7 -> result.append("LXX")
            8 -> result.append("LXXX")
            9 -> result.append("XC")
            else -> ""
        }




        when(temp){
            1 -> result.append("I")
            2 -> result.append("II")
            3 -> result.append("III")
            4 -> result.append("IV")
            5 -> result.append("V")
            6 -> result.append("VI")
            7 -> result.append("VII")
            8 -> result.append("VIII")
            9 -> result.append("IX")
            else -> ""
        }


        return result.toString()
    }
}


class Tests {
    @Test fun testroman1(){
        assertEquals("III", Solution().intToRoman(3))
    }

    @Test fun testroman2(){
        assertEquals("LVIII", Solution().intToRoman(58))
    }

    @Test fun testroman3(){
        assertEquals("MCMXCIV", Solution().intToRoman(1994))
    }
}