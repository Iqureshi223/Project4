import java.io.*;
import java.util.*;
public class GraphMain{
	public static void main (String args[]) { 
	String fileName = args[0];
		try{
			FileReader file = new FileReader(fileName); 
			Scanner scn1 = new Scanner(file);
			int size = scn1.nextInt(); //reads in the value that represents how big the graph will be
			scn1.nextLine(); //consumes the line for the code to function properly
			Graph graph = new Graph(size);	
			int i = 0;
			while(scn1.hasNextLine()) { //checks to see if there is another line in the file
			String[] split1 = scn1.nextLine().split(" "); //creates a string array that stores in information of the line
			graph.setValue(i,split1[0]); //creates the nodes that we got from the file
			i++;
			}
			
			scn1.close();			
			FileReader file2 = new FileReader(fileName);
	              	Scanner scn2 = new Scanner(file2); //a new file reader and scanner so we can read the file from the top again and add edges
			int ignore = scn2.nextInt(); //ignore is the same as size but is used for the for statement instead of being used to intialize our object
			scn2.nextLine();// same process as before
			int edges = 0;
			for(int j = 0; j< ignore; j++) {
				String[] split = scn2.nextLine().split(" ");//same process as before
				for(int z = 0; z < split.length; z++)//for statement lets us read each element stored in the array.
					{
						if(z == 0){//checks if z is equal 0. we don't want to do anything with the element in index 0 for this part.
						
						
						}else if(z == 1) {
				  		 edges = Integer.parseInt(split[z]);//the element at index lets us know how many edges this node will have.
						  
						}else{
						  String nodes = split[z];
						  graph.insertEdge(split[0],nodes);//function adds an edge between the current array's element at 0 with the other nodes 										   assigned
						}

											
						
					}
			}
			scn2.close();
			topsort(graph);//calls on topsort method
		}catch (FileNotFoundException e) {
			System.out.println("File" + fileName + " could not be opened");
			System.exit(1);
		}



	}
//method for topological
public static void topsort(Graph g){
	ArrayList<String> activeSet = new ArrayList();
	ArrayList<String> ordering = new ArrayList();
	for(int i = 0; i < g.getSize(); i++) {//for loop that checks if theres any node that has no edge at all
		int z = g.getSize();//variable to compare another node with i to see if theres an edge
		z = z - 1;
		Boolean noEdge = true;
		while(noEdge == true) {
			
			if(g.isEdge(i,z) == true) {// if an edge is found return no edge as false exiting the loop
				noEdge = false;
			}
			else{
				z--;
			}
		if(z == -1) {//stops the while loop if it falls below 0
			noEdge = false;
			activeSet.add(g.getValue(i).toString());//adds to arraylist
		}
		
		}		
	}
	for(int j = 0; j < g.getSize(); j++) {//for loop to remove edges and add the element to the list
		int x = g.getSize();
		    x = x -1;
		    Boolean nEdge = true;
		while(nEdge == true) {
			if(g.isEdge(j,x) == true) {//if there is an edge...remove it
				g.removeEdge(j,x);
			}
			else{
				x--;
			}
		if(x == -1) {
			nEdge = false; //stops the for loop, checks if the element is all ready in the arraylist if not adds it to the list
			if(!activeSet.contains(g.getValue(j).toString())){
			activeSet.add(g.getValue(j).toString());
			}
			
		}

		}
	}
	for(int y = 0; y < activeSet.size(); y++) {
		ordering.add(activeSet.get(y));//add all activeSet elements to ordering arraylist
	}
	
	for(int e = 0; e < ordering.size(); e++) {
	
		int m = g.getSize();
		   m = m -1;
		Boolean existEdge = false;
		while(existEdge == false) {
				
				if(g.isEdge(e,m) == true){
					existEdge = true;
					System.out.println("You can't complete: " + g.getValue(e).toString()); //if there is any edge found let the user no its not a															 complete graph
				}
				else{
					m--;
				}
			if(m == -1) {
					existEdge = true;
				    }
		}
		System.out.println(g.getValue(e).toString());//prints out values that don't have an edge
	}
}
}
