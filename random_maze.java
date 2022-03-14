package my_lessons;

public class random_maze {

	public static void main(String[] args) {
		Maze maze = new Maze(30, 15);
		
	}
}

class Maze {
	private int Length;
	private int Width;
	
	public Maze (int Length, int Width) {
		this.Length = Length;
		this.Width = Width;
		
		String[][] maze = new String[this.Length][this.Width];
		String[] element2 = new String[] {"+", "-"};
		String[] element3 = new String[] {"-", " "};
		String[] element4 = new String[] {"|", "+"};
		String[] element5 = new String[] {"|", " "};
		String[] element6 = new String[] {"+", " "};
		
		//формирование начального элемента лабиринта
		maze[0][0] = MazeStartElement();
		
		//заполнение горизонтальной границы лабиринта
		for (int i = 1; i < this.Length; i++) {
			if (maze[i - 1][0] == " ")
				maze[i][0] = "+";
			else if (maze[i - 1][0] == "|")
				maze[i][0] = " ";
			else if (maze[i - 1][0] == "-")
				maze[i][0] = element2[(int)(Math.random() * 10) / 5];
			else if (maze[i - 1][0] == "+")
				maze[i][0] = element3[(int)(Math.random() * 10) / 5];
			System.out.print(maze[i][0]);
		}
		
		System.out.println();
		
		//заполнение вертикальной границы лабиринта
		for (int j = 1; j < this.Width; j++) {
			if (maze[0][j - 1] == " ")
				maze[0][j] = element2[(int)(Math.random() * 10) / 5];
			else if (maze[0][j - 1] == "|")
				maze[0][j] = element4[(int)(Math.random() * 10) / 5];
			else if (maze[0][j - 1] == "-")
				maze[0][j] = " ";
			else if (maze[0][j - 1] == "+")
				maze[0][j] = element5[(int)(Math.random() * 10) / 5];
		}
		
		//заполнение оставшейся зоны лабиринта
		for (int j = 1; j < this.Width; j++) {
			for (int i = 0; i < this.Length; i++) {
				if (i > 0) {
					if (maze[i][j - 1] == " ") {
						if (maze[i - 1][j] == " ") {
							if (maze[i - 1][j - 1] == " ")
								maze[i][j] = element6[(int)(Math.random() * 10) / 5];
							else
								maze[i][j] = " ";
						}
						else if (maze[i - 1][j] == "|")
							maze[i][j] = " ";
						else if (maze[i - 1][j] == "-")
							maze[i][j] = element2[(int)(Math.random() * 10) / 5];
						else if (maze[i - 1][j] == "+")
							maze[i][j] = element3[(int)(Math.random() * 10) / 5];
					}
					
					else if (maze[i][j - 1] == "|") {
						if (maze[i - 1][j] == " ")
							maze[i][j] = element4[(int)(Math.random() * 10) / 5];
						else
							maze[i][j] = "+";
					}
					
					else if (maze[i][j - 1] == "-")
						maze[i][j] = " ";
					
					else if (maze[i][j - 1] == "+"){
						if (maze[i - 1][j] == " ")
							maze[i][j] = element5[(int)(Math.random() * 10) / 5];
						else if (maze[i - 1][j] == "|")
							maze[i][j] = " ";
						else
							maze[i][j] = "+";		
					}
				}
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
	
	public static String MazeStartElement() {
		String[] element1 = new String[] {"+", "-", "|", " "};
		String maze = element1[(int)(Math.random() * 10) / 3];
		System.out.print(maze);
		return maze;
	}
	
}