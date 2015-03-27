import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;


public class ScoreBoardTest {
	
	private ScoreBoard subject;
	
	private Player playerOne;
	
	private Player playerTwo;
	
	@Before
	public void setUp(){
		subject = new ScoreBoard(playerOne, playerTwo);
	}
	
	@Test
	public void itShouldInitializeTheScoreBoardToZero() {		
		assertThat(subject.scoreForPlayer(playerOne), is("0"));
		assertThat(subject.scoreForPlayer(playerTwo), is("0"));
	}
	
	@Test
	public void itShouldIncrementPlayerScoreToFifteen() {
		subject.incrementPlayerScore(playerOne);
		
		assertThat(subject.scoreForPlayer(playerOne), is("15"));
	}
	
	@Test
	public void itShouldIncrementPlayerScoreToThirty() {
		subject.incrementPlayerScore(playerOne);
		subject.incrementPlayerScore(playerOne);
		
		assertThat(subject.scoreForPlayer(playerOne), is("30"));
	}
	
	@Test
	public void itShouldIncrementPlayerScoreToForty() {
		subject.incrementPlayerScore(playerOne);
		subject.incrementPlayerScore(playerOne);
		subject.incrementPlayerScore(playerOne);
		
		assertThat(subject.scoreForPlayer(playerOne), is("40"));
	}
	
	@Test
	public void whenBothPlayersHaveFortyTheScoreShouldBeDeuce() {
		subject.incrementPlayerScore(playerOne);
		subject.incrementPlayerScore(playerOne);
		subject.incrementPlayerScore(playerOne);
		subject.incrementPlayerScore(playerOne);
	}
}
