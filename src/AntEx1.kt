package antEx1

val a = listOf<Int>(1,3,1,1,2,2,2,1)


fun <E> group(s: List<E>) : List<List<E>> {
    var sg = mutableListOf<E>()
    val result = mutableListOf<List<E>>()
    for (i in 0 until s.size){
        val value = sg.lastOrNull()
        if (value != null && value != s[i]){
            result.add(sg)
            sg = mutableListOf()
        }
        sg.add(s[i])
    }
    result.add(sg)
    return result
}

fun <A,B> map(f:(A)->B, s: List<A>): List<B> {
    return s.map(f)
}

fun <A> concat( ss: List<List<A>>): List<A> {
    return ss.reduce { acc, list -> acc.plus(list)  }
}


fun next(ns: List<Int>): List<Int> {
    return concat(map({g-> listOf(g.size,g[0])}, group(ns)))
}

fun ant(n: Int): List<Int> {
    var ns = listOf(1)
    for (i in 0 until n) {
        ns = next(ns)
    }
    return ns
}


fun main() {
    val a = listOf(1,3,1,1,2,2,2,1)
    val b = group(a)
        .map { g -> listOf(g.size,g[0]) }
        .reduce { acc, list -> acc.plus(list) }
    print(b)
    println(ant(30))
}