package thisiscote.chapter3

class Change {

    fun solution(n: Int): Int {
        var answer = n / 500
        var rest = n % 500

        answer += rest / 100
        rest %= 100

        answer += rest / 50
        rest %= 50

        answer += rest / 10
        rest %= 10

        return answer
    }

    /*
        int n = 1260;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10};

        for (int i = 0; i < 4; i++) {
            int coin = coinTypes[i];
            cnt += n / coin;
            n %= coin;
        }

        System.out.println(cnt);
     */
}