package view;

public class Camera {
    private Body body;
    private Position position = new Position();
    private Position vec2Tmp = new Position();

    public Camera(Body body) {
        this.body = body;
    }

    public Position getPosition() {
        return position;
    }

    public void update() {
        vec2Tmp.set(body.getPosition());
        vec2Tmp.sub(position);
        vec2Tmp.scale(0.2);
        position.add(vec2Tmp);
    }
    
}
