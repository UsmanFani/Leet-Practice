package greedy.medium

//@author Usman Fani

//Example 1:
//Input: s = "aab"
//Output: 0
//Explanation: s is already good.

//Example 2:
//Input: s = "aaabbbcc"
//Output: 2
//Explanation: You can delete two 'b's resulting in the good string "aaabcc".
//Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".

//Example 3:
//Input: s = "ceabaacb"
//Output: 2
//Explanation: You can delete both 'c's resulting in the good string "eabaab".
//Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).

//8 8 8 8 8 5 5 5 5
//8 7 6 5 4 3 2 1
class MinDeletions {
    fun minDeletions(s: String): Int {
        val freqArray = IntArray(26)
        s.forEach {
            freqArray[it - 'a']++
        }
        freqArray.sortDescending()
        var res = 0
        for (i in 1..freqArray.lastIndex) {
            if (freqArray[i] == 0) break
            if (freqArray[i - 1] == 1) {
                for (j in i..freqArray.lastIndex) res += freqArray[j]
                break
            } else if (freqArray[i - 1] <= freqArray[i]) {
                val num = freqArray[i] - (freqArray[i - 1] - 1)
                res += num
                freqArray[i] = freqArray[i - 1] - 1
            }
        }
        return res
    }
}