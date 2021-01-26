import java.util.ArrayList;


public class Main {
	
	
	
	public static void vacuumBFS(int initialState){
			
		// Nodes to be explored
		ArrayList<Integer> frontier = new ArrayList<Integer>();
		
		// Nodes that have been explored
		ArrayList<Integer> explored = new ArrayList<Integer>();
		
		// Possible children when certain state selected
		ArrayList<Integer> possibleChildren = new ArrayList<Integer>();
		
		// Counter for iterations
		int counter = 0;
		
		// Initial state assigned
		int node = initialState;
		
		// Initial node added to the frontier
		frontier.add(node);
		
		// Prescribing our goal states
		int goalState1 = 7;
		int goalState2 = 8;
		
		while(true) {
			
			// Break out of loop and return no solution if frontier is empty
			if (frontier.isEmpty()) {
				System.out.println("No Solution Available");
				break;
			}
			
			// Remove node from frontier
			int nodeCheck = frontier.remove(0);
			
			System.out.println("Node: " + nodeCheck);
			
			// Checks inside the frontier to see if our goal solution is there
			if (nodeCheck == goalState1 || nodeCheck == goalState2) {
				System.out.println("\nGoal State " + nodeCheck + " Reached!\nIterations: " + counter);
				break;
			}
		
			// Counts how many times we've looped
			counter ++;
			
			// Possible states and their respective children
			if(nodeCheck == 1) {
				possibleChildren.add(1);
				possibleChildren.add(2);
				possibleChildren.add(3);
			}
			
			else if(nodeCheck == 2) {
				possibleChildren.add(1);
				possibleChildren.add(2);
				possibleChildren.add(6);	
			}
			
			else if(nodeCheck == 3) {
				possibleChildren.add(3);
				possibleChildren.add(4);
				possibleChildren.add(3);	
			}
			
			else if(nodeCheck == 4) {
				possibleChildren.add(3);
				possibleChildren.add(4);
				possibleChildren.add(8);	
			}
			
			else if(nodeCheck == 5) {
				possibleChildren.add(5);
				possibleChildren.add(6);
				possibleChildren.add(7);	
			}
			
			else if(nodeCheck == 6) {
				possibleChildren.add(5);
				possibleChildren.add(6);
				possibleChildren.add(6);	
			}
			
			else if(nodeCheck == 7) {
				possibleChildren.add(7);
				possibleChildren.add(8);
				possibleChildren.add(7);	
			}
			else if(nodeCheck == 8) {
				possibleChildren.add(7);
				possibleChildren.add(8);
				possibleChildren.add(8);	
			}
			
			// Add to checked nodes
			explored.add(nodeCheck);
			
			// If there are any children in our explored set, they are 
			// removed as possible children options
			possibleChildren.removeAll(explored);
			
			
			// If there are any children already in the frontier,
			// they are removed as possible children options
			possibleChildren.removeAll(frontier);
			
			
			// Any outstanding children not already in frontier or 
			// explored are added to the frontier to be explored
			frontier.addAll(possibleChildren);
			
			System.out.println("Frontier: " + frontier);
			
			
		}
	}
	public static void main(String[] args) {
		vacuumBFS(1);
	}
}
