fun main(args: Array<String>) {
    /**
     * [1, 2, 3, 4, 5, 6]
     * [1, 2, 3]
     * [4, 5, 6]
     */
    val shuffArr = intArrayOf(1,4,2,5,3,6)
    val left = intArrayOf(1,2,3)
    val right = intArrayOf(4,5,6)
    println(SingleRiffle.isSingleRiffle(left, right, shuffArr))
}
class SingleRiffle {
    companion object {
        fun removeTopCard(deck: IntArray) : IntArray {
            return deck.copyOfRange(1, deck.size)
        }
        fun isSingleRiffle(half1: IntArray, half2: IntArray, shuffledDeck: IntArray) : Boolean {
            if (shuffledDeck.isEmpty()) {
                return true
            }

            if (half1.isNotEmpty() && half1[0] == shuffledDeck[0]) {
                return isSingleRiffle(removeTopCard(half1), half2, removeTopCard(shuffledDeck))
            } else if (half2.isNotEmpty() && half2[0] == shuffledDeck[0]) {
                return isSingleRiffle(half1, removeTopCard(half2), removeTopCard(shuffledDeck))
            } else {
                return false
            }

        }
    }
}