package com.TicTacToe;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        while(board.getState().equals(State.PENDING)) {
            board.print();
            board.play(scanner.nextInt());
        }
        System.out.println(board.getState());
    }
}
