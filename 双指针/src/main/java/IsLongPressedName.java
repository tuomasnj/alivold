public class IsLongPressedName {
    public static void main(String[] args) {
        String name = "a", typed = "e";
        System.out.println(isLongPressedName(name, typed));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j = 0;
        while (j < typed.length()){
            if(i < name.length() && name.charAt(i) == typed.charAt(j)){
                i ++;
                j ++;
            }else if(j >=1 && typed.charAt(j) == typed.charAt(j - 1)){
                j ++;
            }else {
                return false;
            }
        }
        return i == name.length();
    }
}
