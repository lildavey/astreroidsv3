package server;

import mayflower.Actor;

public class Ship extends SpaceActor{

    private server.spaceshipActor pilot;
    private server.GunnerActor gunner;

    public Ship() {



    }


    public server.spaceshipActor getPilot() {
        return pilot;
    }

    public void setPilot(SpaceActor pilot) {
        this.pilot = (server.spaceshipActor) pilot;
    }

    public server.GunnerActor getGunner() {
        return gunner;
    }

    public void setGunner(SpaceActor gunner) {
        this.gunner = (server.GunnerActor) gunner;
    }


    @Override
    public void act() {

    }


    /**
     *
     * @return ship,pilotRotation,velocity,gunnerRotation
     * TODO is velocity ever not zero?
     */
    @Override
    public String toString() {
        return "ship" + "," + getX() + "," + getY() + "," + pilot.getRotation()+ "," + pilot.getVelocity()+ "," + gunner.getRotation();
    }
    private class spaceshipActor extends SpaceActor {

        private int x,y,r,maxV, ID;
        private double velocity;
        private double acceleration, deceleration =0;

        public spaceshipActor(int xCoord, int yCoord, int rotation,double velocity,int ID)
        {
            super("img/spaceship.png", xCoord, yCoord, rotation);
            this.x = xCoord; this.y = yCoord; this.r = rotation;
            this.velocity = velocity;
            maxV = 10;
            this.ID = ID;

        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getID() {
            return ID;
        }

        /**
         * ie Acceleration
         */
        public void addVelocity()
        {
            if(velocity <maxV){
                velocity +=acceleration;

            }
        }

        /**
         * ie Deceleration
         */
        public void removeVelocity()
        {
            if(velocity >0){
                velocity -=deceleration;

            }
        }


        public void setAcceleration(double acceleration) {
            this.acceleration = acceleration;
        }

        public void setDeceleration(double deceleration) {
            this.deceleration = deceleration;
        }

        public void turnLeft()
        {
            turn(-2);
        }

        public void turnRight()
        {
            turn(2);
        }

        @Override
        public double getVelocity() {
            return velocity;
        }

        //@Override
        public void tick()
        {
            super.tick();

            this.move(velocity);
            addVelocity();
            removeVelocity();
        }

        public String toString()
        {
            return "spaceship,"+getX()+","+getY()+","+getRotation()+","+getVelocity();
        }
    }

    private class GunnerActor extends SpaceActor implements ActorID {
        private server.spaceshipActor ship;
        public GunnerActor(int x, int y, int r, double v, server.spaceshipActor ship) {
            super("img/laserCannon.png", x, y, r);
            this.ship = ship;

        }


        @Override
        public void tick() {
            super.tick();
            setLocation(ship.getX(),ship.getY());
        }

        public String toString() {
            return "gunner,"+getX()+","+getY()+","+getRotation()+","+getVelocity();
        }
    }


}
