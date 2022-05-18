package thisiscote.chapter6

class SortedByScore {

    fun solution(array: Array<String>): Array<String> {
        val size = array.size
        val students = Array<String>(101) { "" }
        array.forEach {
            val strings = it.split(" ")
            val student = strings[0]
            val score = strings[1].toInt()
            students[score] = if (students[score].isBlank()) student else " $student"
        }

        return students.filter { it.isNotBlank() }
            .toTypedArray()
    }
}