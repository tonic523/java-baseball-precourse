package baseball;

import static baseball.View.inputUI;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Game game = new Game();
        while (game.isPlay()) {
            inputUI();
            game.setHint(Console.readLine());
            if (!(game.isThreeStrike())) {
                game.initHint();
                continue;
            }
            game.setPlay();
        }
    }
}
