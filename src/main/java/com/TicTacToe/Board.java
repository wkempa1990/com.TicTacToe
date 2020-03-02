package com.TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private State state;
    private Player currentPlayer;
    private List<Sign> field;

    public Board() {
        field = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            field.add(Sign.EMPTY);
        }
        currentPlayer = Player.X;
        state = State.PENDING;
    }

    public State play(int index) {
        setSign(index);
        if (!field.contains(Sign.EMPTY)) {
            state = State.DRAW;
        }
        if (isWin()) {
            state = currentPlayer.equals(Player.X) ? State.WINNER_O : State.WINNER_X;
        }
        return state;
    }

    public boolean isWin() {
        for (int i = 0; i < 9; i = i + 3) {
            if (!field.get(i).equals(Sign.EMPTY) && field.get(i).equals(field.get(i + 1))
                    && field.get(i).equals(field.get(i + 2))) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (!field.get(j).equals(Sign.EMPTY) && field.get(j).equals(field.get(j + 3))
                    && field.get(j).equals(field.get(j + 6))) {
                return true;
            }
        }

        if (!field.get(4).equals(Sign.EMPTY) && field.get(0).equals(field.get(4))
                && field.get(0).equals(field.get(8)) || !field.get(4).equals(Sign.EMPTY)
                && field.get(2).equals(field.get(4)) && field.get(2).equals(field.get(6))) {
            return true;
        }

        return false;
    }

    public List<Sign> getField() {
        return field;
    }

    public boolean setSign(int index) {
        if (index < 1 || index > 9) {
            throw new InvalidBoardIndexException("Index should be between 1-9");
        }
        if (!field.get(index - 1).equals(Sign.EMPTY)) {
            return false;
        }
        if (currentPlayer.equals(Player.X)) {
            field.set(index - 1, Sign.X);
            currentPlayer = Player.O;
        } else {
            field.set(index - 1, Sign.O);
            currentPlayer = Player.X;
        }
        return true;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void print() {
        for (int i = 0; i < 9; i = i + 3) {
            for(int j = 0; j <3;j++) {
                Sign sign = field.get(i + j);
                System.out.print(sign.getName());
            }
            System.out.println();
        }
    }
}

