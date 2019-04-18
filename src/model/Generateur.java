package model;

public class Generateur extends Thread {
	private String name;
	private double capacite;
	private double rapidite;
	private Car car ;
	
	public Generateur(String name, double capacite, double rapidite, Car car) {
		super();
		this.name = name;
		this.capacite = capacite;
		this.rapidite = rapidite;
		this.car = car;
	}
	
	public double getRapidite() {
		return rapidite;
	}

	public void setRapidite(double rapidite) {
		this.rapidite = rapidite;
	}

	public void run() {
		System.out.println("yalla");
		while(true) {
			//partie en jeu
			if(car.getInGame()) {
			//System.out.println(car);	
				car.updateEnergie(capacite);
			System.out.println("updated");
			//System.out.println(name+": energie="+car.getEnergie());
			}
			//temps de pause
			try {
				
				Thread.sleep((long) ((10/rapidite)*1000));
			}
			catch(InterruptedException e) {System.out.println("Generateur:"+e);}
		
		}
		
	}

	public double getCapacite() {
		return capacite;
	}

	public void setCapacite(double capacite) {
		this.capacite = capacite;
	}
	

}
