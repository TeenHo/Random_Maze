package Random_Maze;

import java.util.Scanner;

public class random_maze {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = 29;
		int width = 15;
		int a = 0;
		while (a < 1) {
			System.out.print("Введите цифру от 1 до 3: ");
			int choice = in.nextInt();
			System.out.println();
			switch (choice) {
				case 1:
					new Maze1(length, width);
					break;
				case 2:
					new Maze2(length, width);
					break;
				case 3:
					new Maze3(length, width);
					break;
				default:
					System.out.println("Неверный ввод!");
					in.close();
					a++;
					break;
			}
			System.out.println();
		}
		
	}
}