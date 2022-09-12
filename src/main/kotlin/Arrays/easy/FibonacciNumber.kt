package Arrays.easy

class FibonacciNumber {
    //using recursion
    fun fib(n: Int): Int {
        if (n == 0) return 0
        return if (n == 1) 1
        else fib(n - 1) + fib(n - 2)
    }

    fun fibon(n:Int):Int{
        val arr = intArrayOf(0,1)
        if(n==0) return 0
        if(n==1) return 1
        for (i in 2..n){
            val temp = arr[0]
            arr[0] = arr[1]
            arr[1] = temp+arr[0]
        }
        return arr[1]
    }
}