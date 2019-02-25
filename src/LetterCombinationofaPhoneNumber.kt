package prob17

//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
//Example:
//
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//Note:
//
//Although the above answer is in lexicographical order, your answer could be in any order you want.



class Solution {
    val digitsToString = mapOf("2" to "abc", "3" to "def", "4" to "ghi", "5" to "jkl", "6" to "mno", "7" to "pqrs", "8" to "tuv", "9" to "wxyz")
    fun letterCombinations(digits: String): List<String> {
        var result = mutableListOf<String>()
        fun go(digits:String, acc: String) {
            if(digits.isEmpty()) result.add(acc)
            val first = digits.take(1)
            val temp = digitsToString[first]
            for (i in 0 until (temp?.length ?: 0)){
                go(digits.drop(1), acc + temp?.get(i))
            }
        }

        if (digits.isEmpty()) return result
        go(digits,"")
        return result
    }
}


fun main() {
    println(Solution().letterCombinations("2347"))
}