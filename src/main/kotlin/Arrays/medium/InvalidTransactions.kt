package Arrays.medium

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
    fun invalidTransaction(transactions: Array<String>):List<String>{
        var list = mutableListOf<String>()
        for (i in 0 .. transactions.lastIndex){
            var splitList = transactions[i].split(',')
            var name = splitList[0]
            var time = splitList[1].toInt()
            var amount = splitList[2].toInt()
            var city = splitList[3]

            if(amount>1000){
                list.add(transactions[i])
                continue
            }
            for(j in 0..transactions.lastIndex){
                if(j==i)continue
                var split = transactions[j].split(',')
                var tempName = split[0]
                var tempTime = split[1].toInt()
                var tempAmount = split[2].toInt()
                var tempCity = split[3]
                if (name!=tempName)continue
                if(Math.abs(time-tempTime)<=60&&city!=tempCity){
                    list.add(transactions[i])
                    break
                }
            }
        }
        return list
    }
}