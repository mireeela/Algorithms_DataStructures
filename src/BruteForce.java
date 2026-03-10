import java.util.ArrayList;

public class BruteForce {
    public void bruteForce(){
        int count = 0;
        String[] chars = {"A","B","C","D"};
        ArrayList<String> combinations = new ArrayList<String>();
        for(int i = 0; i < chars.length; i++){
            for(int j = 0; j < chars.length; j++){
                for(int k = 0; k < chars.length; k++){
                    combinations.add(count, chars[i]+chars[j]+chars[k]);
                    count++;
                }
            }
        }

        for(int m = 0; m < combinations.size(); m++){
            System.out.print("Combination " + combinations.get(m) + " is: ");
            ZipDecryptInputStream.DecryptZipFile("C:\\a\\prog\\java\\alds\\src\\Test.zip","C:\\a\\prog\\java\\alds\\src",combinations.get(m),true);
        }
    }

}
