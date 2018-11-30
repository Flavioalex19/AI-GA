package code;

public class Obstacle {
	int x;
    int y;
    
    // Constructs a randomly placed city
    public Obstacle(){
    	//aumentar o range
        this.x = (int)(Math.random()*100);
        this.y = (int)(Math.random()*100);
    }
    
    //tornar random
    // Constructs a city at chosen x, y location
    public Obstacle(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    // Gets city's x coordinate
    public int getX(){
        return this.x;
    }
    
    // Gets city's y coordinate
    public int getY(){
        return this.y;
    }
    
    
    // Gets the distance to given obstacle
    public double distanceTo(Obstacle obst){
        int xDistance = Math.abs(getX() - obst.getX());
        int yDistance = Math.abs(getY() - obst.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString(){
        return getX()+", "+getY();
    }

}
