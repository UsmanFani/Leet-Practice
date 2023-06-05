package Maths.Medium

//@author Usman Fani
class AngleBetweenHandClock {
    fun angleClock(hour: Int, minutes: Int): Double {
        val h = if (hour == 12) 0.0 else hour.toDouble()
        val hInMin: Double = h * 5
        var res = 0.0
        if (hInMin < minutes) {
            val diffMin: Double = minutes - hInMin
            val diffInDeg: Double = diffMin * 6
            val hInDig = (minutes / 60.0) * 30
            res = Math.abs(diffInDeg - hInDig)
        } else {
            val diffMin: Double = hInMin - minutes
            val diffInDeg: Double = diffMin * 6
            val hInDig = (minutes / 60) * 30
            res = diffInDeg + hInDig
        }
        return minOf(360 - res, res)
    }
}