package antEx3

fun  group(s: Iterator<Int>) : Iterator<List<Int>> {
    var g = mutableListOf<Int>()
    return object : Iterator<List<Int>> {
        override fun hasNext(): Boolean {
            return s.hasNext() || g.isNotEmpty()
        }
        override fun next(): List<Int> {
            while(true){
                if (s.hasNext()){
                    val value = s.next()
                    if (g.isEmpty()){
                        g.add(value)
                    } else if (g[0] == value) {
                        g.add(value)
                    } else {
                        val result = g
                        g = mutableListOf(value)
                        return result
                    }
                } else {
                    val result = g
                    g = mutableListOf()
                    return result
                }
            }
        }
    }
}

fun <A,B> map(f:(A)->B, s: Iterator<A>): Iterator<B> {
    return object : Iterator<B> {
        override fun hasNext(): Boolean {
            return s.hasNext()
        }
        override fun next(): B {
                return f(s.next())
        }
    }
}

fun <A> concat( ss: Iterator<Iterator<A>>): Iterator<A> {
    var inner  = listOf<A>().iterator()
    return object : Iterator<A> {
        override fun next(): A {
            while(true){
                if (inner.hasNext()){
                    val value = inner.next()
                    return  value
                } else {
                    val value = ss.next()
                    inner = value
                }
            }
        }
        override fun hasNext(): Boolean {
            return ss.hasNext() || inner.hasNext()
        }
    }
}

fun next(ns: Iterator<Int>): Iterator<Int> {
    return concat(map({g-> listOf(g.size,g[0]).iterator()}, group(ns)))
}

fun ant(n: Int): Iterator<Int> {
    var ns = listOf(1).iterator()
    for (i in 0 until n) {
        ns = next(ns)
    }
    return ns
}

fun main() {
   for (a in ant(50))
       print("$a")

}