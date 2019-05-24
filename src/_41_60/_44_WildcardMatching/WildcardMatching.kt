package _41_60._44_WildcardMatching
/*

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
*/


class Solution {
    fun isMatch(str: String, pattern: String): Boolean {
        var s = 0
        var p = 0
        var match = 0
        var starIdx = -1
        while (s < str.length) {
            // advancing both pointers
            if (p < pattern.length && (pattern[p] == '?' || str[s] == pattern[p])) {
                s++
                p++
            } else if (p < pattern.length && pattern[p] == '*') {
                starIdx = p
                match = s
                p++
            } else if (starIdx != -1) {
                p = starIdx + 1
                match++
                s = match
            } else
                return false//current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            // last pattern pointer was *, advancing string pointer
            // * found, only advancing pattern pointer
        }

        //check for remaining characters in pattern
        while (p < pattern.length && pattern[p] == '*')
            p++

        return p == pattern.length
    }
}

