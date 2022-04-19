import java.io.*;
import java.util.*;
public class GraphMain{
	public static void main (String args[]) { 
	String fileName = args[0];
		try{
			FileReader file = new FileReader(fileName);
			Scanner scn1 = new Scanner(file);
			int size = scn1.nextInt();
			scn1.nextLine();
			Graph graph = new Graph(size);	
			int i = 0;
			while(scn1.hasNextLine()) {
			String[] split1 = scn1.nextLine().split(" ");
			graph.setValue(i,split1[0]);
			i++;
			}
			
			scn1.close();			
			FileReader file2 = new FileReader(fileName);	
	              	Scanner scn2 = new Scanner(file2);
			int ignore = scn2.nextInt();
			scn2.nextLine();
			int edges = 0;
			for(int j = 0; j< ignore; j++) {
				String[] split = scn2.nextLine().split(" ");
				for(int z = 0; z < split.length; z++)
					{
						if(z == 0){
						
						
						}else if(z == 1) {
				  		 edges = Integer.parseInt(split[z]);
						  
						}else{
						  String nodes = split[z];
						  graph.insertEdge(split[0],nodes);
						}

											
						
					}
			}
			scn2.close();
		}catch (FileNotFoundException e) {
			System.out.println("File" + fileName + " could not be opened");
			System.exit(1);
		}



	}
/*	
	public static void topsortDFS(Graph g) {
	int v;
	for (v=0; v<g.getSize(); v++) {
		g.setValue(v, null);
	}
	for (v=0; v<g.getSize(); v++) {
		if(g.getValue(v) != VISTED) {
			tophelp(g,v);
	 	}
	}
	}

/*	
	public static void tophelp(Graph g, int v) {
		g.setValue(v, VISITED);
		int[] nlist = g.neightbors(v);
		for(int i = 0; i < nList.length; i++) {
			if(g.getValues(nList[i]) != VISITED) {
				tophelp(g, nList[i]);
			}
		}
		System.out.println(v);
	}
*/
	}
