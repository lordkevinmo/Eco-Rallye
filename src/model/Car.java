package model;

import java.util.ArrayList;
import java.util.List;

import view.Body;

public class Car {

	//Partie démarre : inGame=true ->consommateurs/generateur = démarrés
	//Partie est fini: inGame=false -> consommateurs/generateur = arretés
	private boolean inGame=false;
	private Body body ;
	//Caractéristiques de la voiture
	private final double nElectricVehicle = 0.8d; // Rendement global entre les roues et la batterie
	private final double p = 0.2d;                // Coefficient de freinage (elle est de 0.46 en conduite urbaine et de O.1 sue l'autoroute)
	private final double nRecup = 0.6d;            // Taux d'energie de freinage récupérée
	//Mutex de modification d'energie 
	private boolean dispo=true;
	private double energie=30;
	//Threads consommateurs 
	private List<Consommateur> cons=new ArrayList<Consommateur>();
	//Threads generateurs
	private List<Generateur> gens=new ArrayList<Generateur>(); 
	public Car() {
		System.out.println("Go ");
		cons.add(new Consommateur("Poids", 2, 2, this));
		gens.add(new Generateur("Panneau solaire", 6, 2, this));
		demarrer();
	}	
	public boolean getInGame() {
		
		return inGame;
	}
	public void setInGame(boolean b) {
		if(b==true)//nouvelle partie
			energie=100000000;
		inGame=b;
	}
	public void demarrer() {
		for(Consommateur e : cons)
			e.start();
		for(Generateur g : gens)
			g.start();
	}
	public void accelerer(double acceleration) {
		energie+=acceleration;
	}

    public double ralentir() {
        return ((this.energie * nElectricVehicle * p) / (1 - nElectricVehicle * p * nRecup));
    }


    //Pour des raisons de simplicité et de concordance avec l'environnement du jeu
    //Nous divisons l''énergie réel récupéré par 100.
    public void energieRecuperee(){
        this.energie+= nRecup*ralentir()/100;

    }

	public void roueLibre() {
		//rien faire pour le moment 
	}
	public double getEnergie() {
		return energie ;
	}
	
	public List<Consommateur> getCons() {
		return cons;
	}
	public void setCons(List<Consommateur> cons) {
		this.cons = cons;
	}
	public List<Generateur> getGens() {
		return gens;
	}
	public void setGens(List<Generateur> gens) {
		this.gens = gens;
	}
	//val > 0 : augmentation d'énergie sinon diminution d'énergie
	public synchronized void updateEnergie(double val) {
		while(!dispo) {
			try {wait();}
			catch(InterruptedException e) {System.out.println("Car: "+e);}
		}
		energie+=val;
		dispo=true;notifyAll();
	}

    public double getnElectricVehicle() {
        return nElectricVehicle;
    }

    public double getnRecup() {
        return nRecup;
    }

    public double getP() {
        return p;
    }
}
