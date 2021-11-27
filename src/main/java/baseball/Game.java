package baseball;

import static baseball.Ball.MAX_VALUE;
import static baseball.Ball.MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Game {

    private boolean play = true;
    private List<Ball> computer;
    private final int BALL_SIZE = 3;

    public Game() {
        computer = setRandomBallList();
    }

    public List<Ball> setRandomBallList() {
        LinkedHashSet<Ball> computer = new LinkedHashSet<>();
        while (computer.size() < BALL_SIZE) {
            computer.add(new Ball(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)));
        }
        return new ArrayList<>(computer);
    }

    public List<Ball> setBallList(String input) throws IllegalArgumentException {
        validateSize(input.length());
        validateIsNumber(input);
        LinkedHashSet<Ball> balls = new LinkedHashSet<>();
        for (int i = 0; i < input.length(); i++) {
            balls.add(new Ball(input.charAt(i)));
        }
        validateSize(balls.size());
        return new ArrayList<>(balls);
    }

    public static void validateSize(int size) throws IllegalArgumentException {
        if (size != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsNumber(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            validateIsNumber(input.charAt(i));
        }
    }

    public static void validateIsNumber(char c) throws IllegalArgumentException {
        if (!(Character.isDigit(c))) {
            throw new IllegalArgumentException();
        }
    }

    public void setPlay(int number) {
        if (number == 2) {
            play = false;
        }
    }

    public boolean isPlay() {
        return play;
    }
}
