package guo;
import java.util.Scanner;
public class _58 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=sc.nextInt();
        System.out.println(reverseLeftWords(s,n));
    }
    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        int len=s.length();
        char[] result=new char[len];
        for (int i=0;i<len;++i){
            if(i<n){
                result[i+len-n]=chars[i];
            }else {
                result[i-n]=chars[i];
            }
        }
        return new String(result,0,len);
    }
}
