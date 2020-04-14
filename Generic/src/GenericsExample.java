import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
	public static void main(String[] args) {
		
		//Example without generics
		List names = new ArrayList();
		names.add("Kelly");
		String name = (String) names.get(0);
		System.out.println("First name: "+name);
		names.add("test7");
		System.out.println("Final: "+names.get(1));
		
		//Example with generics
		List<String>names2 = new ArrayList();
		names2.add("Kelly");
		String name2 = (String) names2.get(0);
		System.out.println("First name: "+name2);
		//names2.add(7);
		
	}

}
