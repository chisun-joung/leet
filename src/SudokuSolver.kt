package prob37


/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.*/


class Solution {
    fun solveSudoku(board: Array<CharArray>): Unit {
        fun isValidBox(row: Int, col: Int, num: Char): Boolean {
            val boxOffsetRow = (row/3)*3
            val boxOffsetCol = (col/3)*3
            for(i in 0 until  3)
                for(j in 0 until 3) {
                    if (board[boxOffsetRow + i][boxOffsetCol + j] == num)
                        return false
                }
            return true
        }

        fun isValidRow(row: Int, num: Char): Boolean {
            for (i in 0 until 9) {
                if (board[row][i] == num) return false
            }
            return true
        }

        fun isValidCol(col: Int, num: Char): Boolean {
            for (i in 0 until 9) {
                if (board[i][col] == num) return false
            }
            return true
        }

        fun isValidNumber(row: Int, col: Int,num:Char) :Boolean {
            return isValidRow(row,num) && isValidCol(col,num) && isValidBox(row,col,num)
        }

        fun solveBoard(row:Int, col:Int ): Boolean{
            var r = row
            var c = col
            if (r == 9){
                r = 0
                if(++c == 9) return true
            }
            if(board[r][c] !='.'){
                return solveBoard(r+1,c)
            }
            for (i in 1..9){
                if (isValidNumber(r,c,"$i"[0])){
                    board[r][c] = "$i"[0]
                    if (solveBoard(r+1,c)){
                        return true
                    }
                }
            }
            board[r][c] = '.'
            return false
        }
        solveBoard(0, 0)
    }
}



val input = arrayOf(
    charArrayOf('5','3','.','.','7','.','.','.','.'),
    charArrayOf('6','.','.','1','9','5','.','.','.'),
    charArrayOf('.','9','8','.','.','.','.','6','.'),
    charArrayOf('8','.','.','.','6','.','.','.','3'),
    charArrayOf('4','.','.','8','.','3','.','.','1'),
    charArrayOf('7','.','.','.','2','.','.','.','6'),
    charArrayOf('.','6','.','.','.','.','2','8','.'),
    charArrayOf('.','.','.','4','1','9','.','.','5'),
    charArrayOf('.','.','.','.','8','.','.','7','9')
)

fun main() {
    Solution().solveSudoku(input)
    for (r in input) {
        for (c in r) {
            print("$c, ")
        }
        println()
    }
}