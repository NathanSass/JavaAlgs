fun main(args: Array<String>) {


    println("CoinsDynamic2: " + CoinsDynamic2(4 , intArrayOf(1,2,3)).getWays())
}

class CoinsDynamic2(private val amount: Int, private val denominations : IntArray) {
    private val waysToMakeNCents = IntArray(amount + 1) {0}
    init {
        waysToMakeNCents[0] = 1
    }

    fun getWays() : Int {
        for (denom in denominations) {
            for (i in 1 until waysToMakeNCents.size) {
                if (denom > i) { continue }
                val remainder = i - denom
                waysToMakeNCents[i] += waysToMakeNCents[remainder]
            }
        }
        return waysToMakeNCents[amount]
    }
}