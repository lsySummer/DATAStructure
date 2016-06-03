package circle;

import java.util.ArrayList;

public class Main {
	static int pointNum = 9;
	static int j = 0;
	static int[][]e = {{0,0,0,0,0,0,0,0,1},
			 {0,0,0,1,1,0,0,0,0},
             {1,0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,1,0},
             {0,0,0,0,0,0,0,1,0},
             {0,1,0,0,0,0,0,0,0},
             {1,0,0,0,0,0,0,0,0},
             {0,0,1,0,0,0,1,0,0},
             {0,0,0,0,0,1,0,0,0}};
	static ArrayList<Integer> trace = new ArrayList<Integer>();
	static boolean hasCycle = false;
	
	public static void main(String[]args){
		findCycle(0);
		if(!hasCycle)
			System.out.println("No Cycle.");
	}
	
	public static void findCycle(int v){
		if((j = trace.indexOf(v))!=-1){
			hasCycle = true;
			System.out.print("Cycle");
			while(j<trace.size()){
				System.out.print(trace.get(j)+" ");
				j++;
			}
			System.out.println();
		}
		trace.add(v);
		
		for(int i = 0;i < pointNum;i++){
			if(e[v][i]==1)
				findCycle(i);
		}
		trace.remove(trace.size()-1);
	}
}
