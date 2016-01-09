import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

public class Ttt {

	private static String[][] questionArray;

	public static String[][] questionTable(int i) throws FileNotFoundException {
		StringBuilder sb;
		String line;

		questionArray = new String[10][5];

		FileReader file = null;

		switch (i) {
		case 1:
			file = new FileReader("AccessControle.txt");
			break;
		case 2:
			file = new FileReader("DataTypes.txt");
			break;
		case 3:
			file = new FileReader("EventHandling.txt");
			break;
		case 4:
			file = new FileReader("Exceptions.txt");
			break;
		case 5:
			file = new FileReader("Inheritance.txt");
			break;
		case 6:
			file = new FileReader("InputOutput.txt");
			break;
		case 7:
			file = new FileReader("LiteralsAndVariables.txt");
			break;
		case 8:
			file = new FileReader("MultiThreading.txt");
			break;

		}

		try (BufferedReader br = new BufferedReader(file)) {
			sb = new StringBuilder();
			line = br.readLine();

			while (!line.equals("<<<<<")) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			questionArray[0][0] = sb.toString();
			questionArray[0][1] = br.readLine();
			questionArray[0][2] = br.readLine();
			questionArray[0][3] = br.readLine();
			questionArray[0][4] = br.readLine();

			sb = new StringBuilder();
			line = br.readLine();

			while (!line.equals("<<<<<")) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			questionArray[1][0] = sb.toString();
			questionArray[1][1] = br.readLine();
			questionArray[1][2] = br.readLine();
			questionArray[1][3] = br.readLine();
			questionArray[1][4] = br.readLine();

			sb = new StringBuilder();
			line = br.readLine();

			while (!line.equals("<<<<<")) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			questionArray[2][0] = sb.toString();
			questionArray[2][1] = br.readLine();
			questionArray[2][2] = br.readLine();
			questionArray[2][3] = br.readLine();
			questionArray[2][4] = br.readLine();

			sb = new StringBuilder();
			line = br.readLine();

			while (!line.equals("<<<<<")) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			questionArray[3][0] = sb.toString();
			questionArray[3][1] = br.readLine();
			questionArray[3][2] = br.readLine();
			questionArray[3][3] = br.readLine();
			questionArray[3][4] = br.readLine();

			sb = new StringBuilder();
			line = br.readLine();

			while (!line.equals("<<<<<")) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			questionArray[4][0] = sb.toString();
			questionArray[4][1] = br.readLine();
			questionArray[4][2] = br.readLine();
			questionArray[4][3] = br.readLine();
			questionArray[4][4] = br.readLine();

			sb = new StringBuilder();
			line = br.readLine();

			while (!line.equals("<<<<<")) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			questionArray[5][0] = sb.toString();
			questionArray[5][1] = br.readLine();
			questionArray[5][2] = br.readLine();
			questionArray[5][3] = br.readLine();
			questionArray[5][4] = br.readLine();

			sb = new StringBuilder();
			line = br.readLine();

			while (!line.equals("<<<<<")) {
				sb.append(line);
				sb.append("\n");
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			questionArray[6][0] = sb.toString();
			questionArray[6][1] = br.readLine();
			questionArray[6][2] = br.readLine();
			questionArray[6][3] = br.readLine();
			questionArray[6][4] = br.readLine();

			sb = new StringBuilder();
			line = br.readLine();

			while (!line.equals("<<<<<")) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			questionArray[7][0] = sb.toString();
			questionArray[7][1] = br.readLine();
			questionArray[7][2] = br.readLine();
			questionArray[7][3] = br.readLine();
			questionArray[7][4] = br.readLine();

			sb = new StringBuilder();
			line = br.readLine();

			while (!line.equals("<<<<<")) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			questionArray[8][0] = sb.toString();
			questionArray[8][1] = br.readLine();
			questionArray[8][2] = br.readLine();
			questionArray[8][3] = br.readLine();
			questionArray[8][4] = br.readLine();

			sb = new StringBuilder();
			line = br.readLine();

			while (!line.equals("<<<<<")) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			questionArray[9][0] = sb.toString();
			questionArray[9][1] = br.readLine();
			questionArray[9][2] = br.readLine();
			questionArray[9][3] = br.readLine();
			questionArray[9][4] = br.readLine();

		} catch (IOException e) {
			System.out.println("Error");
		}

		return questionArray;
	}

	public static void main(String[] args) throws FileNotFoundException {
		questionTable(3);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++)
				System.out.println(questionArray[i][j]);
		}

	}

}
