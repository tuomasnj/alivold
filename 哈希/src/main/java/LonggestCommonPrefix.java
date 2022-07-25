public class LonggestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight",""};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        Character[] ch = new Character[Integer.MAX_VALUE];
        int min = 0;
        int temp = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            ch[i] = strs[0].charAt(i);
            min ++;
        }
        for (String s : strs){
            if(s.equals(""))return "";
            temp = 0;
            for (int i = 0; i < s.length(); i++) {
                if(temp >= min){
                    continue;
                }
                if(ch[i] == s.charAt(i)){
                    temp ++;
                }
                if(i == s.length() - 1 || ch[i] != s.charAt(i)){
                    min = Math.min(temp, min);
                }
            }
        }
        StringBuilder stringBuilder =new StringBuilder();
        for (int i = 0; i < min; i++) {
            stringBuilder.append(ch[i]);
        }
        return stringBuilder.toString();
    }
}
