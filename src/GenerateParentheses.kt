package prob22

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//[
//"((()))",
//"(()())",
//"(())()",
//"()(())",
//"()()()"
//]

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        var result = mutableListOf<String>()
        fun go(str: String, open:Int,close:Int){
            if (str.length == 2*n){
                result.add(str)
                return
            }
            if(open < n)
                go("$str(",open + 1, close)
            if(close < open)
                go("$str)", open, close + 1)
        }

        go("",0,0)

        return result
    }
}

fun main() {
    println(Solution().generateParenthesis(5))
}