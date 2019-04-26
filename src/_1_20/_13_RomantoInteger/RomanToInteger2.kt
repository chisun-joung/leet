package _1_20._13_RomantoInteger2

import org.junit.Test
import kotlin.test.assertEquals

class Solution {

    fun romanToInt(s: String): Int {
        if (s.isEmpty() ) return 0
        var result = 0

        var siter = s.toList().listIterator()

        while (siter.hasNext()){
            when(siter.next()){
                'I' -> {
                    result++
                    if(siter.hasNext()){
                        when(siter.next()){
                            'V' -> result +=3
                            'X' -> result +=8
                            'I' -> result++
                            else -> siter.previous()
                        }
                    }
                }
                'V' -> result += 5
                'X' -> {
                    result += 10
                    if(siter.hasNext()){
                        when(siter.next()){
                            'L' -> result +=30
                            'C' -> result +=80
                            'X' -> result +=10
                            else -> siter.previous()
                        }
                    }
                }
                'L' -> result += 50
                'C' -> {
                    result +=100
                    if(siter.hasNext()){
                        val temp = siter
                        when(siter.next()){
                            'D' -> result +=300
                            'M' -> result +=800
                            'C' -> result +=100
                            else -> siter.previous()
                        }
                    }
                }
                'D' -> result += 500
                'M' -> result += 1000
            }
        }

        return result
    }
}

class Tests {
    @Test
    fun test_I(){
        assertEquals(1, Solution().romanToInt("I"))
    }
    @Test
    fun test_III(){
        assertEquals(3, Solution().romanToInt("III"))
    }

    @Test
    fun test_IV(){
        assertEquals(4, Solution().romanToInt("IV"))
    }

    @Test
    fun test_IX(){
        assertEquals(9, Solution().romanToInt("IX"))
    }

    @Test
    fun test_LVIII(){
        assertEquals(58, Solution().romanToInt("LVIII"))
    }

    @Test
    fun test_MCMXCIV(){
        assertEquals(1994, Solution().romanToInt("MCMXCIV"))
    }

    @Test
    fun test_DCXXI(){
        assertEquals(621, Solution().romanToInt("DCXXI"))
    }

    @Test
    fun test_DXXI(){
        assertEquals(521, Solution().romanToInt("DXXI"))
    }

}