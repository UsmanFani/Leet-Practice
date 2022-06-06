package easy

class LowestCommonPrefix {
    fun lcp(strs: Array<String>): String {
        var rev = ""
        for (i in strs[0].indices) {
            for (j in strs.indices) {
                if (i >= strs[j].length) return rev
                if (strs[j][i] != strs[0][i]) return rev
            }
            rev += strs[0][i]
        }
        return rev
    }
}