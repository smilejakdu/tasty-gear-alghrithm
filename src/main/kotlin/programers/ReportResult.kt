package programers

class ReportResult {
    fun solution(idList: Array<String>, reports: Array<String>, k: Int): IntArray {
        // 신고자와 신고 대상이 중복될 수 없다.
        val reportSets = reports.toSet()

        // 신고된 유저가 얼마만큼 신고를 당했는 지 Map으로 나타냄.
        val reportedUserMap = hashMapOf<String, Int>()
        reportSets.forEach { report ->
            val users = report.split(" ")
            val reportedUser = users[1]
            reportedUserMap[reportedUser] = reportedUserMap.getOrDefault(reportedUser, 0) + 1
        }

        /*
        유저가 신고한 대상이 정지 기준을 넘었는 지를 확인하고
        기준을 넘었다면 신고를 한 유저 key에 해당하는 값을 1씩 더한다.
        기준을 넘지 못했다면 0이 되거나 현재 값을 유지한다.
        */
        val reporterMap = hashMapOf<String, Int>()
        reportSets.forEach { report ->
            val users = report.split(" ")
            val reporter = users[0]
            val reportedUser = users[1]
            if (reportedUserMap.getOrDefault(reportedUser, 0) >= k) {
                reporterMap[reporter] = reporterMap.getOrDefault(reporter, 0) + 1
            } else {
                reporterMap[reporter] = reporterMap.getOrDefault(reporter, 0)
            }
        }

        /*
        idList에 담겨 있는 순으로 신고 결과를 받은 횟수 나열
         */
        return idList.map { reporterMap.getOrDefault(it, 0) }.toTypedArray().toIntArray()
    }
}