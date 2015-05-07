
public class PlayerScore {

	private int value;

	public PlayerScore(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void increment() {
		this.value++;
	}

}
