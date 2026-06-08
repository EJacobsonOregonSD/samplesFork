public class Body{
    public String name;
    public double xPos,yPos;
    public double xVel,yVel;
    public boolean isKeplerOrbit;
    //stuff also stored for type of orbit, not quite sure if these variables would be sufficient or if different ones would be easier

    public Body(String name,double x,double y,double xv,double yv){
        xPos=x; yPos=y; xVel=xv; yVel=yv; this.name=name;
    }
    public Body clone(){
        return new Body(name,xPos,yPos,xVel,yVel,mass,radius);
    }
}