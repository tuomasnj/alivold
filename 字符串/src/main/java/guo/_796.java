package guo;
public class _796 {
    public static void main(String[] args) {
        String s ="abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s,goal));
    }
    public static boolean rotateString(String s,String goal){
        if(s.length()==1)return s.equals(goal);
        StringBuilder sb=new StringBuilder(s);
        for (int i = 0; i < s.length()-1; i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if(goal.equals(sb.toString())){
                return true;
            }
        }
        return false;
    }
}
