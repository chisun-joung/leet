package antEx4


fun next(g: Sequence<Int>) : Sequence<Int> {
    return sequence{
        val itr = g.iterator()
        var prev = itr.next()
        var count = 1
        for (value in itr) {
            if (value == prev)
                count++
            else {
                yieldAll(listOf(count,prev))
                prev = value
                count = 1
            }
        }
        yieldAll(listOf(count,prev))
    }
}

fun ant(n: Int): Sequence<Int> {
    var ns = listOf(1).asSequence()
    for (i in 0 until n) {
        ns = next(ns)
    }
    return ns
}

fun main() {

    print(ant(101).take(100).toList())

}