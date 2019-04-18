package view;

import java.awt.Color;
import java.awt.Graphics2D;


public class Circle extends Particle {

    private Position position = new Position();
    private double radius = 20;
    private final Position vec2Tmp = new Position();

    public Circle(PisteView pisteView, double x, double y, double radius) {
        super(pisteView, x, y);
        this.radius = radius;
    }
    public void setRadius(double r) {
    	radius=r;
    }
    public double getRadius() {
        return radius;
    }
    
    public boolean collides(Circle other) {
        vec2Tmp.set(other.getPosition());
        vec2Tmp.sub(position);
        double length = vec2Tmp.getLength();
        return length <= radius + other.getRadius();
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.drawOval((int) (position.getX() - radius), (int) (position.getY() - radius), (int) (2 * radius), (int) (2 * radius));
    }
    
}
