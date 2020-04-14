package main;
import java.awt.*;

public class Car {
	//Data type
	//Integer - 1
	//double - 34.5
	//boolean - true or false
	
	double averageMilesPerGallon;
	String licensePlate;
	Color paintColor;
	boolean areTailingWorking;
	
	public Car(double inputAverageMPG, 
			String inputLicensePlate, 
			Color inputPaintColor, 
			boolean inputAreTailLightsWorking) {
		this.averageMilesPerGallon = inputAverageMPG;
		this.licensePlate = inputLicensePlate;
		this.paintColor = inputPaintColor;
		this.areTailingWorking = inputAreTailLightsWorking;
	}
	
	public void changePaintColor (Color newPaintColor) {
		this.paintColor = newPaintColor;
	}
	
	public int speedingUp(int currentSpeed) {
		currentSpeed += 100;
		return currentSpeed;
	}
}
