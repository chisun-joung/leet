package longestsubstring

//Given a string, find the length of the longest substring without repeating characters.
//
//Example 1:
//
//Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var i = 0
        var j = 0
        var mset = mutableSetOf<Char>()
        if (s.length > 0) {
            max = 1
        }
        while ( i < (s.length-1)){
            j = 1
            mset.clear()
            while (s[i] != s[i+j]){
                if(!mset.add(s[i+j]))
                    break
                if((++j + i) == s.length) break

            }
            if( max < j ) max = j
            i++
            if ((i+max) >= s.length) i = s.length
        }
        return max
    }
}

fun main(args: Array<String>) {

    val s = "kwwkew"

    println(Solution().lengthOfLongestSubstring(s))
}