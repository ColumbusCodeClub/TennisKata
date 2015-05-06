import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {

	private String[] makeMeAnEnum = { "love", "15", "30", "40" , "adv"};

	private Map<Player, Integer> scores;

	private int playerOneScore = 0;
	private int playerTwoScore = 0;

	private Player playerOne;
	private Player playerTwo;

	public ScoreBoard(Player playerOne, Player playerTwo) {

		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}

	public void incrementPlayerScore(Player player) {
		if (player == playerOne) {
			playerOneScore++;
		} else {
			playerTwoScore++;
		}
	}

	public String scoreForPlayer(Player player) {
		if (player == playerOne) {
			return makeMeAnEnum[playerOneScore];
		} else {
			return makeMeAnEnum[playerTwoScore];
		}

	}

	public String scoreForGame() {
		if (playerOneScore == 5) {
			playerOneScore = 4;
			playerTwoScore = 3;
		}
		
		if (playerOneScore == playerTwoScore) {
			return playerOneScore >= 3 ? "deuce" : makeMeAnEnum[playerOneScore] + " all";
		} else {
			return makeMeAnEnum[playerOneScore] + " - "
					+ makeMeAnEnum[playerTwoScore];
		}
	}

}
