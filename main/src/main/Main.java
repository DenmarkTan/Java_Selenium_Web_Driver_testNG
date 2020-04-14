package main;
//Contains all of the classes for creating user interfaces and for painting graphics and images.
import java.awt.Color;
import java.lang.reflect.Array;
//use for obtaining the input of the primitive types
import java.util.Scanner;
//for array
import java.util.Arrays;



@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
	//private static double inputAverageMPG;
	//private static String inputLicensePlate;
	//private static boolean inputAreTailLightsWorking;
		
		
		Dog myDog = new Dog("Doug",3);
		myDog.bark();
		int dogYears = myDog.getDogYears();
		System.out.println(dogYears + " dog years.");
		
		myDog.fetch();
		myDog.fetch();
		myDog.fetch();
		myDog.fetch();


//		System.out.println("Hello World");
		
		//replace character
		
//		String s = "dog";
//		String replacedF = s.replace("d","f");
//		System.out.println(replacedF);

//		double inputAverageMPG;
//		String inputLicensePlate;
//		boolean inputAreTailLightsWorking;
//		
//		Car myCar = new Car(inputAverageMPG = 25.5, 
//				inputLicensePlate = "1BC32E", 
//				Color.BLUE, 
//				inputAreTailLightsWorking = true);
//		
//		Car sallyCar = new Car(inputAverageMPG =  13.9, 
//				inputLicensePlate = "3D20BN", 
//				Color.BLUE, 
//				inputAreTailLightsWorking =  false);	
//		//print the car speed
//		int myCarSpeeds = 50;
//		myCarSpeeds = sallyCar.speedingUp(myCarSpeeds);
//		System.out.println(myCarSpeeds);
		
		
		
//		System.out.println("My Car's License Plate : " + myCar.licensePlate);
//		System.out.println("My Car's License Plate : " + sallyCar.areTailingWorking);
//		
//		//Before call the method
//		System.out.println("My Car's License Plate : " + myCar.paintColor);
//		myCar.changePaintColor(Color.RED);
//		//After call the method
//		System.out.println("My Car's License Plate : " + myCar.paintColor);
//		
//		//second program
//		
//		String userInput2 = "entertainment";
//		String uppercased2 = userInput2.toUpperCase();
//		System.out.println(uppercased2);
//		
//		char firstCharacter = userInput2.charAt(0);
//		System.out.println(firstCharacter);
//		
//		System.out.println("Contains: "+ userInput2.contains("Enter".toLowerCase()));
//		
//		//third program
//		@SuppressWarnings("resource")
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter a word: ");
//		String userInput = sc.next();
//		String uppercased = userInput.toLowerCase();
//		System.out.println(uppercased);
//		
//	
//		//program for printing from user
//		@SuppressWarnings("resource")
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter a number: ");
//		int userNumber = scan.nextInt();
//		System.out.println("userNumber: "+ userNumber);
//		double userNumber2 = scan.nextDouble();
//		System.out.println("userNumber2: "+userNumber2);
//		
//		// 31,45,22,98,10
//		int[]numbers = new int[5];
//		numbers[0] = 31;
//		numbers[1] = 45;
//		numbers[2] = 22;
//		numbers[3] = 98;
//		numbers[4] = 10;
//		
//		//sort array
//		Arrays.sort(numbers);
//		System.out.println("Sort: " + Arrays.toString(numbers));
//		
//		int[] numbers2 =  {31,45,22,98,10};
//		
//		System.out.println("Index 3: " + numbers2[2]);
//		String[] myFavoriteCandyBars = {"Twix","Hersheys","Crunch", "Nutella"};
//		System.out.println("Index 3: " + myFavoriteCandyBars[2]);
//		myFavoriteCandyBars[1] = "Kitkat";
//		System.out.println("Index 2:" + myFavoriteCandyBars[1]);
//		System.out.println("Length:" + myFavoriteCandyBars.length);
//		//get second array and print
//		System.out.print(Array.get(myFavoriteCandyBars, 2));
	}
	

}
