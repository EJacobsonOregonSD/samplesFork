public class Rocket extends Body{
    public double thrust;
    public double dv;
    public Rocket(String name,double x,double y,double xv,double yv,double mass,double radius){
        super(name,x,y,xv,yv,mass,radius);
    }
}