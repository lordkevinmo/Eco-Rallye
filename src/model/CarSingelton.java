package model;

public class CarSingelton {
	private static Car car = new Car();
	public static Car getTheCar() {
		return car;
	}
}
