package thisiscote.chapter4

class DevelopGame {

    fun solution(array: Array<IntArray>, startPosition: IntArray, direction: Int): Int {
        var answer = 0
        var currentY = startPosition[0]
        var currentX = startPosition[1]
        array[currentY][currentX] = 2
        var currentDirection = direction

        while (array[currentY][currentX] != 0) {
            if ((currentY + 1 == array.size || array[currentY + 1][currentX] != 0) &&
                (currentX + 1 == array.size || array[currentY][currentX + 1] != 0) &&
                (currentY - 1 == 0 || array[currentY - 1][currentX] != 0) &&
                (currentX - 1 == 0 || array[currentY][currentX - 1] != 0)
            ) {
                when (currentDirection) {
                    0 -> {
                        currentY--
                    }
                    1 -> {
                        currentX--
                    }
                    2 -> {
                        currentY++
                    }
                    3 -> {
                        currentX++
                    }
                }

                if (array[currentY][currentX] == 1) {
                    break
                }
            }
            var tempX = currentX
            var tempY = currentY

            when (currentDirection) {
                0 -> {
                    tempY++
                }
                1 -> {
                    tempX++
                }
                2 -> {
                    tempY--
                }
                3 -> {
                    tempX--
                }
            }

            if (array[tempY][tempX] == 0) {
                currentX = tempX
                currentY = tempY
                array[currentY][currentX] = 2
            } else {
                currentDirection = (currentDirection + 1) % 4
            }
        }

        array.forEach { intArray ->
            answer += intArray.count { it == 2 }
        }
        return answer
    }

    /**
     * dx, dy 로 나누어서 x 좌표와 y 좌표를 따로 계산할 생각을 못함
     * turnTime(회전 횟수)를 하나씩 증가시켜 4가 되었을 때 = 모든 곳이 방문했거나 바다임
     *
     */


    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화

    // 북, 동, 남, 서 방향 정의
    private var dx = intArrayOf(-1, 0, 1, 0)
    private var dy = intArrayOf(0, 1, 0, -1)

    // 왼쪽으로 회전
    private fun turnLeft(currentDirection: Int): Int {
        return if (currentDirection - 1 == -1) 3
        else currentDirection - 1
    }

    fun bestSolution(array: Array<IntArray>, startPosition: IntArray, direction: Int): Int {
        var currentDirection = direction
        var visit = Array(50) { IntArray(50) }
        var arr = Array(50) { IntArray(50) { 1 } }
        var x = startPosition[0]
        var y = startPosition[1]
        visit[x][y] = 1 // 현재 좌표 방문 처리

        for (x in array.indices) {
            for (y in array[x].indices) {
                arr[x][y] = array[x][y]
            }
        }

        // 시뮬레이션 시작
        var cnt = 1
        var turnTime = 0
        while (true) {
            // 왼쪽으로 회전
            currentDirection = turnLeft(currentDirection)
            var nx: Int = x + dx[currentDirection]
            var ny: Int = y + dy[currentDirection]
            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동

            if (ny == -1 || nx == -1 || ny == array.size || nx == array.size) {
                turnTime++
            } else if (visit[nx][ny] == 0 && arr[nx][ny] == 0) {
                visit[nx][ny] = 1
                x = nx
                y = ny
                cnt += 1
                turnTime = 0
                continue
            } else turnTime++
            // 네 방향 모두 갈 수 없는 경우
            if (turnTime == 4) {
                nx = x - dx[currentDirection]
                ny = y - dy[currentDirection]
                // 뒤로 갈 수 있다면 이동하기
                if (arr[nx][ny] == 0) {
                    x = nx
                    y = ny
                } else break
                turnTime = 0
            }
        }

        return cnt
    }
}