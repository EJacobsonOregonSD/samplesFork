public class Planet extends Body{

    public Planet orbiting;
    public double SOIRadius;
    public double SMA; //semi major axis
    public double mu; //This is the gravitational parameter (G*M). It can replace mass entirely.
    public Planet(String name,double x,double y,double xv,double yv,double mu,double radius,double SOIRadius,double SMA,Planet orbiting){
        super(name,x,y,xv,yv,radius);
        this.mu = mu;
        this.SMA = SMA;
        this.orbiting = orbiting;
        this.SOIRadius = a*Math.pow(mu/orbiting.mu, 0.4);
    }
}