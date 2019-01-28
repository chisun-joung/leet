package prob6


//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//
//Write the code that will take a string and make this conversion given a number of rows:
//
//string convert(string s, int numRows);
//Example 1:
//
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
//Example 2:
//
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//
//P     I    N
//A   L S  I G
//Y A   H R
//P     I


class Solution {
    fun convert(s: String, numRows: Int): String {

        var result  = StringBuilder()
        var index = 0
        val width = numRows + numRows - 3
        for ( i in 0 until numRows) {
            index = i
            while (index < s.length){
                result.append(s[index])
                if ( i != 0 && i != (numRows-1)) {
                    var step = width - i
                    if (index + step < s.length)
                        result.append(s[index + step])
                }
                index += (width+1)
            }

        }

        return result.toString()

    }
}


fun main() {
    println(Solution().convert("PAYPALISHIRING",4))
}