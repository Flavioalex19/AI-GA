package code;

import java.util.ArrayList;
import java.util.Collections;

public class Path {
	
    private ArrayList path = new ArrayList<Obstacle>();
    
    private double fitness = 0;
    private int distance = 0;
    
    
    public Path(){
        for (int i = 0; i < PathManager.numberOfObstacles(); i++) {
            path.add(null);
        }
    }
    
    public Path(ArrayList path){
        this.path = path;
    }

    // Creates a random individual
    public void generateIndividual() {
    
        for (int obstIndex = 0; obstIndex < PathManager.numberOfObstacles(); obstIndex++) {
          setObstacle(obstIndex, PathManager.getObstacle(obstIndex));
        }
       
        Collections.shuffle(path);
    }

    
    public Obstacle getObstacle(int pathPosition) {
        return (Obstacle)path.get(pathPosition);
    }

    
    public void setObstacle(int pathPosition, Obstacle obst) {
        path.set(pathPosition, obst);
        fitness = 0;
        distance = 0;
    }
    
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }
    
    
    public int getDistance(){
        if (distance == 0) {
            int pathDistance = 0;
            
            for (int obstacleIndex=0; obstacleIndex < pathSize(); obstacleIndex++) {
                Obstacle fromObstacle = getObstacle(obstacleIndex);
                Obstacle destinationCity;
                if(obstacleIndex+1 < pathSize()){
                    destinationCity = getObstacle(obstacleIndex+1);
                }
                else{
                    destinationCity = getObstacle(0);
                }
                pathDistance += fromObstacle.distanceTo(destinationCity);
            }
            distance = pathDistance;
        }
        return distance;
    }

    
    public int pathSize() {
        return path.size();
    }
    
    
    public boolean containsObstacle(Obstacle obst){
        return path.contains(obst);
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < pathSize(); i++) {
            geneString += getObstacle(i)+"|";
        }
        return geneString;
    }
	
	

}
