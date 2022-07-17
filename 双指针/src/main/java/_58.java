public class _58 {
    public static void main(String[] args) {
        String s="a good    example";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        s=s.trim();
        StringBuilder stb=new StringBuilder();
        int i=s.length()-1;
        int j=i;
        while(i>=0){
            while (i>=0 && s.charAt(i)!=' '){
                i--;
            }
            stb.append(s.substring(i+1,j+1)+" ");
            while (i>=0 && s.charAt(i)==' '){
                i--;
            }
            j=i;
        }
        return stb.toString().trim();
    }
}
