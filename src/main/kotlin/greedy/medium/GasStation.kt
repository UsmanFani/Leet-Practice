package greedy.medium

//@author Usman Fani

//Leetcode-134

//Example 1:
//Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//Output: 3
//Explanation:
//Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//Travel to station 4. Your tank = 4 - 1 + 5 = 8
//Travel to station 0. Your tank = 8 - 2 + 1 = 7
//Travel to station 1. Your tank = 7 - 3 + 2 = 6
//Travel to station 2. Your tank = 6 - 4 + 3 = 5
//Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
//Therefore, return 3 as the starting index.

//Example 2:
//Input: gas = [2,3,4], cost = [3,4,3]
//Output: -1
//Explanation:
//You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
//Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//Travel to station 0. Your tank = 4 - 3 + 2 = 3
//Travel to station 1. Your tank = 3 - 3 + 3 = 3
//You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
//Therefore, you can't travel around the circuit once no matter where you start.
class GasStation {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        for (i in 0..gas.lastIndex) {
            var gasRemain = gas[i]
            if (gasRemain < cost[i]) continue
            else gasRemain -= cost[i]
            var j = if (i == gas.lastIndex) 0 else i + 1
            while (j != i) {
                gasRemain += gas[j]
                if (gasRemain < cost[j]) break
                else gasRemain -= cost[j]
                if (j == gas.lastIndex) j = 0
                else j++
            }
            if (i == j) return i
        }
        return -1
    }

    fun optimCanCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val gasSum = gas.sum()
        val costSum = cost.sum()
        if (gasSum < costSum) return -1
        val diff = IntArray(gas.size)
        var index = 0
        var sum = 0
        for (i in diff.indices) {
            diff[i] = gas[i] - cost[i]
            if (diff[i] >= 0) {
                if (sum < 0) {
                    sum = diff[i]
                    index = i
                } else sum += diff[i]
            } else sum += diff[i]
        }

        return index
    }
}