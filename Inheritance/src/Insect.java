
public class Insect {
	int age;
	int numberOflegs;
	
	public Insect(int age, int numberOflegs) {
		this.age = age;
		this.numberOflegs = numberOflegs;
	}
	
	public void says() {
		System.out.println("...");
	}
	
	public void crawl() {
		System.out.println("The insect crawled.");
	}
	
}
