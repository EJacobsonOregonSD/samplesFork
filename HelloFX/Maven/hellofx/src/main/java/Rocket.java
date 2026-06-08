public class Rocket extends Body{

    public double dv;
    public Rocket(String name,double x,double y,double xv,double yv,double mass,double radius,Orbit orbiting){
        super(name,x,y,xv,yv,mass,radius,orbiting);
    }


}