package view;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Particle class.
 * 
 * 
 */
public class Particle {

    protected PisteView pisteView;
    protected boolean pinned;
    protected final Position position = new Position();
    protected final Position previousPosition = new Position();
    protected final Position velocity = new Position();
    protected double restitution = 0.95;
    
    protected final Position vec2Tmp = new Position();
    
    public Particle(PisteView pisteView, double x, double y) {
        this.pisteView = pisteView;
        this.position.set(x, y);
        this.previousPosition.set(x, y);
    }

    public PisteView getWorld() {
        return pisteView;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public Position getPosition() {
        return position;
    }

    public void update() {
        if (pinned) {
            return;
        }
        
        velocity.set(position);
        velocity.sub(previousPosition);
        velocity.add(pisteView.GRAVITY);
        
        vec2Tmp.set(Mouse.x, Mouse.y);
        vec2Tmp.sub(position);
        if (vec2Tmp.getLength() < 10) {
            vec2Tmp.set(20, 0);
            velocity.add(vec2Tmp);
        }
        
        previousPosition.set(position);
        position.add(velocity);
        
        updateConstraints();
    }
    
    private void updateConstraints() {

    }
    
    public void drawDebug(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval((int) (position.getX() - 2), (int) (position.getY() - 2), 4, 4);
    }

    public void draw(Graphics2D g) {
    }
    
}
