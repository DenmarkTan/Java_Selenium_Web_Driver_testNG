import java.util.ArrayList;

public class Varargs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String item1 = "Apples";
		String item2 = "Oranges";
		String item3 = "Pears";
		
		//String[] shopping = {"Bread", "Milk", "Egg", "Bananas"};
		printShoppingList(item1, item2, item3);
		//printShoppingList(shopping);
		printShoppingList("Bread", "Milk", "Egg", "Bananas");
	}

//	private static void printShoppingList(String item1, String item2) {
//		// TODO Auto-generated method stub
//		System.out.println("Shopping List");
//		System.out.println("1."+ item1);
//		System.out.println("2."+ item2);	
//	}
//	
//	private static void printShoppingList(String item1, String item2, String item3) {
//		// TODO Auto-generated method stub
//		System.out.println("Shopping List");
//		System.out.println("1."+ item1);
//		System.out.println("2."+ item2);	
//		System.out.println("3."+ item3);	
//		System.out.println();
//	}
	
//	private static void printShoppingList(String[] items) {
//		// TODO Auto-generated method stub
//		System.out.println("Shopping List");
//		for (int i=0; i < items.length; i++) {
//			System.out.println(i + 1 + ":" + items[i]);
//		}
//		System.out.println();
//	}
	// one, two, three 
	private static void printShoppingList(String... items) {
		// TODO Auto-generated method stub
		System.out.println("Shopping List");
		for (int i=0; i < items.length; i++) {
			System.out.println(i + 1 + ":" + items[i]);
		}
		System.out.println();
	}

}
