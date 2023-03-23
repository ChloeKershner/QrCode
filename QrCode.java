// Chloe Kershner

import java.util.Random;
public class QrCode {
	private int[][] grid;
	public static void main(String[] args) {
		
		final int DEFAULT_DIMENSION = 30;
		final int DEFAULT_SEED = 160;
		int dimension;
		int seedNum;
		int[] arguments = new int[args.length];
		for (int i = 0; i < args.length; i++) {
		    arguments[i] = Integer.parseInt(args[i]);
		}
		if (args.length == 2) {
			dimension = arguments[0];
			seedNum = arguments[1];
		}
		else {
			dimension = DEFAULT_DIMENSION;
			seedNum = DEFAULT_SEED;
		}
		
		
		
		QrCode obj = new QrCode();
		int[] newPattern = obj.createPattern(dimension, seedNum);
		obj.createPattern(dimension, seedNum);
		obj.setGrid(dimension, newPattern);
		obj.setFinder(0,0);
		obj.setFinder(dimension - 15, 0);
		obj.setFinder(0, dimension - 15);
		obj.print();
		
		//create instance of QRCode and run its methods

	}
	
	public int[] createPattern(int dim, int seed) {
		//return 1d array of random 1 and 0 the size of dim squared
		Random rand = new Random(seed);
		int[] array = new int[dim * dim];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(2);
		}
		return array;
	}
	
	public void setGrid(int dim, int[] pattern) {
		//2d array size of dim by dim
		// fill in values from pattern passed in
		grid = new int[dim][dim];
		int patternIndex = 0;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				grid[i][j] = pattern[patternIndex];
				patternIndex++;
			}
		}
	}
	public int[][] getGrid(){
		// return representation of the grid member
		return grid;
		
	}
	
	public void setFinder(int xPos, int yPos) {
		//overwrite existing grid with the finder
		//3 for loops, working in towards the middle
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				grid[i + xPos][j + yPos] = 1;
			}
		}
		
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				grid[i + (xPos + 2)][j + (yPos + 2)] = 0;
			}
		}
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				grid[i + (xPos + 4)][j + (yPos + 4)] = 2;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i + (xPos + 6)][j + (yPos + 6)] = 3;
			}
		}
	}
	
	
	//overloaded constructors for printing
	public void print() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	public void print(int[] pattern) {
		for (int i = 0; i < pattern.length; i++) {
			System.out.print(pattern[i]);
		}
	}
	public void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	} 
}
