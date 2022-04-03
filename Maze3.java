package Random_Maze;

public class Maze3 {
	private int Length;
	private int Width;
	
	public Maze3 (int Length, int Width) {
		this.Length = Length;
		this.Width = Width;
		
		String[][] maze = new String[this.Length][this.Width];
		
		//закрашиваем лабиринт
		for (int j = 0; j < this.Width; j++) {
			for (int i = 0; i < this.Length; i++) {
				maze[i][j] = "O";
			}
		}
		
		int entrance = (int)(Math.random() * (this.Length - 3)) + 1;
		
		maze[entrance][0] = " ";
		maze[entrance][1] = " ";
		
		int i = entrance;
		int j = 1;
		
		String vector = "";
		
		while (j < this.Width - 1) {
			if (j == 1) {
				if (i == 1) {
					//dve dorogi
					vector = RandomVector("right", "down");
					if (vector == "right") {
						i++;
						maze[i][j] = " ";
					}
					if (vector == "down") {
						j++;
						maze[i][j] = " ";
					}
				}
				else if (i == this.Length - 2) {
					//dve dorogi
					vector = RandomVector("left", "down");
					if (vector == "left") {
						i--;
						maze[i][j] = " ";
					}
					if (vector == "down") {
						j++;
						maze[i][j] = " ";
					}
				}
				else {
					//tri dorogi
					vector = RandomVector("left", "right", "down");
					if (vector == "left") {
						i--;
						maze[i][j] = " ";
					}
					if (vector == "right") {
						i++;
						maze[i][j] = " ";
					}
					if (vector == "down") {
						j++;
						maze[i][j] = " ";
					}
				}
			}
			
			else if (i == 1) {
				//tri dorogi
				vector = RandomVector("up", "right", "down");
				if (vector == "up") {
					j--;
					maze[i][j] = " ";
				}
				if (vector == "right") {
					i++;
					maze[i][j] = " ";
				}
				if (vector == "down") {
					j++;
					maze[i][j] = " ";
				}
			}
			
			else if (i == this.Length - 2){
				//tri dorogi
				vector = RandomVector("up", "left", "down");
				if (vector == "up") {
					j--;
					maze[i][j] = " ";
				}
				if (vector == "left") {
					i--;
					maze[i][j] = " ";
				}
				if (vector == "down") {
					j++;
					maze[i][j] = " ";
				}
			}
			
			else {
				//chetire dorogi
				vector = RandomVector("up", "right", "down", "left");
				if (vector == "up") {
					j--;
					maze[i][j] = " ";
				}
				if (vector == "right") {
					i++;
					maze[i][j] = " ";
				}
				if (vector == "down") {
					j++;
					maze[i][j] = " ";
				}
				if (vector == "left") {
					i--;
					maze[i][j] = " ";
				}
			}
			
		}
		
		//вывод лабиринта
		for (j = 0; j < this.Width; j++) {
			for (i = 0; i < this.Length; i++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public int getLength() {
		return Length;
	}
	
	public int getWidth() {
		return Width;
	}
	
	public void setLength(int Length) {
		this.Length = Length;
	}
	
	public void setWidth(int Width) {
		this.Width = Width;
	}
	
	public String RandomVector(String vector1, String vector2, String vector3, String vector4) {
		String[] vectors = new String[] {vector1, vector2, vector3, vector4};
		return vectors[(int)(Math.random() * 4)];
	}
	
	public String RandomVector(String vector1, String vector2, String vector3) {
		String[] vectors = new String[] {vector1, vector2, vector3};
		return vectors[(int)(Math.random() * 3)];
	}
	
	public String RandomVector(String vector1, String vector2) {
		String[] vectors = new String[] {vector1, vector2};
		return vectors[(int)(Math.random() * 2)];
	}
}
