package server;


import mayflower.Actor;
import mayflower.Mayflower;

import java.util.List;

public class Asteroid extends SpaceActor
{
    private double velocity;


    public Asteroid(int r, double velocity)
    {
        //super("img/largeAsteroid.png", r);
        setImage("img/largeAsteroid.png");
        setRotation(r);
        this.velocity = velocity;
    }

    public Asteroid()
    {

        setImage("img/largeAsteroid.png");

        setRotation(Mayflower.getRandomNumber(360)-180);

        this.velocity = Mayflower.getRandomNumber(9)+1;

    }

    @Override
    public void act() {

    }

    public void tick()
    {
        //super.tick();
        //super.warp();

        this.move(velocity);
        //System.out.println("getIntersectingObjects(Laser.class) = " + getIntersectingObjects(Laser.class));
        //if(isTouching(Laser.class))getWorld().removeObject(this);
        //System.out.println("AsteroidtoString() = " + toString());


    }



    public String toString()
    {
        return "asteroid,"+getX()+","+getY()+","+getRotation()+","+velocity;
    }
}
