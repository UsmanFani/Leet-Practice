package dp.medium

class DecodeWays {
    //Example 1:
    //Input: s = "12"
    //Output: 2
    //Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

    //Example 2:
    //Input: s = "226"
    //Output: 3
    //Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

    //Example 3:
    //Input: s = "06"
    //Output: 0
    //Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
    private var noOfWays = 0
    var map = mutableMapOf<Int, Int>()
    fun numDecodings(s: String): Int {
        return decode(s, 0, 0)
    }

    private fun decode(s: String, firstIndex: Int, secondIndex: Int): Int {
        if (firstIndex == secondIndex) {
            if (map.containsKey(firstIndex)) return map[firstIndex]!!
            var ones = s[firstIndex].code - 48
            if (ones == 0) return 0
            if (firstIndex == s.lastIndex) return 1
        } else {
            if (map.containsKey((firstIndex * 10) + secondIndex)) return map[(firstIndex * 10) + secondIndex]!!
            var tens = (s[firstIndex].code - 48) * 10 + (s[secondIndex].code - 48)
            if (tens > 26) return 0
            if (secondIndex == s.lastIndex) return 1
        }
        map[firstIndex + 1] = decode(s, firstIndex + 1, firstIndex + 1)
        map[(firstIndex + 1) * 10 + (secondIndex + 1)] = decode(s, firstIndex + 1, secondIndex + 1)
        return map[firstIndex + 1]!! + map[(firstIndex + 1) * 10 + (secondIndex + 1)]!!
    }

}