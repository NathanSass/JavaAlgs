fun main(args: Array<String>) {
    /**
     * loop through until nextNode is null
     * keep an index and return this
     */

    var a = LinkedListNode("Angel Food")
    var b = LinkedListNode("Bundt")
    var c = LinkedListNode("Cheese")
    var d = LinkedListNode("Devil's Food")
    var e = LinkedListNode("Eccles")

    a.next = b
    b.next = c
    c.next = d
    d.next = e
    println(LinkedListNodeNthElement.get(2, a)?.value)
    println(LinkedListNodeNthElement.getWithStick(2, a)?.value)
}

class LinkedListNodeNthElement {
    companion object {

        fun getWithStick(n: Int, head: LinkedListNode) : LinkedListNode? {
            var leftNode  :LinkedListNode? = head
            var rightNode : LinkedListNode? = head

            for (i in 1 until n) {
                rightNode = rightNode?.next
            }

            if (rightNode == null) {
                return null
            }

            while (rightNode?.next != null) {
                rightNode = rightNode.next
                leftNode = leftNode?.next
            }
            return leftNode
        }
        fun get(n : Int, head: LinkedListNode): LinkedListNode? {
            var i = 1
            var currentNode: LinkedListNode? = head // angel, bundt, cheese, devil, ecc
            var nthLastNode : LinkedListNode? = head // angel, bundt, cheese

            while (currentNode?.next != null) {
                if (i >= n) {
                    nthLastNode = nthLastNode?.next
                }
                currentNode = currentNode.next
                i++
            }

            return if ( i < n) {
                null
            } else {
                nthLastNode
            }

        }
    }
}