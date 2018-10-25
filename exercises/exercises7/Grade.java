package exercises7;

public class Grade {
	
	private String name;
	private int score;
	
	public Grade(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Grade [name=" + name + ", score=" + score + "]";
	}
	
}
