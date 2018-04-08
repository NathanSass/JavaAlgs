import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.ln

fun main(args: Array<String>) {
    /**
     * Can be done in O(n) time, and O(n) space
     *
     * Create a new data structure for result
     *
     * Compare first element of each array. If element is smaller, remove from list and and add to result structure
     * Pros: linear time & space cost. not many vars. Cons: destructive on initial arrays
     *
     * variation 1: copy the arrays in parameters (maybe not an improvement)
     * variation 2: keep track of an iterator var
     * variation 3: create new array of size arr1 + arr2. add all elements to new array. Call factory method sort
     */
    val myArray = intArrayOf(3, 4, 6, 10, 11, 15).toMutableList()
    val alicesArray = intArrayOf(1, 5, 8, 12, 14, 19).toMutableList()
//    println(MergeSortedArrays.prettyPrint(MergeSortedArrays.merge(myArray, alicesArray)))
//    println(MergeSortedArrays.ezMerge(myArray, alicesArray))
    println(MergeSortedArrays.mergePretty(myArray, alicesArray))

}

class MergeSortedArrays {

    companion object {
        fun ezMerge(arr1: List<Int>, arr2: List<Int>): List<Int> {
            var resultArr = arr1.union(arr2).sortedByDescending {it}
            return resultArr
        }

        fun mergePretty(arr1: MutableList<Int>, arr2: MutableList<Int>) : List<Int> {
            var resultArr = IntArray(arr1.size + arr2.size)
            var index = 0

            while (arr1.isNotEmpty() && arr2.isNotEmpty()) {
                val a = arr1.first()
                val b = arr2.first()
                if (a <= b) {
                    resultArr[index] = a
                    arr1.removeAt(0)
                    index++
                }

                if (a >= b) {
                    resultArr[index] = b
                    arr2.removeAt(0)
                    index ++
                }
            }

            if (arr1.isNotEmpty() || arr2.isNotEmpty()) {
                val remainingArr = if (arr1.isNotEmpty()) arr1 else arr2
                for (item in remainingArr) {
                    resultArr[index] = item
                    index++
                }
            }

            return resultArr.toList()
        }
        fun merge(arr1 : MutableList<Int>, arr2: MutableList<Int>) : List<Int> {
            var resultArr = mutableListOf<Int>()
            val totalSize = arr1.size + arr2.size
            while (resultArr.size < totalSize) {
                if (arr1.isEmpty() ) {
                    for (item in arr2) {
                        resultArr.add(item)
                    }
                    break
                }

                if (arr2.isEmpty()) {
                    for (item in arr1) {
                        resultArr.add(item)
                    }
                    break
                }

                val a = arr1.first()
                var b = arr2.first()
                if (a < b) {
                    resultArr.add(a)
                    arr1.removeAt(0)
                } else if (a > b) {
                    resultArr.add(b)
                    arr2.removeAt(0)
                } else{
                    resultArr.add(a)
                    resultArr.add(b)
                    arr1.removeAt(0)
                    arr2.removeAt(0)
                }
            }

            return resultArr
        }

        fun prettyPrint(arr :List<Int>) : String {
            var result = ""

            for (item in arr) {
                result += (item.toString() + ", ")
            }

            return result
        }
    }


}