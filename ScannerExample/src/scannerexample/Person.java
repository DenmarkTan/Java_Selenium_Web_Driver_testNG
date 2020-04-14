package scannerexample;

public class Person {
	private String name;
	private int age;
	private long phonenumber;
	
	public Person(String name, int age, long phonenumber) {
		this.name = name;
		this.age = age;
		this.phonenumber = phonenumber;
		System.out.println("Person Created: " + name + "Age: " + age + "Phonenumber" + phonenumber);
	}
}
