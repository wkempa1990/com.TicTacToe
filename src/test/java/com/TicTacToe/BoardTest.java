package com.TicTacToe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void shouldCreateNewBoardWith9EmptyyFields() {
        //given
        //when
        Board board = new Board();
        //then
        Assertions.assertThat(board.getField().size()).isEqualTo(9);
        Assertions.assertThat(board.getField()).containsOnly(Sign.EMPTY);
    }

    @Test
    public void shouldSetProperSignOnBoardAndReturnTrue() {
        //given
        Board board = new Board();
        //when
        boolean result = board.setSign(3);
        //then
        Assertions.assertThat(result).isTrue();
        Assertions.assertThat(board.getField().get(2)).isEqualTo(Sign.X);

    }

    @Test
    public void shouldStartingPlayerBex() {
        //given
        Board board = new Board();
        //when
        Player currentPlayer = board.getCurrentPlayer();
        //then
        Assertions.assertThat(currentPlayer).isEqualTo(Player.X);
    }
    @Test
    public void shouldStartingPlayerBexAndGameStatePending(){
        //given
        Board board = new Board();
        //when
        Player currentPlayer = board.getCurrentPlayer();
        //then
        Assertions.assertThat(currentPlayer).isEqualTo(Player.X);
        Assertions.assertThat(board.getState()).isEqualTo(State.PENDING);
    }




    @Test(expected = InvalidBoardIndexException.class)
    public void shouldThrowInvalidBoardeIndexExceptionWhenTryingToSetSignInIndexLowerThan1() {
        //given
        Board board = new Board();
        //when
        board.setSign(0);
        //then exception is thrown
    }

    @Test(expected = InvalidBoardIndexException.class)
    public void shouldThrowExceptionWhenTryingToSignInIndexBiggerThan9() {
        //given
        Board board = new Board();
        //when
        board.setSign(10);
        //then exception is thrown
    }

    @Test
    public void shouldReturnTrueIfCurrentPlayerIsOAfterFirstFieldHasBeenSet() {
        //given
        Board board = new Board();
        //when
        board.setSign(5);
        //then
        Assertions.assertThat(board.getCurrentPlayer()).isEqualTo(Player.O);
    }

    @Test
    public void shouldSetProperSingsOnBoard() {
        //given
        Board board = new Board();
        //when
        board.setSign(5);
        board.setSign(4);
        //then
        Assertions.assertThat(board.getField().get(3)).isEqualTo(Sign.O);
        Assertions.assertThat(board.getCurrentPlayer()).isEqualTo(Player.X);
    }

    @Test
    public void shouldReturnFieldAtIndexIsOccupiedExceptionIfItWasAlreadyChosenByEitherPlayer() {
        //given
        Board board = new Board();
        //when
        board.setSign(5);
        boolean result = board.setSign(5);
        //then
        Assertions.assertThat(result).isFalse();
        Assertions.assertThat(board.getField().get(4)).isEqualTo(Sign.X);
        Assertions.assertThat(board.getCurrentPlayer()).isEqualTo(Player.O);
    }
    @Test
    public void shouldReturnDrawWhenAllFieldsAreOccupied() {
        //given
        Board board = new Board();
        //when
        board.play(1);
        board.play(2);
        board.play(3);
        board.play(4);
        board.play(5);
        board.play(7);
        board.play(6);
        board.play(9);
        board.play(8);
        //then
        Assertions.assertThat(board.getState()).isEqualTo(State.DRAW);
    }
    @Test
    public void  shouldBeHorizontalWinner(){
        //given
        Board board = new Board();
        //when
        board.play(1);
        board.play(4);
        board.play(2);
        board.play(5);
        State state = board.play(3);
        //then
        Assertions.assertThat(state).isEqualTo(State.WINNER_X);
    }
    @Test
    public void  shouldBeVerticalWinner(){
        //given
        Board board = new Board();
        //when
        board.play(1);
        board.play(2);
        board.play(4);
        board.play(3);
        State state = board.play(7);
        //then
        Assertions.assertThat(state).isEqualTo(State.WINNER_X);
    }
    @Test
    public void  shouldBeDiagonallWinner(){
        //given
        Board board = new Board();
        //when
        board.play(1);
        board.play(2);
        board.play(5);
        board.play(3);
        State state = board.play(9);
        //then
        Assertions.assertThat(state).isEqualTo(State.WINNER_X);
    }

}