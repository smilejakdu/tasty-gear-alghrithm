package thisiscote.chapter4

class KingdomNight {

    fun solution(position: String): Int {
        val columnMap = hashMapOf(
            'a' to 0,
            'b' to 1,
            'c' to 2,
            'd' to 3,
            'e' to 4,
            'f' to 5,
            'g' to 6,
            'h' to 7,
        )
        val column: Int? = columnMap[position[0]]
        val row: Int = Character.getNumericValue(position[1]) - 1

        var answer = 0
        if (column != null) {
            if (column + 2 < 8) {
                if (row + 1 < 8) {
                    answer++
                }

                if (row - 1 >= 0) {
                    answer++
                }
            }

            if (column - 2 >= 0) {
                if (row + 1 < 8) {
                    answer++
                }

                if (row - 1 >= 0) {
                    answer++
                }
            }

            if (row + 2 < 8) {
                if (column + 1 < 8) {
                    answer++
                }

                if (column - 1 >= 0) {
                    answer++
                }
            }

            if (row - 2 >= 0) {
                if (column + 1 < 8) {
                    answer++
                }

                if (column - 1 >= 0) {
                    answer++
                }
            }
        }



        return answer
    }

    /*
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int result = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }

     */
}