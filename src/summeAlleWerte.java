public class summeAlleWerte {
    public static double summeAlleWerte(double[] arr){
        return summeRekursiv(arr, 0);
    }
    public static double summeRekursiv(double[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + summeRekursiv(arr, index + 1);
    }

}
