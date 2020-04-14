import java.awt.*;
import java.lang.Math;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Dog dg = new Dog();
		Cat ct = new Cat();
	
		if (ct instanceof Pet) {
			ct.play();
		}
		
		if (dg instanceof Pet) {
			dg.play();
		}
		
		Pet p;
		Random rand = new Random();
		int n = rand.nextInt(2);
		
		if(n==0) {
			p = new Dog();
		} else {
			p = new Cat();
		}
		
		p.play();
	}
}
