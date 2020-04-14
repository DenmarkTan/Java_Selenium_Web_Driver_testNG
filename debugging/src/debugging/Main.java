package debugging;

import debugging.Coin;
import java.awt.*;
import java.util.concurrent.Future;
import java.util.Scanner;
import java.util.Arrays;
//random constructor
import java.util.Random;
import java.lang.Math;

public class Main {
	public static void main(String[] args) {
			//coin
			Coin c = new Coin();
			System.out.println("Initial :" +c.getFaceUp());
			for(int i = 0; i < 10; i++) {
				c.flip();
				System.out.println("After Flip :" +c.getFaceUp());
			}
	}
}
