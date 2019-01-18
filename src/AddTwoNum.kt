package addtwonum

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
        val head = ListNode()
        var node1 = l1?.next
        var node2 = l2?.next
        var flag = true
        while (flag) {

            if (node1?.next == null && node2?.next == null ){
                flag = false
            }

            var sum = node1!!.`val` + node2!!.`val` + carry
            if (sum >= 10 ) {
                carry = 1
                sum -= 10
            }else{
                carry = 0
            }
            add(head,ListNode(sum))
            if(node1.next == null) {
                node1.`val` = 0
            }else{
                node1 = node1.next
            }
            if(node2.next == null) {
                node2.`val` = 0
            }else{
                node2 = node2.next
            }


        }

        return head

    }

    fun add(head : ListNode , node : ListNode): Unit {
        if(head.next == null){
            head.next = node
            return
        }

        var temp = head.next
        while (temp?.next != null){
            temp = temp.next
        }
        temp?.next = node
    }
}

fun printNode(head : ListNode?) : Unit {
    var v = head?.next
    while ( v != null){
        print(" ${v.`val`}->")
        v = v.next
    }
    println()

}

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null

    fun add(head : ListNode , node : ListNode): Unit {
        if(head.next == null){
            head.next = node
            return
        }

        var temp = head.next
        while (temp?.next != null){
            temp = temp.next
        }
        temp?.next = node
    }
}

fun main(args: Array<String>) {
    val head = ListNode(0)
    head.add(head,ListNode(2))
    head.add(head,ListNode(4))
    head.add(head,ListNode(3))

    val head2 = ListNode(0)

    head2.add(head2,ListNode(5))
    head2.add(head2,ListNode(6))
    head2.add(head2,ListNode(4))



    printNode(head)
    println("+")
    printNode(head2)

    printNode(Solution().addTwoNumbers(head,head2))
}