package prob36

import com.sun.org.apache.xpath.internal.functions.FuncFalse
import org.junit.Test

/*

Input:
[
['5','3','.','.','7','.','.','.','.'],
['6','.','.','1','9','5','.','.','.'],
['.','9','8','.','.','.','.','6','.'],
['8','.','.','.','6','.','.','.','3'],
['4','.','.','8','.','3','.','.','1'],
['7','.','.','.','2','.','.','.','6'],
['.','6','.','.','.','.','2','8','.'],
['.','.','.','4','1','9','.','.','5'],
['.','.','.','.','8','.','.','7','9']
]
Output: true
Example 2:

Input:
[
['8','3','.','.','7','.','.','.','.'],
['6','.','.','1','9','5','.','.','.'],
['.','9','8','.','.','.','.','6','.'],
['8','.','.','.','6','.','.','.','3'],
['4','.','.','8','.','3','.','.','1'],
['7','.','.','.','2','.','.','.','6'],
['.','6','.','.','.','.','2','8','.'],
['.','.','.','4','1','9','.','.','5'],
['.','.','.','.','8','.','.','7','9']
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being
modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.*/

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        fun check_colums(): Boolean{

            val bset = HashSet<Char>()
            for (b in board){
                bset.clear()
                for (c in b){
                    if (c != '.'){
                        if (!bset.add(c))
                            return false
                    }
                }
            }
            return true
        }

        fun check_rows(): Boolean {
            val bset = HashSet<Char>()
            for (i in 0 until 9){
                bset.clear()
                for (j in 0 until 9){
                    if (board[j][i] !='.'){
                        if(!bset.add(board[j][i]))
                            return false
                    }
                }
            }
            return true
        }

        fun check_box(): Boolean {
            val bset = HashSet<Char>()
            for (i in 0 until 9){
                bset.clear()
                for(j in 0 until 9) {
                    val x = (i/3)*3 + j/3
                    val y = (i%3)*3 + j%3
                    if (board[x][y] !='.'){
                        if(!bset.add(board[x][y]))
                            return false
                    }
                }
            }
            return true
        }

        return check_colums() and check_rows() and check_box()
    }
}


//[['.','.','4','.','.','.','6','3','.'],['.','.','.','.','.','.','.','.','.'],['5','.','.','.','.','.','.','9','.'],['.','.','.','5','6','.','.','.','.'],['4','.','3','.','.','.','.','.','1'],['.','.','.','7','.','.','.','.','.'],['.','.','.','5','.','.','.','.','.'],['.','.','.','.','.','.','.','.','.'],['.','.','.','.','.','.','.','.','.']]

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

class Tests {
    @Test fun test1() {
        assert(Solution().isValidSudoku(input))
    }
}