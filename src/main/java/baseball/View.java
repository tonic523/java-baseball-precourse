package baseball;

public class View {
    public static void inputUI() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void hintUI(Hint hint) {
        int strike = hint.strike();
        int ball = hint.ball();
        int nothing = hint.nothing();
        String result = "";
        if (nothing == 3) {
            System.out.println("낫싱");
            return;
        }
        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }
        System.out.println(result);
    }

    public static void endUI() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
