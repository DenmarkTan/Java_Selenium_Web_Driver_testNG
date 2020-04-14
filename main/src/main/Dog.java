package main;
import java.awt.*;

public class Dog{
	
	String name;
	int age;
	String[] fetchItems = {"bone","stick","ball"};
	private int fetchcounter = 0;
	
		public Dog(String name, 
				int age) {
			this.name = name;
			this.age = age;
		}

		public void bark() {
			System.out.println("Bark");
		}
		
		public int getDogYears() {
			// assume dog year is 7 years
			return this.age * 7;
		}
		
		public void fetch() {
			this.fetchcounter = (this.fetchcounter + 1) % 3;
			String item = this.fetchItems[this.fetchcounter];
			System.out.println(name + " fetched " + item + ".");
		}
}

