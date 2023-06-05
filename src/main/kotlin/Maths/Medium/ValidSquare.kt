package Maths.Medium

//@author Usman Fani

//Example 1:
//Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//Output: true

//Example 2:
//Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//Output: false

//Example 3:
//Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//Output: true
class ValidSquare {
    //distance b/w to points d = √((x2 – x1)² + (y2 – y1)²)
    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        val map: MutableMap<String, Int> = mutableMapOf()
        var x = 0
        var y = 0
        val list = listOf(p1, p2, p3, p4)
        for (i in 0..list.lastIndex) {
            for (j in i + 1..list.lastIndex) {
                if (list[j][0] == list[i][0]) x++
                if (list[j][1] == list[i][1]) y++
                val cal = Math.sqrt(
                    Math.pow((list[j][0] - list[i][0]).toDouble(), 2.0)
                            + Math.pow((list[j][1] - list[i][1]).toDouble(), 2.0)
                ).toString()
                if (map.containsKey(cal)) map[cal] = map[cal]!! + 1
                else map[cal] = 1
            }
        }
        if (map.containsKey("0.0")) return false
        if (x >= 3 || y >= 3) return false
        if (map.isNotEmpty()) {
            val keys = mutableListOf<String>()
            map.forEach {
                keys.add(it.key)
            }
            if (map.size > 2) return false
            if (map.size == 1 && map[keys[0]] == 6) return true
            if ((map[keys[0]] == 2 && map[keys[1]] == 4) || (map[keys[0]] == 4 && map[keys[1]] == 2)) return true
        }
        return false
    }
}