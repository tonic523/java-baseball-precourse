package baseball;

import javax.swing.Icon;

public class View {
    public static void inputUI() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void hintUI(Hint hint) {
        String hintString = "";
        int strike = hint.strike();
        int ball = hint.ball();
        int nothing = hint.nothing();
        if (nothing == 3) {
            System.out.println("낫싱");
            return;
        }
        if (ball != 0) {
            hintString += ball + "볼 ";
        }
        if (strike != 0) {
            hintString += strike + "스트라이크";
        }
        System.out.println(hintString);
    }

    public static void correctUI() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void endUI() {
        System.out.println("게임 종료");
    }
}
