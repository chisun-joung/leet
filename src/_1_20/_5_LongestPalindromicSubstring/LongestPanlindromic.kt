package _1_20._5_LongestPalindromicSubstring
//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//Example 1:
//
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//Example 2:
//
//Input: "cbbd"
//Output: "bb"


class Solution {
    fun longestPalindrome(s: String): String {
        val l = s.length
        var longPalindrome = ""
        for (i in 0..(l-1)){
            if( (l-i) <=longPalindrome.length ) break
            for (j  in l downTo i){

                if ((j-i) <= longPalindrome.length ) break
                var forward_s = s.substring(i,j)
                var backward_s = forward_s.reversed()
                if (backward_s == forward_s && longPalindrome.length < forward_s.length)
                    longPalindrome = forward_s
            }

        }

        return longPalindrome
    }
}


fun main(args: Array<String>) {
    val s = "cbbd"


    println("ans " + Solution().longestPalindrome(s))
}
