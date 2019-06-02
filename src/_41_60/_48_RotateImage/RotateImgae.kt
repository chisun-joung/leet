package _41_60._48_RotateImage
/*

Given input matrix =
[
[1,2,3],
[4,5,6],
[7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
[7,4,1],
[8,5,2],
[9,6,3]
]
Example 2:

Given input matrix =
[
[ 5, 1, 9,11],
[ 2, 4, 8,10],
[13, 3, 6, 7],
[15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
[15,13, 2, 5],
[14, 3, 4, 1],
[12, 6, 8, 9],
[16, 7,10,11]
]*/


class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val m = matrix.map { it.copyOf() }
        for(i in 0 until m.size) {
            for((index,j) in m.withIndex()) {
                matrix[i][j.size -1 - index] = j[i]
            }
        }
    }
}