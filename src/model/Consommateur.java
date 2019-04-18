package model;

public class Consommateur extends Thread{
	private String name;
	private double conso;
	private double rapidite;
	private Car car ;
	public Consommateur(String name, double conso, double rapidite, Car car) {
		super();
		this.name = name;
		this.conso = conso;
		this.rapidite = rapidite;//1->10
		this.car = car;
	}
	
	public void run() {
		System.out.println("yalla");
		while(true) {
			//partie en jeu
			if(car.getInGame()) {
			car.updateEnergie(-conso);
			}
			//temps de pause
			try {
				//se recharge pour une durée inversement proportionnelle à sa rapidité
				Thread.sleep((long) ((10/rapidite)*1000));
			}
			catch(InterruptedException e) {System.out.println("Consommateur:"+e);}
		}
	}

	public double getConso() {
		return conso;
	}

	public void setConso(double conso) {
		this.conso = conso;
	}

	public double getRapidite() {
		return rapidite;
	}
	
	
}
