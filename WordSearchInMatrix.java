import java.util.*;

public class WordSearchInMatrix {

    public static boolean wordExists(char[][] matrix, String word) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < cols; j++) {
                row.append(matrix[i][j]);
            }
            if (row.toString().contains(word)) return true;
        }

        for (int j = 0; j < cols; j++) {
            StringBuilder col = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                col.append(matrix[i][j]);
            }
            if (col.toString().contains(word)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();

        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        String word = scanner.nextLine();
        System.out.println(wordExists(matrix, word));
    }
}
