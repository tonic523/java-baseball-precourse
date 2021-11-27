package baseball;

import static baseball.View.inputUI;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Game game = new Game();
        List<Ball> user = new ArrayList<>();

        while (game.isPlay()) {
            inputUI();
                
        }
    }
}
