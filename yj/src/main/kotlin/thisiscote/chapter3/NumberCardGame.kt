package thisiscote.chapter3

class NumberCardGame {

    fun solution(array: Array<IntArray>): Int {
        return array.map { it.sorted() }
            .maxOf { it[0] }
    }
}