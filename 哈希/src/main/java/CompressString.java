import java.util.HashSet;

public class CompressString {
    public static void main(String[] args) {
        String s = "beeetteerr";
        String[] strings = {"bet", "beeter", "bbeter","better", "breter", "sbret"};
        HashSet<String> set = new HashSet<>();
        int res = 0;
        for(String str :strings){
            if(isLongPressedName(str, s)){
                res++;
            }
        }
        System.out.println(res);
    }
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
