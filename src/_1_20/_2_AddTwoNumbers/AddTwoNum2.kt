package _1_20._2_AddTwoNumbers2

//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Example:
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 */


class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0
        var head  = ListNode(0)
        var node1 = l1
        var node2 = l2
        while (node1 != null || node2 != null) {
            var x :Int = node1?.`val` ?: 0
            var y :Int = node2?.`val` ?: 0
            var sum : Int = carry + x + y
            carry = sum / 10
            head.add1(ListNode(sum % 10))
            node1 = node1?.next
            node2 = node2?.next

        }
        if (carry == 1) head.add1(ListNode(carry))

        return head.next

    }

    private fun ListNode.add1(node: ListNode) :Unit {
        var temp = this
        while (temp.next !=null )
        {
            temp = temp.next as ListNode
        }
        temp.next = node
    }
}

fun printNode(head : ListNode?) : Unit {
    var v = head
    while ( v != null){
        print(" ${v.`val`}->")
        v = v.next
    }
    println()

}

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null


    fun add(node: ListNode): Unit {
        var temp = this@ListNode
        while (temp.next !=null )
        {
            temp = temp.next as ListNode
        }
        temp.next = node
    }


}

fun main(args: Array<String>) {
    val head = ListNode(9)
    head.add(ListNode(9))
    //head.add(ListNode(3))


    val head2 = ListNode(1)

    //head2.add(ListNode(6))
    //head2.add(ListNode(4))


    printNode(head)
    println("+")
    printNode(head2)

    printNode(Solution().addTwoNumbers(head, head2))
}