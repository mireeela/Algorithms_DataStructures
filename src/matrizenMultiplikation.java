import java.util.Random;

public class matrizenMultiplikation {
    public static double[] matrizenMultiplikation(double[] matrix1,
                                                  int breiteMatrix1,
                                                  double[] matrix2,
                                                  int breiteMatrix2){

        int hoheMatrix1 = matrix1.length/breiteMatrix1;
        int hoheMatrix2 = matrix2.length/breiteMatrix2;

        double[] ergebnis = new double[hoheMatrix1 * breiteMatrix2];

        if (breiteMatrix1 != hoheMatrix2) {
            System.out.println("Matrixdimensionen stimmen nicht.");
            return ergebnis;
        }

        //spalte x zeile

        for(int i = 0; i < hoheMatrix1; i++){
            for (int j = 0; j < breiteMatrix2; j++) {
                double sum = 0;

                for (int k = 0; k < breiteMatrix1; k++) {
                    sum += matrix1[i * breiteMatrix1 + k] * matrix2[k * breiteMatrix2 + j];
                }
                ergebnis[i * breiteMatrix2 + j] = sum;
            }
        }

        return ergebnis;
    }

    public static void printMatrix(double[] matrix, int breiteMatrix){
        int hoheMatrix = matrix.length/breiteMatrix;
        for(int i = 0; i < hoheMatrix; i++){
            for (int j = 0; j < breiteMatrix; j++) {
                int index = i * breiteMatrix + j;
                System.out.print((int)matrix[index]+" ");
            }
            System.out.println();
        }
    }

    //3.2
    public static double[] randomMatrix(int n){
        double[] matrix = new double[n*n];
        Random random = new Random();
        for(int i = 0; i < matrix.length; i++){
            matrix[i] = random.nextInt(100);
        }
        return matrix;


    }

}
