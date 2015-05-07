import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {

	private String[] makeMeAnEnum = { "love", "15", "30", "40" , "adv"};

	private PlayerScore playerOneScore = new PlayerScore(0);
	private PlayerScore playerTwoScore = new PlayerScore(0);
	private int diff;

	private Player playerOne;
	private Player playerTwo;

	public ScoreBoard(Player playerOne, Player playerTwo) {

		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}

	public void incrementPlayerScore(Player player) {
		if (player == playerOne) {
			updatePlayerScores(playerOneScore, playerTwoScore);
		} else {
			updatePlayerScores(playerTwoScore, playerOneScore);
		}
		diff = playerOneScore.value() - playerTwoScore.value();
	}

	private void updatePlayerScores(PlayerScore scoreToIncrease, PlayerScore otherScore) {
		if (scoreToIncrease.value() == 4 && scoreIsTied()) {
			otherScore.setValue(3);
		} else {
			scoreToIncrease.increment();
		}
	}
	
	private boolean scoreIsTied() {
		return diff == 0;
	}
	
	public String scoreForPlayer(Player player) {
		if (player == playerOne) {
			return makeMeAnEnum[playerOneScore.value()];
		} else {
			return makeMeAnEnum[playerTwoScore.value()];
		}

	}

	public String scoreForGame() {
		if (diff > 0) {
			if (diff > 2 && playerOneScore.value() > 3) {
				return "Player one wins";
			}
		} else if (diff < 0) {
			if (diff < -2 && playerTwoScore.value() > 3) {
				return "Player two wins";
			}
		} else {
			return playerOneScore.value() >= 3 ? "deuce" : makeMeAnEnum[playerOneScore.value()] + " all";
		}
		
		return makeMeAnEnum[playerOneScore.value()] + " - "
			+ makeMeAnEnum[playerTwoScore.value()];
	}

}
