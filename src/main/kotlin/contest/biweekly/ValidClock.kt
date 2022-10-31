package contest.biweekly

//@author Usman Fani
class ValidClock {
    fun countTime(s: String): Int {
        var hr = 1
        var min = 1
        for (i in s.indices) {
            if (s[i] == '?') {
                if (i < 2) {
                    if (i == 0) {
                        hr = if (s[i + 1] == '?') 24
                        else if (s[i + 1] < '4') 3
                        else 2
                    } else {
                        if (s[0] == '?') continue
                        hr = if (s[0] < '2') 10
                        else 4
                    }
                } else {
                    if (i == 3) {
                        min = 6
                    } else {
                        min *= 10
                    }
                }
            }
        }
        return hr * min
    }
}