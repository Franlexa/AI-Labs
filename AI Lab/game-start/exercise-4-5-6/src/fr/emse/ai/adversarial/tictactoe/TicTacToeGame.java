package fr.emse.ai.adversarial.tictactoe;

import fr.emse.ai.adversarial.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeGame implements Game<List<Integer>, Integer, Integer> {

    private static final int EMPTY = 0;
    private static final int PLAYER_X = 1;
    private static final int PLAYER_O = 2;

    @Override
    public List<Integer> getInitialState() {
        // Initial state of an empty Tic-Tac-Toe board
        return Arrays.asList(
                EMPTY, EMPTY, EMPTY,
                EMPTY, EMPTY, EMPTY,
                EMPTY, EMPTY, EMPTY
        );
    }

    @Override
    public Integer[] getPlayers() {
        return new Integer[]{PLAYER_X, PLAYER_O};
    }

    @Override
    public Integer getPlayer(List<Integer> state) {
        // Determine the current player based on the number of moves played
        int totalMoves = (int) state.stream().filter(player -> player != EMPTY).count();
        return (totalMoves % 2 == 0) ? PLAYER_X : PLAYER_O;
    }

    @Override
    public List<Integer> getActions(List<Integer> state) {
        // Find empty positions on the board
        List<Integer> actions = new ArrayList<>();
        for (int i = 0; i < state.size(); i++) {
            if (state.get(i) == EMPTY) {
                actions.add(i);
            }
        }
        return actions;
    }

    @Override
    public List<Integer> getResult(List<Integer> state, Integer action) {
        // Make a move on the board and return the new state
        List<Integer> newState = new ArrayList<>(state);
        int currentPlayer = getPlayer(state);
        newState.set(action, currentPlayer);
        return newState;
    }

    @Override
    public boolean isTerminal(List<Integer> state) {
        // Check if the game is in a terminal state (win, draw, or ongoing)
        return checkWin(state, PLAYER_X) || checkWin(state, PLAYER_O) || state.stream().allMatch(position -> position != EMPTY);
    }

    @Override
    public double getUtility(List<Integer> state, Integer player) {
        // Assign utility values based on the outcome of the game
        if (checkWin(state, PLAYER_X)) {
            return (player == PLAYER_X) ? 1.0 : -1.0;
        } else if (checkWin(state, PLAYER_O)) {
            return (player == PLAYER_O) ? 1.0 : -1.0;
        } else {
            return 0.0; // Draw
        }
    }

    // Helper method to check for a win
    private boolean checkWin(List<Integer> state, int player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if ((state.get(i * 3) == player && state.get(i * 3 + 1) == player && state.get(i * 3 + 2) == player) ||
                    (state.get(i) == player && state.get(i + 3) == player && state.get(i + 6) == player)) {
                return true;
            }
        }
        return (state.get(0) == player && state.get(4) == player && state.get(8) == player) ||
                (state.get(2) == player && state.get(4) == player && state.get(6) == player);
    }
}
