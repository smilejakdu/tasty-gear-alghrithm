package programers.level1

/*
1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 */
class NewIdRecommend {
    fun solution(newId: String): String {
        var recommendId = newId.toLowerCase().filter { isEnabledChar(it) }

        while (recommendId.contains("..")) {
            recommendId = recommendId.replace("..", ".")
        }

        if (recommendId.firstOrNull() == '.') {
            recommendId = recommendId.removeRange(0, 1)
        }
        if (recommendId.lastOrNull() == '.') {
            recommendId = recommendId.dropLast(1)
        }

        if (recommendId.isBlank()) {
            recommendId = "a"
        }

        if (recommendId.length >= 16) {
            recommendId = recommendId.substring(0, 15)
        }
        if (recommendId.last() == '.') {
            recommendId = recommendId.dropLast(1)
        }

        for (i in recommendId.length until 3) {
            recommendId = recommendId.plus(recommendId.last())
        }

        return recommendId
    }

    fun bestSolution(newId: String) = newId.toLowerCase()
        .filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
        .replace("[.]*[.]".toRegex(), ".")
        .removeSurrounding(".",".")
        .let { it.ifEmpty { "a" } }
        .let { if (it.length > 15) it.substring(0 until 15) else it }.removeSuffix(".")
        .let {
            if (it.length <= 2)
                StringBuilder(it).run {
                    while (length < 3) append(it.last())
                    toString()
                }
            else it
        }

    private fun isEnabledChar(c: Char): Boolean {
        return c.isLetterOrDigit() || c == '-' || c == '_' || c == '.'
    }
}

fun hi() {
    println("hello")
}

fun main() {
    hi()
}