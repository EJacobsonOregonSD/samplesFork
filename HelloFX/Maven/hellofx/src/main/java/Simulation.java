public class Simulation{
    public Body[] bodies;
    public double timeStep;
    public final double g=6.6743e-11; //gravitational constant

    public Simulation(Body[] bodies, double timeStep){
        this.bodies=bodies;
        this.timeStep=timeStep;
    }

    public void simulateStep(){
        //TODO
    }

}