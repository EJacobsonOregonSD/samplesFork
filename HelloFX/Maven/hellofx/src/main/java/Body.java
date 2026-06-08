public class Body{
    public String name;
    public double xPos,yPos;//m
    public double xVel,yVel;//m/s
    public double mass;//kg
    public double radius;
    public Orbit orbiting;//null if orbiting nothing
    
    //stuff also stored for type of orbit, not quite sure if these variables would be sufficient or if different ones would be easier

    public Body(String name,double x,double y,double xv,double yv,double mass,double radius,Orbit orbiting){
        xPos=x; yPos=y; xVel=xv; yVel=yv; this.mass=mass; this.radius=radius; this.name=name; this.orbiting=orbiting;
    }
    public Body clone(){
        return new Body(name,xPos,yPos,xVel,yVel,mass,radius,orbiting);
    }
}