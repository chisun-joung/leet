package _41_60._52_NQueensII

import kotlin.math.abs


/*

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
[".Q..",  // Solution 1
"...Q",
"Q...",
"..Q."],

["..Q.",  // Solution 2
"Q...",
"...Q",
".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.*/


class Solution {
    fun solveNQueens(n: Int): Int {

        val nPath = IntArray(n)
        var result = 0
        fun nQueen_Promising(row: Int) : Boolean {
            for (i in 0 until row) {
                if (nPath[row] == nPath[i] || row - i == abs(nPath[row]-nPath[i])){
                    return false
                }
            }
            return true
        }
        fun nQueen_backtracking(row: Int): Int {

            for (i in 0 until n){
                nPath[row]  = i
                if ( nQueen_Promising(row)) {
                    if(row == n - 1) {
                        result++
                    }
                    else {
                        nQueen_backtracking(row + 1)
                    }
                }
            }

            return result
        }


        return nQueen_backtracking(0)
    }
}

fun main() {
    val result = Solution().solveNQueens(8)

    print(result)
}