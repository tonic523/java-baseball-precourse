package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.params.ParameterizedTest;

public class Application {

    private static int BALL_SIZE = 3;
    private static int MIN_VALUE = 1;
    private static int MAX_VALUE = 9;

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        List<Integer> computer = createRandomNumbers();
        List<Integer> user = new ArrayList<>();
        int play = 1;

        while (play == 1) {
            View.inputUI();
            String input = Console.readLine();
            System.out.println(input);
            try {
                user = convertBalls(input);
            } catch (IllegalArgumentException e) {
                break;
            }
            if (compareBalls(computer, user)) {
                System.out.println("3스트라이크");
                View.endUI();
                play = Integer.parseInt(Console.readLine());
                if (play == 2) {
                    break;
                }
                computer = createRandomNumbers();
                continue;
            }
            Map<BallStatus, Integer> hint = getHint(computer, user);
            View.hintUI(hint);
        }
        System.out.println("게임 종료");
    }

    // 힌트 반환
    static Map<BallStatus, Integer> getHint(List<Integer> computer, List<Integer> user) {
        Map<BallStatus, Integer> hint = initHint();
        for (int i = 0; i < BALL_SIZE; i++) {
            BallStatus ballStatus = match(computer, user.get(i), i);
            hint.put(ballStatus, hint.get(ballStatus) + 1);
        }
        return hint;
    }
    // 힌트 초기화
    static Map<BallStatus, Integer> initHint() {
        Map<BallStatus, Integer> hint = new HashMap<>();
        hint.put(BallStatus.BALL, 0);
        hint.put(BallStatus.STRIKE, 0);
        hint.put(BallStatus.NOTHING, 0);
        return hint;
    }

    // 하나의 볼을 컴퓨터의 숫자와 비교
    static BallStatus match(List<Integer> computer, int number, int index) {
        if (computer.get(index) == number) {
            return BallStatus.STRIKE;
        }
        if (computer.contains(number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    // 입력한 문자열을 숫자형 리스트로 변환
    static List<Integer> convertBalls(String input) {
        validateInput(input);
        List<Integer> result = new ArrayList<>(BALL_SIZE);
        for (int i = 0; i < BALL_SIZE; i++) {
            result.add(input.charAt(i) - '0');
        }
        return result;
    }

    // 컴퓨터의 임의의 수 생성
    static List<Integer> createRandomNumbers() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < BALL_SIZE) {
            set.add(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE));
        }
        List<Integer> result = new ArrayList<>(set);
        Collections.shuffle(result);
        return result;
    }

    // 사용자가 입력한 값과 같은지 유무
    static boolean compareBalls(List<Integer> computer, List<Integer> user) {
        return Arrays.equals(computer.toArray(), user.toArray());
    }

    ///////// 유효성 검사 //////////////
    // 사용자 입력값 유효성 검사
    static void validateInput(String input) throws IllegalArgumentException {
        if (input.length() != BALL_SIZE) {
            throw new IllegalArgumentException();
        }
        if (!(isNumbers(input))) {
            throw new IllegalArgumentException();
        }
    }

    // 입력한 문자열이 숫자가 맞는지 검사
    static boolean isNumbers(String input) {
        for (int i = 0; i < BALL_SIZE; i++) {
            if (!(isNumber(input.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    // 숫자가 1~9인지
    static boolean isNumber(char c) {
        return '1' <= c && c <= '9';
    }
}
