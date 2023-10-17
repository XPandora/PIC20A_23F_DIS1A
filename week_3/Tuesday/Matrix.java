public class Matrix {
    public static int[][] initializeMatrix(int N) {
        // initialize a N by N matrix
        // value of each element is N * row_index + col_index
        // e.g. when N=3, array should be
        // 0 1 2
        // 3 4 5
        // 6 7 8
        int[][] mat;

        return mat;
    }

    public static void transpose(int[][] mat) {
        // transpose a matrix
        // you can assume mat is a square matrix
    }

    public static void main(String[] string) {
        int N = 4;
        int[][] mat = initializeMatrix(N);
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(String.format("%3s", Integer.toString(mat[r][c])));
            }
            System.out.print("\n");
        }

        transpose(mat);
        System.out.println("After transpose...");
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(String.format("%3s", Integer.toString(mat[r][c])));
            }
            System.out.print("\n");
        }
    }
}
