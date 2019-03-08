package prob24

//Given a linked list, swap every two adjacent nodes and return its head.
//
//You may not modify the values in the list's nodes, only nodes itself may be changed.
//Example:
//
//Given 1->2->3->4, you should return the list as 2->1->4->3.



/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if(head == null) return null

        if(head.next == null) return head
        var cur = head
        var result = cur.next
        while(cur?.next != null){
            var next = cur.next
            cur.next = cur.next?.next
            next?.next = cur
            cur = cur.next
            next?.next?.next = cur?.next ?: cur
        }
        return result
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

class ListNode(var `val`: Int) {
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

fun main() {
    val list = ListNode(1)
 //    list.add(ListNode(2))
 //   list.add(ListNode(3))
//    list.add(ListNode(4))
    printNode(Solution().swapPairs(list))
}