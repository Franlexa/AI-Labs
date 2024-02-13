package fr.emse.ai.adversarial.tictactoe;

import fr.emse.ai.adversarial.AlphaBetaSearch;
import fr.emse.ai.adversarial.IterativeDeepeningAlphaBetaSearch;
import fr.emse.ai.adversarial.MinimaxSearch;

import java.util.List;
import java.util.Scanner;

public class TicTacToeGameplay {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        MinimaxSearch<List<Integer>, Integer, Integer> minimaxSearch = MinimaxSearch.createFor(game);
        AlphaBetaSearch<List<Integer>, Integer, Integer> alphabetaSearch = AlphaBetaSearch.createFor(game);
        IterativeDeepeningAlphaBetaSearch<List<Integer>, Integer, Integer> iterativeDeepeningAlphaBetaSearch = IterativeDeepeningAlphaBetaSearch.createFor(game, -1, 1, 10);
        List<Integer> state = game.getInitialState();

        while (!game.isTerminal(state)) {
            System.out.println("======================");
            System.out.println("Current Board State:");
            printTicTacToeBoard(state);

            int action = -1;
            if (game.getPlayer(state) == 1) {
                // Human player
                List<Integer> actions = game.getActions(state);
                Scanner in = new Scanner(System.in);
                while (!actions.contains(action)) {
                    System.out.println("Human player, what is your action?");
                    action = in.nextInt();
                }
            } else {
                // AI player
                System.out.println("AI player, what is your action?");
                action = minimaxSearch.makeDecision(state);
                System.out.println("Metrics for Minimax : " + minimaxSearch.getMetrics());
                alphabetaSearch.makeDecision(state);
                System.out.println("Metrics for AlphaBeta : " + alphabetaSearch.getMetrics());
                iterativeDeepeningAlphaBetaSearch.makeDecision(state);
                System.out.println("Metrics for IDAlphaBetaSearch : " + iterativeDeepeningAlphaBetaSearch.getMetrics());
            }

            System.out.println("Chosen action is " + action);
            state = game.getResult(state, action);
        }

        System.out.print("GAME OVER: ");
        if (game.getUtility(state, 1) == 1.0)
            System.out.println("Human wins!");
        else if (game.getUtility(state, 2) == 1.0)
            System.out.println("AI wins!");
        else
            System.out.println("It's a draw!");
    }

    private static void printTicTacToeBoard(List<Integer> state) {
        // Print the Tic-Tac-Toe board based on the current state
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
            }
            if (state.get(i) == 0) {
                System.out.print("-");
            } else if (state.get(i) == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
