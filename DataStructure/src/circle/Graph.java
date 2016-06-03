package circle;

import java.util.ArrayList;

public class Graph {
	
	public static ArrayList<Integer> vertices = new ArrayList<Integer>();

	public static String findCycle(int matrix[][], int firstVertex, int tempVertex) {
		if(vertices.contains(tempVertex )) { // 顶点是否被走过
			return null;
		} else {
			vertices.add(tempVertex);
		}
		String cycle = " " + tempVertex;
		if(firstVertex == tempVertex) {
			return cycle;
		}
		for(int i = 0; i < matrix[tempVertex].length; i++ ) {
			if(matrix[tempVertex][i] == 1) {
				tempVertex = i;
				String tempCycle= findCycle(matrix, firstVertex, tempVertex);
				return tempCycle == null ? null : cycle + tempCycle;
			}
			
		}
		return null;	// 没有回路
	}
	
	public static void main(String[] args) {
		System.out.println("有向图中的环路为：");
		int matrix[][] = {
		                  {0, 1, 1, 0, 1, 1, 0, 0, 0}, 
		                  {1, 1, 1, 0, 1, 1, 0, 0, 0}, 
		                  {1, 0, 0, 0, 1, 1, 0, 0, 0},
		                  {1, 0, 1, 0, 1, 1, 0, 0, 0}, 
		                  {1, 0, 1, 0, 0, 1, 0, 0, 0}, 
		                  {1, 0, 1, 0, 1, 0, 0, 0, 0},
		                  {1, 0, 1, 0, 1, 1, 0, 0, 0},
		                  {1, 0, 1, 0, 1, 1, 0, 0, 0}, 
		                  {1, 0, 1, 0, 1, 1, 0, 0, 0},
		                  
		};
		for(int i = 0; i < matrix.length; i++) {
			int firstVertex = i;
			for(int j = 0; j < matrix[i].length; j++) {
				vertices.clear();
				if(matrix[i][j] == 1) {
					int tempVertex = j;
					String cycle = findCycle(matrix, firstVertex, tempVertex);
					if(cycle != null) {
						System.out.println(firstVertex + cycle);
					}
				}
			}
		}
	}
	
}
