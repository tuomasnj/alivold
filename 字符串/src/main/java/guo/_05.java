package guo;

import java.util.Scanner;

public class _05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str= scanner.nextLine();
        _05 obj = new _05();
        String result=obj.replaceSpace(str);
        System.out.println(result);
    }
    public String replaceSpace(String s) {
        int size=0;
        char[] chars = s.toCharArray();
        int length=chars.length;
        char[] target=new char[length*3];
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                target[size++]='%';
                target[size++]='2';
                target[size++]='0';
            }else{
                target[size++]=chars[i];
            }
        }
        return new String(target,0,size);
    }
}
