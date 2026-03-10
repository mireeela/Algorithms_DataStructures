import java.util.Random;

public class AbschaetzungPi {
    public double pi(int n){
        //int runs= 10;
        //long[] time_measurements = new long[runs];
        //for(int j = 0; j < runs; j++){
            //long start = System.nanoTime();
            double pi;
            int t = 0;
            //int n = 10000;
            Random random = new Random();
            double x;
            double y;
            for(double i = 0; i < n; i++){
                x = random.nextDouble();
                y = random.nextDouble();
                if(y <= Math.sqrt(1-(x*x))){
                    t++;
                }
            }
            return pi = (4.0 * t)/n;
        }

        public void pi_time(){
            int runs= 10;
            long[] time_measurements = new long[runs];
            for(int j = 0; j < runs; j++) {
                long start = System.nanoTime();
                pi(100000);
                long end = System.nanoTime();
                time_measurements[j] = end - start;
                System.out.println("Laufzeit von " + (j + 1) + ". Lauf: " + time_measurements[j] + " ns");
            }
            //mittelwert
            double sum = 0;
            for(long k : time_measurements){
                sum = sum + k; //summe alle zeiten
            }
            double average = sum / runs; //summe zeiten durch 10 mal
            System.out.println("Mittelwert: " + average);

            //standardabweichung
            double num = 0;
            for(long k : time_measurements){
                num = num + ((k-average)*(k-average)); // formel teil1
            }
            double deviation = Math.sqrt(num/runs); //formel teil2
            System.out.println("Standardabweichung: " + deviation);
    }
}
