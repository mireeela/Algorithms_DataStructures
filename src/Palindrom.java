public class Palindrom {
    public static boolean istPalindrom(String p){
        int left = 0;
        int right = p.length()-1;
        for(int i = 0; left<right; i++){
            if(p.charAt(left) != p.charAt(right)){
                return false;
            }
            left++;
            right--;
            i++;
        }
        return true;
    }
}
