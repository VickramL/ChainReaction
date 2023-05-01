import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ChainReaction4 {
	
	char[][] elementGrid = new char[5][5]; 
	int[][] massGrid = new int[5][5];

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		ChainReaction4 chainReaction = new ChainReaction4();
		
		while (true) {
			System.out.println("Input coordinates and element space separated:");
			String input = in.nextLine();
			
			int col = input.charAt(0) - 'A';
			int row = input.charAt(1) - '1';
			
			char element = input.charAt(3);;
			
			chainReaction.fillGrid(row, col, element, 0);
			
		}
		
	}
	
	public void fillGrid(int row, int col, char element, int type) {
		
		System.out.println(row + " " + col);
		
		if (row < 0 || row >= 5 || col < 0 || col >= 5) {
			return;
		}
		
		if (elementGrid[row][col] == 0) { // if empty
			elementGrid[row][col] = element;
			massGrid[row][col]++;
		} else if (elementGrid[row][col] == element) { // if same element
		
			if (massGrid[row][col] + 1 < getCriticalMass(row, col)) {
				massGrid[row][col]++;
			} else {
				
				Deque<int[]> q = new ArrayDeque<>();
				
				q.add(new int[] {row,col});
				
				while (!q.isEmpty()) {
					
					int[] curr = q.poll();
					
					
					
					
				}
								
			}
			
		} 
		
		else if (type > 0) {
			elementGrid[row][col] = element;
			fillGrid(row, col, element, type);
		}

		printGrid();
		
		
	}
	
	public void printGrid() {
		
		System.out.println("------------------------------------------------|");
		System.out.println("  |\tA\tB\tC\tD\tE\t|");
		System.out.println("------------------------------------------------|");
		for (int i=0; i<5; i++) {
			System.out.print((i+1) + " |\t");
			for (int j=0; j<5; j++) {
				
				if (massGrid[i][j] > 0) {
					
					System.out.print(elementGrid[i][j] + "o");
					System.out.print(massGrid[i][j] + "\t");
					
				} else {
					
					System.out.print("\t");
					
				}
				
			}
			System.out.println("|");
			System.out.println("------------------------------------------------|");
		}
		
	}
	
	private int getCriticalMass(int r, int c) {
		
		// is corner?
		if ((r == 0 && (c == 0 || c == 4)) ||
				(r == 4 && (c == 0) || c == 4)) {
			return 2;
		}
		
		// isEdge?
		else if (r == 0 | c == 0 | r == 4 | c == 4) {
			return 3;
		}
		
		return 4;
		
	}
	

}
