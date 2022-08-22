package medium

import kotlin.math.abs

class InvalidTransactions {
    //Example 1:
    //Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
    //Output: ["alice,20,800,mtv","alice,50,100,beijing"]
    //Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.

    //Example 2:
    //Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
    //Output: ["alice,50,1200,mtv"]

    //Example 3:
    //Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
    //Output: ["bob,50,1200,mtv"]
    fun invalidTransactions(transactions: Array<String>): List<String> {
        var invalidList = mutableListOf<String>()
        var map = mutableMapOf<String, List<List<String>>>()
        var name = ""
        var time: Int
        var amount: Int
        var city: String
        for (i in transactions.indices) {
            var it = transactions[i]
            var list = it.split(',')
            name = list[0]
            time = list[1].toInt()
            amount = list[2].toInt()
            city = list[3]

            if (amount > 1000) invalidList.add(it)
            else if (map.containsKey(name)) {
                var mapTime = map[name]!![map[name]!!.lastIndex]
                if (abs(time - mapTime[1].toInt()) <= 60 && city != mapTime[3]) {
                    map[name]!!.forEach{
                        invalidList.add(it[0]+","+it[1]+","+it[2]+","+it[3])
                    }
                    invalidList.add(it)
                    map[name] = listOf(listOf(it))
                }else{
                    var mapList = map[name]!!.toMutableList()
                    mapList.add(listOf(name,time.toString(),amount.toString(),city))
                    map[name] = mapList

                }
            } else {
                map.put(name, listOf(listOf(name,time.toString(),amount.toString(),city)))
            }
        }
        return invalidList
    }
}