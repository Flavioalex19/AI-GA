package code;

public class Population {

    Path[] paths;

    
    public Population(int populationSize, boolean initialise) {
        paths = new Path[populationSize];
        
        if (initialise) {
            for (int i = 0; i < populationSize(); i++) {
                Path newTour = new Path();
                newTour.generateIndividual();
                savePath(i, newTour);
            }
        }
    }
    
   
    public void savePath(int index, Path path) {
        paths[index] = path;
    }
    
    
    public Path getPath(int index) {
        return paths[index];
    }

    
    public Path getFittest() {
        Path fittest = paths[0];
        // Loop through individuals to find fittest
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getPath(i).getFitness()) {
                fittest = getPath(i);
            }
        }
        return fittest;
    }

    // Gets population size
    public int populationSize() {
        return paths.length;
    }
	
}
