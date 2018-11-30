package code;

import java.util.ArrayList;



public class PathManager {
	 
    private static ArrayList destination = new ArrayList<Obstacle>();

    
    public static void addObstacle(Obstacle obstacle) {
        destination.add(obstacle);
    }
    
    
    public static Obstacle getObstacle(int index){
        return (Obstacle)destination.get(index);
    }
    
    
    public static int numberOfObstacles(){
        return destination.size();
    }

    
    
}
