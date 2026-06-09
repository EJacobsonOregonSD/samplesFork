public class Simulation{
    public Body[] bodies;
    public double timeStep;
    public final double g=6.6743e-11; //gravitational constant

    public Simulation(Body[] bodies, double timeStep){
        this.bodies=bodies;
        this.timeStep=timeStep;
    }

    public Simulation(double timeStep){//starts the default simulation
        bodies=new Body[]{
            new Body("Sun",0,0,0,0,1.988475e30,675700000,null),
            new Planet("Earth",149598023e4,0,0,29780,5.972e24,6371000,null)
        };
        this.timeStep=timeStep;
    }

    public Body[][] recordSteps(int steps){
        Body[][] record=new Body[steps][];
        for(int i=0;i<steps;i++){
            record[i]=new Body[bodies.length];
            for(int idx=0;idx<record[i].length;idx++){
                record[i][idx]=bodies[idx].clone();
            }
            simulateStep();
        }
        return record;
    }

    public void simulateStep(){
        //This doesnt do the orbit stuff yet
        for (int i = 0; i < bodies.length-1; i++) {
            for (int j = i+1; j < bodies.length; j++) {
                System.out.println(i+","+j);
                //applyGravity(bodies[i],bodies[j]);
            }
        }
        for(Body body:bodies){
            body.xPos+=body.xVel*timeStep;
            body.yPos+=body.yVel*timeStep;
        }
    }
    public void applyGravity(Body b1,Body b2){
        //TODO fix this- i dont understand gravity well and this is just a placeholder for the iteration
        double xDist=b1.xPos-b2.xPos;
        double yDist=b1.yPos-b2.yPos;
        double distanceSquared=xDist*xDist+yDist*yDist;
        double distance=Math.sqrt(distanceSquared);
        double acceleration=timeStep*g*b1.mass*b2.mass/distanceSquared;
        b1.xVel-=acceleration*xDist/distance;
        b1.yVel-=acceleration*yDist/distance;
        b2.xVel+=acceleration*xDist/distance;
        b2.yVel+=acceleration*yDist/distance;
    }

}