package hero_selection;

public class Character {
	
	protected String Name;
	protected int Level;
	private int NumOfSkills;
	private int MaxLevel;
	
	
	public String getName() {
		return Name;
	}


	public void setName(String name) {
		this.Name = name;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		this.Level = level;
	}


	public int getNumOfSkills() {
		return NumOfSkills;
	}

	public void setNumOfSkills(int numOfSkills) {
		this.NumOfSkills = numOfSkills;
	}

	public int getMaxLevel() {
		return MaxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.MaxLevel = maxLevel;
	}


	public Character(String Name, int Level) {
		this.Name=Name;
		this.Level=Level;
		NumOfSkills=2;
		MaxLevel = 200;
	}
	
}
