
public class Cricket extends Insect{
	double length;
	int no;
	
	public Cricket(int no, double length) {
		super(2, 6);
		this.no = no;
		this.length = length;
	}
		
	public void says() {
		System.out.println("Chirp");
	}
	
	public void jump() {
		System.out.println("A cricket jumped!");
	}
}
