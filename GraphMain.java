import java.io.*;
import java.util.*;
public class GraphMain{
	public static void main (String args[]) { 
	String fileName = args[0];
		try{
			FileInputStream file = new FileInputStream(fileName);
			Scanner in = new Scanner(file);
			System.out.println("reading in file....");
			int size = in.nextInt();
			Graph graph = new Graph(size);
			

		}catch (FileNotFoundException e) {
			System.out.println("File" + fileName + " could not be opened");
			System.exit(1);



	}



	}
}
