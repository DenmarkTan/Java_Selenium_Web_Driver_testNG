
public class Spider extends Insect{
	boolean isPoisonous;
	
	public Spider(int age, boolean isPoisonous){
		super(age, 8);
		this.isPoisonous = isPoisonous;
	}
	
	public void Says() {
		System.out.println("HISS");
	}

}
