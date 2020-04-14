package wildcards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
//		//List of buildings	
//		List<Building> buildings = new ArrayList();
//		buildings.add(new Building());
//		printBuildings(buildings);
//		
//		//List of offices
//		List<Office> offices = new ArrayList();
//		offices.add(new Office());
//		offices.add(new Office());
//		printBuildings(offices);
//		
//		//List of houses
//		List<House> houses = new ArrayList();
//		houses.add(new House());
//		houses.add(new House());
//		printBuildings(houses);
//		
//		addHouseToList(houses);
//		addHouseToList(buildings);
//}
//	
//	 static void printBuildings(List<? extends Building> buildings) {
//		// TODO Auto-generated method stub
//		for(int i = 0; i < buildings.size(); i++) {
//			System.out.println(buildings.get(i).toString() + " " + (i + 1));
//		}
//		System.out.println();
//	}
//	
//	static void addHouseToList(List<? super House> buildings) {
//		buildings.add(new House());
//		for(int h = 0; h < buildings.size(); h++) {
//			System.out.println(buildings.get(h).toString() + " " + (h + 1));
//		}
//		System.out.println();
//	}
		
		
			
			HashMap<String, Integer> phonebook = new HashMap<>();
			phonebook.put("Kevin", 12345);
			phonebook.put("Jill", 98765);
			phonebook.put("Brenda", 123123);
			phonebook.put("Kevin", 22222);

			
			System.out.println(phonebook);
	}
		
}
			