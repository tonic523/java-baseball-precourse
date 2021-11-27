package baseball;

import static baseball.View.inputUI;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Game game = new Game();
        while (game.start()) {
            inputUI();
            Hint hint = game.compare(Console.readLine());
            View.hintUI(hint);
            if (!(game.isCorrect(hint.strike()))) {
                continue;
            }
            View.correctUI();
            game.choicePlay(Console.readLine());
        }
    }
}
