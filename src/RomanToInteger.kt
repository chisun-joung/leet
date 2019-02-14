package prob13

import org.junit.Test
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
//Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
//
//Example 1:
//
//Input: "III"
//Output: 3
//Example 2:
//
//Input: "IV"
//Output: 4
//Example 3:
//
//Input: "IX"
//Output: 9
//Example 4:
//
//Input: "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.


class Solution {

    fun romanToInt(s: String): Int {
        if (s.isEmpty() ) return 0
        var index = 0
        var result = 0
        while (index < s.length) {
            val c = s[index]
            when(c) {
                'I' -> {
                    if((index) < s.length-1){
                        if (s[index+1] == 'V') {
                            result += 4
                            index++
                        } else if (s[index+1] == 'X') {
                            result += 9
                            index++
                        } else {
                            result++
                        }
                    } else {
                        result++
                    }
                }
                'V' -> {
                    result += 5
                }
                'X' -> {
                    if((index) < s.length-1){
                        if (s[index+1] == 'L') {
                            result += 40
                            index++
                        } else if (s[index+1] == 'C') {
                            result += 90
                            index++
                        } else {
                            result += 10
                        }
                    } else {
                        result += 10
                    }
                }
                'L' -> result +=50
                'C' -> {
                    if((index) < s.length-1){
                        if (s[index+1] == 'D') {
                            result += 400
                            index++
                        } else if (s[index+1] == 'M') {
                            result += 900
                            index++
                        } else {
                            result += 100
                        }
                    } else {
                        result += 100
                    }
                }
                'D' -> result +=500
                'M' -> result +=1000
            }
            index++
        }
        return result
    }
}

class Tests {
    @Test fun test_I(){
        assertEquals(1, Solution().romanToInt("I"))
    }
    @Test fun test_III(){
        assertEquals(3, Solution().romanToInt("III"))
    }

    @Test fun test_IV(){
        assertEquals(4, Solution().romanToInt("IV"))
    }

    @Test fun test_IX(){
        assertEquals(9, Solution().romanToInt("IX"))
    }

    @Test fun test_LVIII(){
        assertEquals(58, Solution().romanToInt("LVIII"))
    }

    @Test fun test_MCMXCIV(){
        assertEquals(1994, Solution().romanToInt("MCMXCIV"))
    }

}