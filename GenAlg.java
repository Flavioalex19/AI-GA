package code;

public class GenAlg {
	 
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.populationSize(), false);

        
        int elitismOffset = 0;
        if (elitism) {
            newPopulation.savePath(0, pop.getFittest());
            elitismOffset = 1;
        }

        
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
         
            Path parent1 = tournamentSelection(pop);
            Path parent2 = tournamentSelection(pop);
            Path child = crossover(parent1, parent2);
            
            newPopulation.savePath(i, child);
        }

        
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getPath(i));
        }

        return newPopulation;
    }

    
    public static Path crossover(Path parent1, Path parent2) {
        
        Path child = new Path();

        
        int startPos = (int) (Math.random() * parent1.pathSize());
        int endPos = (int) (Math.random() * parent1.pathSize());

        
        for (int i = 0; i < child.pathSize(); i++) {
            
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setObstacle(i, parent1.getObstacle(i));
            } 
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setObstacle(i, parent1.getObstacle(i));
                }
            }
        }

        
        for (int i = 0; i < parent2.pathSize(); i++) {
        
            if (!child.containsObstacle(parent2.getObstacle(i))) {
                for (int ii = 0; ii < child.pathSize(); ii++) {
                    if (child.getObstacle(ii) == null) {
                        child.setObstacle(ii, parent2.getObstacle(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    
    private static void mutate(Path path) {
        
        for(int pathPos1=0; pathPos1 < path.pathSize(); pathPos1++){
            if(Math.random() < mutationRate){
                int pathPos2 = (int) (path.pathSize() * Math.random());

                Obstacle obs1 = path.getObstacle(pathPos1);
                Obstacle obs2 = path.getObstacle(pathPos2);

                
                path.setObstacle(pathPos2, obs1);
                path.setObstacle(pathPos1, obs2);
            }
        }
    }

    private static Path tournamentSelection(Population pop) {
        
        Population tournament = new Population(tournamentSize, false);
        
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.savePath(i, pop.getPath(randomId));
        }
        
        Path fittest = tournament.getFittest();
        return fittest;
    }

}
