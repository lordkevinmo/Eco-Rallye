package view;
 import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.ImageIcon;

import controller.RenderController;
import model.Car;
import model.CarSingelton;
import model.Consommateur;
import model.Generateur;
import model.STATE;
import model.UserSingeleton;
 /**
 * World class.
 * 
 */

//la voiture n'est pas aussez fluide dans son mouvement , il faut probablement voir cette classe ?
public class PisteView {
    
	public static boolean fourchette=true;
    public static final Position GRAVITY = new Position(0, 0.8);
    private double xFin;//abscisse du finish, remplie dans la méthode load selon la course
    private Camera camera;
    private final List<Particle> particles = new ArrayList<Particle>();
    private final List<Stick> sticks = new ArrayList<Stick>();
    private final List<Capsule> capsules = new ArrayList<Capsule>();
    private final List<Puff> puffs = new ArrayList<Puff>();
    private final List<Puff> puffsRemove = new ArrayList<Puff>();
    private String msg="";//message d'utilsation d'option achetée
    private boolean consommation=true;//par défaut , la voiture consomme (sauf achat d'un timer)
    private STATE state = STATE.ALIVE;
    private  Car car ;
    private Body body;
    private Head head;
    private int temps=20;
    
    private Wheel pk, pl;

    public PisteView(){
    	car = CarSingelton.getTheCar();
    	car.setInGame(true);
    	if(fourchette)
    	new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				temps--;
				if(temps<0)
					this.cancel();
			}
		}, 100, 1000);
    	  	
      	 
    }
     public List<Capsule> getCapsules() {
        return capsules;
    }
    public STATE getState() {
    	return state;
    }
    public void load1() {
    	System.out.println("Load 1 in the house");
         // Déclaration des particules pour les positionner dans l'espace
    	System.out.println("Load 2 in the house");
        Particle pa, pb, pg, ph, pi, pj;
        particles.add(pa = new Particle(this, 145, 60));
        particles.add(pb = new Particle(this, 145, 100));
        
        particles.add(pg = new Particle(this, 100, 100));
        particles.add(ph = new Particle(this, 225, 100));
        particles.add(pi = new Particle(this, 225, 150));
        particles.add(pj = new Particle(this, 100, 150));
        
        particles.add(pk = new Wheel(this, 100, 180, 30));
        particles.add(pl = new Wheel(this, 225, 180, 30));
        body = new Body(pk, pl);
        camera = new Camera(body);
        head = new Head(pa, pb);
        
        Stick se, sf, sg, sh, si, sj;
        sticks.add(new Stick(pg, pb));
        sticks.add(new Stick(pb, ph));
        sticks.add(se = new Stick(pa, pg));
        sticks.add(sf = new Stick(pa, pb));
        sticks.add(sg = new Stick(pb, pj));
        sticks.add(sh = new Stick(pa, ph));
        sticks.add(si = new Stick(pa, pj));
        sticks.add(sj = new Stick(pa, pi));
        se.setStiffness(0.0000001);
        sg.setStiffness(0.0000001);
        sh.setStiffness(0.0000001);
        si.setStiffness(0.00000025);
        sj.setStiffness(0.00000025);
        
        sticks.add(new Stick(pg, ph));
        sticks.add(new Stick(ph, pi));
        sticks.add(new Stick(pi, pj));
        sticks.add(new Stick(pj, pg));
        sticks.add(new Stick(pg, pi));
        sticks.add(new Stick(ph, pj));
        
        Stick sa, sb, sc, sd;
        sticks.add(sa = new Stick(pj, pk));
        sticks.add(new Stick(pk, pl));
        sticks.add(sb = new Stick(pl, pi));
        sticks.add(new Stick(pj, pl));
        sticks.add(new Stick(pk, pi));
        
        sticks.add(sc = new Stick(pg, pl));
        sticks.add(sd = new Stick(ph, pk));
        
        sa.setStiffness(0.0000000000000001);
        sb.setStiffness(0.0000000000000001);
        sc.setStiffness(0.0000000000000001);
        sd.setStiffness(0.0000000000000001);
        
        createBridge();
        createTerrain();
    
    }

    public void load2() {
    	System.out.println("Load 2 in the house");
        Particle pa, pb, pg, ph, pi, pj;
        particles.add(pa = new Particle(this, 145, 60));
        particles.add(pb = new Particle(this, 145, 100));
        
        particles.add(pg = new Particle(this, 100, 100));
        particles.add(ph = new Particle(this, 225, 100));
        particles.add(pi = new Particle(this, 225, 150));
        particles.add(pj = new Particle(this, 100, 150));
        
        particles.add(pk = new Wheel(this, 100, 180, 30));
        particles.add(pl = new Wheel(this, 225, 180, 30));
        body = new Body(pk, pl);
        camera = new Camera(body);
        head = new Head(pa, pb);
        
        Stick se, sf, sg, sh, si, sj;
        sticks.add(new Stick(pg, pb));
        sticks.add(new Stick(pb, ph));
        sticks.add(se = new Stick(pa, pg));
        sticks.add(sf = new Stick(pa, pb));
        sticks.add(sg = new Stick(pb, pj));
        sticks.add(sh = new Stick(pa, ph));
        sticks.add(si = new Stick(pa, pj));
        sticks.add(sj = new Stick(pa, pi));
        se.setStiffness(0.0000001);
        sg.setStiffness(0.0000001);
        sh.setStiffness(0.0000001);
        si.setStiffness(0.00000025);
        sj.setStiffness(0.00000025);
        
        sticks.add(new Stick(pg, ph));
        sticks.add(new Stick(ph, pi));
        sticks.add(new Stick(pi, pj));
        sticks.add(new Stick(pj, pg));
        sticks.add(new Stick(pg, pi));
        sticks.add(new Stick(ph, pj));
        
        Stick sa, sb, sc, sd;
        sticks.add(sa = new Stick(pj, pk));
        sticks.add(new Stick(pk, pl));
        sticks.add(sb = new Stick(pl, pi));
        sticks.add(new Stick(pj, pl));
        sticks.add(new Stick(pk, pi));
        
        sticks.add(sc = new Stick(pg, pl));
        sticks.add(sd = new Stick(ph, pk));
        
        sa.setStiffness(0.0000000000000001);
        sb.setStiffness(0.0000000000000001);
        sc.setStiffness(0.0000000000000001);
        sd.setStiffness(0.0000000000000001);
        
        createBridge();
        createTerrain2();
          
    }

    //Création d'un pont (à rajouter peut-être après)
    private void createBridge() { //

    }
    
    public void createTerrain() {
        xFin = 12720;
    	System.out.println("createTerrain jus d'orange sans citron");
        double radius = 30;

        Circle c1, c2;
        particles.add(c1 = new Circle(this, 0, 550, radius));
        particles.add(c2 = new Circle(this, 3800, 350, radius));
        c1.setPinned(true);
        c2.setPinned(true);
        capsules.add(new Capsule(this, c1, c2));

         radius = 30;
        //Fin piste 
        double k = 0;
        Circle co, cp;

        particles.add(cp = new Circle(this, 3870,550+ 0, radius));
        for (int x = 3860; x < 7000; x+=60) {
            double y = 150 * Math.cos(k);
            k += 0.2;
            particles.add(co = new Circle(this, x, 350 + y, radius));
            capsules.add(new Capsule(this, cp, co));
            co.setPinned(true);
            cp.setPinned(true);
            cp = co;
            radius = 30;
        }
        
        //espace vide 
        //pente 
        particles.add(cp = new Circle(this, 7500, 350 + 0, radius));
        for(int x=7500,y=350;x<7900;x+=50) {
        	y-=30;
        particles.add(co = new Circle(this, x, y, radius));
        capsules.add(new Capsule(this, cp, co));
        co.setPinned(true);
        cp.setPinned(true);
        cp = co;
        }
        //up hill
        for (int x = 8000; x < 9600; x+=70) {
            double y = 200 * Math.cos(k)+50;
            k += 0.2;
            particles.add(co = new Circle(this, x, 200 + y, radius));
            capsules.add(new Capsule(this, cp, co));
            co.setPinned(true);
            cp.setPinned(true);
            cp = co;
            radius = 30;
        }
        

        particles.add(cp = new Circle(this, 9700, 350 + 0, radius));
        for (int x = 9700; x < 10700; x+=80) {
            double y = 100 * Math.cos(k)+100;
            k += 0.2;
            particles.add(co = new Circle(this, x, 350 + y, radius));
            capsules.add(new Capsule(this, cp, co));
            co.setPinned(true);
            cp.setPinned(true);
            cp = co;
            radius = 30;
        }
        for (int x = 11000; x < 13000; x+=80) {
            double y = 100 * Math.tanh(k)+100;
            k += 0.2;
            particles.add(co = new Circle(this, x, 120 + y, radius));
            capsules.add(new Capsule(this, cp, co));
            co.setPinned(true);
            cp.setPinned(true);
            cp = co;
            radius = 30;
            //System.out.println("cp:(x="+cp.getPosition().getX()+",y="+cp.getPosition().getY()+")");
        }
        //particule de finish
        cp.setRadius(80);
        particles.add(cp);
        Capsule finishLine=new Capsule(this, cp, cp);
        finishLine.setColor(Color.GREEN);
        capsules.add(finishLine);
        
        
         
    }
    public void createTerrain2() {
    	xFin=9000-265;
    	System.out.println("///////////////////////Lauched this");
        double radius = 30;

        Circle c1, c2;
        particles.add(c1 = new Circle(this, 0, 550, radius));
        particles.add(c2 = new Circle(this, 1900, 350, radius));
        c1.setPinned(true);
        c2.setPinned(true);
        capsules.add(new Capsule(this, c1, c2));
         // rampa
        Circle c3, c4;
        particles.add(c3 = new Circle(this, 1250, 550, radius));
        particles.add(c4 = new Circle(this, 1400, 450, radius));
        c3.setPinned(true);
        c4.setPinned(true);
        capsules.add(new Capsule(this, c3, c4));
         Circle c5, c6;
        particles.add(c5 = new Circle(this, 1500, 450, radius));
        particles.add(c6 = new Circle(this, 1650, 550, radius));
        c5.setPinned(true);
        c6.setPinned(true);
        capsules.add(new Capsule(this, c5, c6));
         radius = 30;
        //Fin piste 
        double k = 0;
        Circle co, cp;
        particles.add(cp = new Circle(this, 1900, 350 + 0, radius));
        for (int x = 0; x < 3000; x+=60) {
            double y = 150 * Math.sin(k);
            k += 0.2;
            particles.add(co = new Circle(this, x, 350 + y, radius));
            capsules.add(new Capsule(this, cp, co));
            co.setPinned(true);
            cp.setPinned(true);
            cp = co;
            radius = 30;
        }
        particles.add(cp = new Circle(this, 3500, 300 + 0, radius));
        for (int x = 4000; x < 5000; x+=80) {
            double y = 100 * Math.tanh(k)+100;
            k += 0.2;
            particles.add(co = new Circle(this, x, 120 + y, radius));
            capsules.add(new Capsule(this, cp, co));
            co.setPinned(true);
            cp.setPinned(true);
            cp = co;
            radius = 30;
        }
    
        
        particles.add(cp = new Circle(this, 5000, 300 + 0, radius));
        particles.add(co = new Circle(this, 5600, 120 , radius));
        capsules.add(new Capsule(this, cp, co));
        co.setPinned(true);
        cp.setPinned(true);
        cp = co;
        radius = 30;

        particles.add(cp = new Circle(this, 5600, 120 + 0, radius));
        particles.add(co = new Circle(this, 6000, 280 , radius));
        capsules.add(new Capsule(this, cp, co));
        co.setPinned(true);
        cp.setPinned(true);
        cp = co;
        radius = 30;
        
        particles.add(cp = new Circle(this, 6000, 280 + 0, radius));
        particles.add(co = new Circle(this, 6500, 130 , radius));
        capsules.add(new Capsule(this, cp, co));
        co.setPinned(true);
        cp.setPinned(true);
        cp = co;
        radius = 30;
        
        particles.add(cp = new Circle(this, 6500, 120 + 0, radius));
        particles.add(co = new Circle(this, 7000, 320 , radius));
        capsules.add(new Capsule(this, cp, co));
        co.setPinned(true);
        cp.setPinned(true);
        cp = co;
        radius = 30;
        
        for (int x = 7000; x < 9000; x+=80) {
            double y = 100 * Math.cos(k)+100;
            k += 0.2;
            particles.add(co = new Circle(this, x, 120 + y, radius));
            capsules.add(new Capsule(this, cp, co));
            co.setPinned(true);
            cp.setPinned(true);
            cp = co;
            radius = 30;
        }
        
        
        //particule de finish
        cp.setRadius(80);
        particles.add(cp);
        Capsule finishLine=new Capsule(this, cp, cp);
        finishLine.setColor(Color.GREEN);
        capsules.add(finishLine);
    }

    double breaking=2;
    
    public void update() {
    	msg="";
    	//System.out.println(pk.getPosition().getX()+","+pk.getPosition().getY());
    	//12700 depend de l ap
    	if(pk.getPosition().getX()>=xFin ){
    		System.out.println("You win");
    		state=STATE.WIN;
    		Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
    		activeWindow.dispose();
    		return;
    	}
    	if(car.getEnergie() <=0 || //energie epuise
    			pk.getPosition().getY() >1000 || (fourchette && temps == 0) ) {//abscisse très basse (chute)
    		System.out.println("Game over");
    		state=STATE.DEAD;
    		//fenetre courante
    		Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
    		activeWindow.dispose();
    		return;
    	}
    	
    	
    	
    	else {
    	boolean totalBreaking=false;
    	
        if (Keyboard.keyDown[KeyEvent.VK_LEFT]) {
            //	System.out.println("ralentir voiture + stocker énergie");
        	//ralentir partiellement avec un coef inversement proportionnel à "breaking" qu'on multiplie chaque fois par 2
            if( breaking < car.getEnergie()){
                pk.getPosition().setX(pk.getPosition().getX() - 1/breaking);
                car.energieRecuperee();
            }
            else {
                totalBreaking =true;
                pk.setPinned(true);
            }
            breaking+=car.ralentir();

            System.out.println("breaking :"+breaking );
        }
        else if (Keyboard.keyDown[KeyEvent.VK_RIGHT]) {
        	breaking=2;	
        	pk.setPinned(false);
            pk.getPosition().setX(pk.getPosition().getX() + 1);
            if(consommation)
            	car.updateEnergie(-0.1);
        }
        if(Keyboard.keyB()) {
        	if(UserSingeleton.getUser().hasRX()) {
        		car.updateEnergie(+100);
        		UserSingeleton.getUser().setRX(false);
        		msg="Range extender utilise !";
        	}
        	else 
        		msg="Pas de Range extender !";
        }
        if(Keyboard.keyT() && UserSingeleton.getUser().hasTimer()) {
        		consommation=false;//pas de consommation 
        		new Timer().schedule(new TimerTask() {
        			@Override
        			public void run() {
        				consommation=true;//fin effet timer acheté
        			}
        		}, 5*1000);
        		
        }
        	
        

        if (Keyboard.allReleased()) {
        	breaking=2;     
        		pk.setPinned(false);
        		//System.out.println("Roue libre "); 
        }
        //System.out.println("Energie "+energie);
        for (Particle particle : particles) {
            particle.update();
        }
        for (int i = 0; i < 7; i++) {
            for (Stick stick : sticks) {
                stick.update();
            }
        }
        if (!totalBreaking) {
        body.update();
        head.update();
        }
        for (Capsule capsule : capsules) {
            capsule.update();
        }
        
        for (Puff puff : puffs) {
            puff.update();
        }
        
        camera.update();
    	}
    }
    public Car getCar() {
    	return car;
    }
    public void drawDebug(Graphics2D g) {


        for (Capsule capsule : capsules) {
            capsule.drawDebug(g);
        }
    }

     public void draw(Graphics2D g) {	
    	 //g.drawImage(new BufferedImage, arg1, arg2, arg3);
 
    	 g.drawString(("Energie "+car.getEnergie()).substring(0, 11), 860,  60);
    	 g.setColor(Color.GRAY);
    	 g.fillRect(790, 20, 200, 100);
    	 g.setColor(Color.WHITE);
    	 g.setFont(new Font("Verdana",1,14));
    	 g.drawString(("Energie "+car.getEnergie()).substring(0, 11), 800,  40);
    	 g.drawString("Range extender : "+ (UserSingeleton.getUser().hasRX()? "Existe" : "Aucun" ), 800, 60);
    	 g.drawString("Mode sans conso: "+ (!consommation ? "On" : "Off" ), 800, 80);
    	 if(fourchette) {
    		 if(temps <5) 
    			 g.setColor(Color.RED);
    		 g.drawString("Temps restant : "+ temps, 800, 100);
    	 }
    	 
    	 g.translate(-camera.getPosition().getX() + 400, -camera.getPosition().getY() + 300);
        body.draw(g);
        head.draw(g);
        
        
        for (Particle particle : particles) {
            particle.draw(g);
        }
        for (Puff puff : puffs) {
            puff.draw(g);
            if (puff.isDestroyed()) {
                puffsRemove.add(puff);
            }
        }
        if (!puffsRemove.isEmpty()) {
            puffs.removeAll(puffsRemove);
            puffsRemove.clear();
        }
    }
    
    private long lastSpawnPuffTime;
    
    public void spawnPuff(int x, int y, Position velocity) {
        if (System.currentTimeMillis() - lastSpawnPuffTime < 50) {
            return;
        }
        puffs.add(new Puff(this, x, y, velocity));
        lastSpawnPuffTime = System.currentTimeMillis();
    }
    public void destroy() {
    	car.setInGame(false);
    	state=STATE.DEAD;
    	System.out.println(car.getEnergie());
    	this.capsules.clear();
    	this.particles.clear();
    	this.sticks.clear();
    	this.puffs.clear();
    	this.puffsRemove.clear();
    	
    }
    
}