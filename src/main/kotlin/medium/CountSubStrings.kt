package medium

class CountSubStrings {

    //Input: s = "abc"
    //Output: 3
    //Explanation: Three palindromic strings: "a", "b", "c".

    //Input: s = "aaa"
    //Output: 6
    //Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
    fun countSubStrings(s: String): Int {
        var count = 0
        for (i in s.indices) {
            var l = i
            var r = i
            while(l>=0 && r<s.length && s[l]==s[r]){
                count++
                l-=1
                r+=1
            }

            l = i
            r = i+1
            while(l>=0 && r<s.length && s[l]==s[r]){
                count++
                l-=1
                r+=1
            }
        }
        return count
    }
}