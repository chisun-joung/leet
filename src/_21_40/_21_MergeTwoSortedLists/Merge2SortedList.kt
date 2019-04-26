package prob21

//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//
//Example:
//
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4

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
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var currentl1 = l1
        var currentl2 = l2
        var tempNode : ListNode?
        val result : ListNode?
        if (currentl1 == null && currentl2 == null) {
            return null
        }
        if (currentl1 == null) {
            return currentl2
        }
        if (currentl2 == null) {
            return currentl1
        }
        if (currentl1.`val` <= currentl2.`val`) {
            tempNode = currentl1
            currentl1 = currentl1.next
        } else {
            tempNode = currentl2
            currentl2 = currentl2.next
        }
        result= tempNode
        while (currentl1 !=null && currentl2 != null ) {
            if (currentl1.`val` <= currentl2.`val`) {
                tempNode?.next = currentl1
                currentl1 = currentl1.next
                tempNode = tempNode?.next
            }else{
                tempNode?.next = currentl2
                currentl2 = currentl2.next
                tempNode = tempNode?.next
            }
        }
        if (currentl1 == null){
            tempNode?.next = currentl2
        }else if (currentl2 == null ){
            tempNode?.next = currentl1
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
    val list1 = ListNode(1)
    list1.add(ListNode(2))
    list1.add(ListNode(4))
    val list2 = ListNode(1)
    list2.add(ListNode(3))
    list2.add(ListNode(4))
    printNode(list1)
    printNode(list2)

    printNode(Solution().mergeTwoLists(list1,list2))
}
