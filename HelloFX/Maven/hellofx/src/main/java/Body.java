public abstract class Body{
    public String name;
    public double xPos,yPos;
    public double xVel,yVel;
    public double mass;
    public double radius;
    public boolean isKeplerOrbit;
    //stuff also stored for type of orbit, not quite sure if these variables would be sufficient or if different ones would be easier

    public Body(String name,double x,double y,double xv,double yv,double mass,double radius){
        xPos=x; yPos=y; xVel=xv; yVel=yv; this.mass=mass; this.radius=radius; this.name=name;
    }
}