package code;

public class GA_RUN {

	 public static void main(String[] args) {

		 
		 int xpos = (int) (Math.random() * 100);
		 int ypos = (int) (Math.random() * 100);
		 
		 for(int i = 0; i<52;i++) {
			 xpos = (int) (Math.random() * 100);
			 ypos = (int) (Math.random() * 100);
			 Obstacle ob = new Obstacle(xpos, ypos);
		     PathManager.addObstacle(ob);
		        
			 
			 
		 }
	
	        // Inicializacao 
	        Population populi = new Population(52, true);
	        System.out.println("Initial distance: " + populi.getFittest().getDistance());

	        
	        populi = GenAlg.evolvePopulation(populi);
	        for (int i = 0; i < 300; i++) {
	            populi = GenAlg.evolvePopulation(populi);
	            System.out.println(populi.getFittest().getDistance());
	        }

	        System.out.println("Finished");
	        System.out.println("Final distance: " + populi.getFittest().getDistance());
	        System.out.println("Solution:");
	        System.out.println(populi.getFittest());
	    }
}
