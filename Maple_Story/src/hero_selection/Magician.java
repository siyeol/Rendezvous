package hero_selection;

public class Magician extends Character {
	

	private String Trait;
	private String Skill1;
	private String Skill2;
	
	
	public String getTrait() {
		return Trait;
	}

	public void setTrait(String trait) {
		this.Trait = trait;
	}

	public String getSkill1() {
		return Skill1;
	}

	public void setSkill1(String skill1) {
		this.Skill1 = skill1;
	}

	public String getSkill2() {
		return Skill2;
	}

	public void setSkill2(String skill2) {
		this.Skill2 = skill2;
	}


	public Magician (String Name, int Level, String Skill1, String Skill2) {
		super(Name, Level);
		this.Name = Name;
		this.Level=Level;
		Trait = "마법을 사용하는 캐릭터";
		this.Skill1 = Skill1;
		this.Skill2 = Skill2;
		
	}
	
	public void showInfo() {
		System.out.println("========================");
		System.out.println("이 캐릭터는 마법사 입니다.");
		System.out.println("이름 : " + getName());
		System.out.println("레벨 : " + getLevel());
		System.out.println("특징 : " + getTrait());
		System.out.println("보유스킬1 : " + getSkill1());
		System.out.println("보유스킬2 : " + getSkill2());
		System.out.println("");

	}

	
}
