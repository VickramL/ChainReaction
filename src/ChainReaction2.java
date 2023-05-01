import java.util.Scanner;

public class ChainReaction2 {
	
	char[][] elementGrid = new char[5][5]; 
	int[][] massGrid = new int[5][5];

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Input coordinates and element space separated and pairs commo seperated:");
		String input = in.nextLine();
		
//		String input = "B1 Zo,C2 Ho,C3 Zo,A3 Ho";
		ChainReaction2 chainReaction = new ChainReaction2();
		chainReaction.fillGrid(input);

	}
	
	public void fillGrid(String input) {
		
		boolean isFailure = false;
		
		int length = input.length();
		
		int i = 0;
		while (i<length) {
			
			int col = input.charAt(i++) - 'A';
			int row = input.charAt(i++) - '1';
			i++;
			char element = input.charAt(i);
			i += 3;
			
			if (elementGrid[row][col] == 0) { // if empty
				elementGrid[row][col] = element;
				massGrid[row][col]++;
			} else if (elementGrid[row][col] == element) { // if same element
			
				if (massGrid[row][col] + 1 <= getCriticalMass(row, col)) {
					massGrid[row][col]++;
				} else {
					System.out.println("Failure: " + (char)(col+'A') + (row+1) + " reaches critical mass");
					isFailure = true;
				}
				
			} else { // if different element
				
			}
			
		}
		
		if (!isFailure) {
			printGrid();
		}
		
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
		else if (r == 0 || r == 4 || c == 0 || c == 4) {
			return 3;
		}
		
		return 4;
		
	}
	

}
