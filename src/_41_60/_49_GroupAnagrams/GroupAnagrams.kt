package _41_60._49_GroupAnagrams
/*

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
["ate","eat","tea"],
["nat","tan"],
["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.*/


class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if (strs.isEmpty()) return listOf()
        var ans = hashMapOf<String,MutableList<String>>()
        for (s in strs) {
            val key = String(s.toCharArray().sortedArray())
            if (!ans.containsKey(key)) {
                ans[key] =  mutableListOf()
            }
            ans[key]?.add(s)
        }
        return ans.values.toList()
    }
}


fun main() {

    val strs = arrayOf("are", "bat", "ear", "code", "tab","era")
    val ans = Solution().groupAnagrams(strs)
    print(ans)

}