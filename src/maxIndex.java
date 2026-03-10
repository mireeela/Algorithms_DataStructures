public class maxIndex {
    public static int maxIndex(double[] arr, int startIndex, int endIndex){
        if (startIndex == endIndex) {
            return startIndex;
        }
        int maxIndexRest = maxIndex(arr, startIndex + 1, endIndex);
        if (arr[startIndex] >= arr[maxIndexRest]) {
            return startIndex;
        } else {
            return maxIndexRest;
        }

    }
}
