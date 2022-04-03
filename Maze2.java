package Random_Maze;

public class Maze2 {
	private int Length;
	private int Width;
	
	public Maze2 (int Length, int Width) {
		this.Length = Length;
		this.Width = Width;
		
		String[][] maze = new String[this.Length][this.Width];
		
		for (int j = 0; j < this.Width; j += 2) {
			for (int i = 0; i < this.Length; i += 2) {
				maze[i][j] = "+";
			}
		}
		
		for (int j = 1; j < this.Width; j += 2) {
			for (int i = 1; i < this.Length; i += 2) {
				maze[i][j] = " ";
			}
		}
		
		//заполнение верхней границы
		for (int i = 1; i < this.Length; i += 2) {
			maze[i][0] = "-";
		}
		//создание входа
		maze[EntranceExit()][0] = " ";
		
		//заполнение нижней границы
		for (int i = 1; i < this.Length; i += 2) {
			maze[i][this.Width - 1] = "-";
		}
		//создание выхода
		maze[EntranceExit()][this.Width - 1] = " ";
		
		//заполнение боковых границ
		for (int j = 1; j < this.Width; j += 2) {
			maze[0][j] = "|";
			maze[this.Length - 1][j] = "|";
		}
		
		//заполнение внутренней части лабиринта
		for (int j = 1; j < this.Width; j += 2) {
			for (int i = 2; i < this.Length - 1; i += 2) {
				maze[i][j] = RandomElement("|", " ");
			}
		}
		
		for (int j = 2; j < this.Width - 1; j += 2) {
			for (int i = 1; i < this.Length; i += 2) {
				maze[i][j] = RandomElement("-", " ");
			}
		}
		
		//вывод лабиринта
		for (int j = 0; j < this.Width; j++) {
			for (int i = 0; i < this.Length; i++) {
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
	
	public String RandomElement(String element1, String element2) {
		String[] elements = new String[] {element1, element2};
		return elements[(int)(Math.random() * 10) / 5];
	}
	
	public int EntranceExit() {
		return ((int)(Math.random() * ((Length - 3) / 2)) * 2 + 1);
	}
}
