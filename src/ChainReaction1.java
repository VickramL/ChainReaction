import java.util.Scanner;

public class ChainReaction1 {
	
	char[][] elementGrid = new char[5][5]; 
	int[][] massGrid = new int[5][5];

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Input coordinates and element space separated and pairs commo seperated:");
		String input = in.nextLine();
		
//		String input = "B1 Zo,C2 Ho,C3 Zo,A3 Ho";
		ChainReaction1 chainReaction = new ChainReaction1();
		chainReaction.fillGrid(input);
		chainReaction.printGrid();

	}
	
	public void fillGrid(String input) {
		
		int length = input.length();
		
		int i = 0;
		while (i<length) {
			
			int col = input.charAt(i++) - 'A';
			int row = input.charAt(i++) - '1';
			i++;
			char element = input.charAt(i);
			i += 3;
			
			elementGrid[row][col] = element;
			massGrid[row][col]++;
			
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
	

}
