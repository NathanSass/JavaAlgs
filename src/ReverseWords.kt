import java.util.ArrayList

fun main(args: Array<String>) {
    val message = charArrayOf('c', 'a', 'k', 'e', ' ', 'p', 'o', 'u', 'n', 'd', ' ', 's', 't', 'e', 'a', 'l')

//    println(ReverseWords.reverseOne(message))
    println(ReverseWords.inPlace(message))
}


class ReverseWords {
    companion object {
        fun inPlace(arr: CharArray) : String {
            var reversedAll = CharArray(arr.size)
            for (i in 0 until arr.size) {
                val j = arr.size - 1 - i
                if (i == j) break
                val left = arr[i]
                val right = arr[j]

                reversedAll[i] = right
                reversedAll[j] = left

            }
            return reverseTwo(reversedAll)
        }
        fun reverseThree(arr: CharArray) : CharArray {
            var decoded = CharArray(arr.size)
            val indexes = ArrayList<Int>()
            for(i in 0..arr.size) {
                val c = arr[i]
                if (i == arr.size - 1 || i == 0) {
                    indexes.add(i)
                }
                if (c == ' ') {
                    indexes.add(i)
                }
            }
            return decoded
        }
        fun reverseTwo(arr: CharArray) : String {
            var currentLetters = ""
            var message = ""
            for (c in arr) {
                if (c == ' ') {
                    message += (currentLetters.reversed() + " ")
                    currentLetters = ""
                } else {
                    currentLetters += c
                }
            }

            if (currentLetters.length > 0) {
                message += currentLetters.reversed()
            }

            return message
        }
        fun reverseOne(arr : CharArray)  : CharArray{
            var reversed = CharArray(arr.size)
            val sizeZeroBased = arr.size - 1
            for (i in sizeZeroBased downTo 0) {
                var index = sizeZeroBased - i

                reversed[index] = arr[i]
            }

            return reversed

        }
    }

}