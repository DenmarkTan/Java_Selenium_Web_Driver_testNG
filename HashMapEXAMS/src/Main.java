import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		HashMap<String, Integer> phonebook = new HashMap<>();
		phonebook.put("Kevin", 12345);
		phonebook.put("Jill", 98765);
		phonebook.put("Brenda", 123123);
		phonebook.put("Kevin", 22222);
		phonebook.put(null, 000);
		if (phonebook.containsKey("Brenda")) {
			phonebook.remove("Brenda");
		}
		//phonebook.clear();
		System.out.println(phonebook);
	}
}