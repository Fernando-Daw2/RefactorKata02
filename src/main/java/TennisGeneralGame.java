public class TennisGeneralGame implements TennisGame {
    private Player player1;
    private Player player2;
    
    public TennisGeneralGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName))
            this.player1.addPoint();
        else
            this.player2.addPoint();
    }

    @Override
    public String getScore() {
        if (player1.getScore() == player2.getScore()) {
            return equalScore();
        } else if (player1.getScore() >= 4 || player2.getScore() >= 4) {
           return scoreMoreFour();
        } else {
            return getScoreByPlayer(player1.getScore()) + "-" + getScoreByPlayer(player2.getScore());
        }
    }

    private String getScoreByPlayer(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String scoreMoreFour() {
        int minusResult = player1.getScore() - player2.getScore();
        if (minusResult == 1) return "Advantage "+ player1.getName();
        else if (minusResult == -1) return "Advantage "+ player2.getName();
        else if (minusResult >= 2) return "Win for " +player1.getName();
        else return "Win for "+ player2.getName();
    }

    private String equalScore() {
        switch (player1.getScore()) {
            case 0:
                return  "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";

        }
    }
}
