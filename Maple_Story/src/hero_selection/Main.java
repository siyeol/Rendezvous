package hero_selection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SwordMaster swordmaster = new SwordMaster("마검사", 30, "마겁류", "어둠의 검법");
		Magician magician = new Magician("법사법사", 210, "불꽃파워", "데스메테오");
		Archery archery = new Archery("애쉬", 100, "발리", "원거리 요격");
		
		swordmaster.showInfo();
		magician.showInfo();
		archery.showInfo();
	}

}
