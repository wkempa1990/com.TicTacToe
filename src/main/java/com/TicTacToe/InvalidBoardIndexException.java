package com.TicTacToe;

public class InvalidBoardIndexException extends RuntimeException {
    public InvalidBoardIndexException(String message) {
        super(message);
    }
}
