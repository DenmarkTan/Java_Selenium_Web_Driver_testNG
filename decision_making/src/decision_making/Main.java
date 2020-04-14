package decision_making;
import java.awt.*;
import java.util.concurrent.Future;
import java.util.Scanner;
import java.util.Arrays;
//random constructor
import java.util.Random;

public class Main {
	public static void main(String[] args) {
//		System.out.println("Enter an age: ");
//		Scanner in = new Scanner(System.in);
//		int age = in.nextInt();
//		
//		if(age >= 0 && age <=5) {
//			System.out.println("Baby");
//		} else if (age >=6 && age <= 11) {
//			System.out.println("Kid");
//		} else if (age >=12 && age <= 17) {
//			System.out.println("Teen");
//		}else if (age >=18 ) {
//			System.out.println("Adult");
//		} else {
//			System.out.println("Invalid");
//		}
//		System.out.println("Thank you for using program");
		
		//while loop
//		System.out.println("While Loop");
//		int x=3;
//		while (x>0) {
//			System.out.println("Current x: " + x);
//			x = x-1;
//		}
//		System.out.println("Result x: "+x);
//		System.out.println();
		
		//do while
//		System.out.println("Do while loop");
//		int y = 3;
//		do {
//			System.out.println("Current y:" + y);
//			y = y - 1;
//		} while (y > 0);
//		System.out.println("Result y: "+y);
//		System.out.println();
		
		//for loop
		
//		System.out.println("For loop");
//		for(int i = 3; i>0; i--) {
//			System.out.println("Current i: "+i);
//		} 
//		System.out.println();
		
		//library static from java lang
		double power = Math.pow(5, 3);
		System.out.println(power);
		
		double squareRoot = Math.sqrt(64);
		System.out.println(squareRoot);
		
		//random constructor
		Random rand = new Random();
		int randomNumber = rand.nextInt();
		int randomNumberWithBound = rand.nextInt(10);
		System.out.println(randomNumber);
		System.out.println(randomNumberWithBound);
		
		
	}
}
