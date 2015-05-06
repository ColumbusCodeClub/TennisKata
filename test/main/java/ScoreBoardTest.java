import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class ScoreBoardTest {
	
	private ScoreBoard subject;
	
	private Player playerOne = new Player();
	
	private Player playerTwo = new Player();
	
	@Before
	public void setUp(){
		subject = new ScoreBoard(playerOne, playerTwo);
	}
	
	@Test
	public void itShouldInitializeTheScoreBoardToZero() {		
		assertThat(subject.scoreForPlayer(playerOne), is("love"));
		assertThat(subject.scoreForPlayer(playerTwo), is("love"));
	}
	
	@Test
	public void itShouldInitializeTheGameScoreToLoveLove() {		
		assertThat(subject.scoreForGame(), is("love all"));
	}
	
	@Test
	public void theGameScoreBe15LoveIfPlayerOneScores() {		
		scoreTimes(playerOne, 1);
		assertThat(subject.scoreForGame(), is("15 - love"));
	}

	@Test
	public void theGameScoreBeLove15IfPlayerTwoScores() {		
		scoreTimes(playerTwo, 1);

		assertThat(subject.scoreForGame(), is("love - 15"));
	}
	
	@Test
	public void theGameScoreBe15AllIfPlayerOneAndTwoScoresOnce() {		
		scoreTimes(playerOne, 1);
		scoreTimes(playerTwo, 1);

		assertThat(subject.scoreForGame(), is("15 all"));
	}
	
	@Test
	public void theGameScoreBe30AllIfPlayerOneAndTwoScoresTwice() {		
		scoreTimes(playerOne, 2);
		scoreTimes(playerTwo, 2);

		assertThat(subject.scoreForGame(), is("30 all"));
	}
	
	@Test
	public void itShouldIncrementPlayerScoreToFifteen() {
		scoreTimes(playerOne, 1);
		
		assertThat(subject.scoreForPlayer(playerOne), is("15"));
	}
	
	@Test
	public void itShouldIncrementPlayerScoreToThirty() {
		scoreTimes(playerOne, 2);
		
		assertThat(subject.scoreForPlayer(playerOne), is("30"));
	}
	
	@Test
	public void itShouldIncrementPlayerScoreToForty() {
		scoreTimes(playerOne, 3);
		
		assertThat(subject.scoreForPlayer(playerOne), is("40"));
	}
	
	@Test
	public void itShouldBe40ToLoveIfPlayerOneScoresThreeTimesInARow() {
		scoreTimes(playerOne, 3);
		
		assertThat(subject.scoreForGame(), is("40 - love"));
	}
	
	@Test
	public void whenBothPlayersHaveFortyTheScoreShouldBeDeuce() {
		scoreTimes(playerOne, 3);
		scoreTimes(playerTwo, 3);
		
		assertThat(subject.scoreForGame(), is("deuce"));
	}

	@Test
	public void whenPlayersAreDeuceAndPlayerOneScoresThenPlayerOneHasAdvantage() {
		deuce();
		scoreTimes(playerOne, 1);
		
		assertThat(subject.scoreForGame(), is("adv - 40"));
	}
	
	@Test
	public void whenPlayersAreDeuceAndPlayerTwoScoresThenPlayerTwoHasAdvantage() {
		deuce();
		scoreTimes(playerTwo, 1);
		
		assertThat(subject.scoreForGame(), is("40 - adv"));
	}
	
	@Test
	public void whenPlayerOneHasAdvantageAndPlayerTwoScoresTheScoreShouldBeDeuce() {
		deuce();
		scoreTimes(playerOne, 1);
		scoreTimes(playerTwo, 1);
		
		assertThat(subject.scoreForGame(), is("deuce"));
	}
	
	@Test
	public void whenPlayersBreakAdvantageThenPlayerOneScoresPlayerOneShouldHaveAdvantage() {
		deuce();
		scoreTimes(playerOne, 1);
		scoreTimes(playerTwo, 1);
		scoreTimes(playerOne, 1);
		
		assertThat(subject.scoreForGame(), is("adv - 40"));
	}
	
	@Test
	public void whenPlayersBreakAdvantageThenPlayerTwoScoresPlayerTwoShouldHaveAdvantage() {
		deuce();
		scoreTimes(playerOne, 1);
		scoreTimes(playerTwo, 1);
		scoreTimes(playerTwo, 1);
		
		assertThat(subject.scoreForGame(), is("40 - adv"));
	}
	
	private void deuce() {
		scoreTimes(playerOne, 3);
		scoreTimes(playerTwo, 3);
	}
	
	private void scoreTimes(Player player, int times) {
		for(int i = 0; i < times; i++) {
			subject.incrementPlayerScore(player);	
		}
	}
	
	
}
