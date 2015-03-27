import java.util.HashMap;
import java.util.Map;


public class ScoreBoard {

	private String[] makeMeAnEnum = {"0", "15", "30", "40"};

	private Map<Player, Integer> scores;
	
	public ScoreBoard(Player playerOne, Player playerTwo) {
		
		scores = new HashMap<Player, Integer>();
		scores.put(playerOne, 0);
		scores.put(playerTwo, 0);
	}

	public void incrementPlayerScore(Player player) {
		int newScore = scores.get(player) + 1;
		
		scores.put(player, newScore);
	}

	public String scoreForPlayer(Player player) {
		return makeMeAnEnum[scores.get(player)];
	}

}
