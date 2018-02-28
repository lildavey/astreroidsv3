package server;


public class Laser extends SpaceActor {
    public Laser(int x, int y, int rotation) {
        setLocation(x,y);
        setImage("img/laser.png");
        setRotation(rotation);
    }
    public void tick()
    {
        move(5);
        /*for (SpaceActor actor:getIntersectingObjects(Asteroid.class)) {
            getWorld().removeObject(actor);
            //System.out.println("kill: "+actor);
        }*/
    }

    public String toString() {
        return "laser,"+getX()+","+getY()+","+getRotation()+","+getVelocity();
    }

}
