package antEx2

fun <A> sgroup(s: Sequence<A>) : Sequence<Sequence<A>> {
    var sg = emptySequence<A>()
    var result = emptySequence<Sequence<A>>()
    val itor = s.iterator()
    while (itor.hasNext()){
        val value = sg.lastOrNull()
        val temp = itor.next()
        if (value != null && value != temp ){
            result = result.plus(sequenceOf(sg))
            sg = emptySequence()
        }
        sg = sg.plus(sequenceOf(temp))
    }
    result = result.plus(sequenceOf(sg))
    return result
}

fun <A,B> smap(f:(A)->B, s: Sequence<A>): Sequence<B> {
    return s.map(f)
}

fun <A> sconcat( ss: Sequence<Sequence<A>>): Sequence<A> {
    return ss.reduce { acc, list -> acc.plus(list)  }
}



fun next(ns: Sequence<Int>): Sequence<Int> {
    return sconcat(smap({ g -> sequenceOf(g.count(), g.first()) }, sgroup(ns)))
}

fun ant(n: Int): Sequence<Int> {
    var ns = listOf(1).asSequence()
    for (i in 0 until n) {
        ns = next(ns)
    }
    return ns
}


fun main() {

    val ns = ant(50)
    print(ns)


}