package prob9

import org.junit.Test
import kotlin.test.assertEquals

//Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
//Example 1:
//
//Input: 121
//Output: true
//Example 2:
//
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//Example 3:
//
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


class Solution {
    fun isPalindrome(x: Int): Boolean {
        var temp = x
        if (x < 0 || (x%10 == 0 && x!=0) ) return false
        var revertedNumber = 0
        while (temp > revertedNumber) {
            revertedNumber = revertedNumber * 10 + temp % 10
            temp /= 10
        }
        return temp == revertedNumber || temp == revertedNumber/10
    }
}


class Tests {
    @Test fun test1() {
        assert(Solution().isPalindrome(121))
    }

    @Test fun test2() {
        assertEquals(false,Solution().isPalindrome(-121))
    }

    @Test fun test3() {
        assertEquals(false, Solution().isPalindrome(10))
    }

    @Test fun test4() {
        assertEquals(false, Solution().isPalindrome(12111))
    }
}