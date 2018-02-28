package client;

import mayflower.Actor;

public class Laser extends Actor {
    public Laser(int x, int y, int rotation) {
        setLocation(x,y);
        setImage("img/laser.png");
        setRotation(rotation);
    }
    public void tick()
    {
        move(5);
    }

    @Override
    public void act() {

    }
}
