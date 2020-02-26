package ohtu;

import java.util.HashMap;

public class TennisGame {

    private HashMap<String, Integer> scoreboard;
    private String playerOneKey;
    private String playerTwoKey;

    public TennisGame(String playerOneName, String playerTwoName) {
        scoreboard = new HashMap<>();
        playerOneKey = playerOneName;
        playerTwoKey = playerTwoName;
        scoreboard.put(playerOneName, 0);
        scoreboard.put(playerTwoName, 0);
    }

    public void wonPoint(String playerName) {
        scoreboard.put(playerName, scoreboard.get(playerName) + 1);
    }

    public String getScore() {
        int playerOneScore = scoreboard.get(playerOneKey);
        int playerTwoScore = scoreboard.get(playerTwoKey);

        if (playerOneScore >= 4 || playerTwoScore >= 4) {
            if (playerOneScore == playerTwoScore) {
                return "Deuce";
            }
            return advantageAsString(playerOneScore, playerTwoScore);
        } else {
            String score = pointsAsString(playerOneScore);
            score += "-";
            if (playerOneScore != playerTwoScore) {
                return score += pointsAsString(playerTwoScore);
            } else {
                return score += "All";
            }
        }
    }

    private String pointsAsString(int points) {
        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
        }
        return "Forty";
    }

    private String advantageAsString(int pointsOne, int pointsTwo) {
        int pointsForOne = pointsOne - pointsTwo;

        switch (pointsForOne) {
            case -1:
                return "Advantage player2";
            case 1:
                return "Advantage player1";
        }
        if (pointsForOne >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }
}
