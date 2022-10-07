import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        scanner.nextLine();
        String[] s =new String[len * 2];
        for (int i  = 0;  i < len; i ++){
            s[2 * i] = scanner.nextLine();
            s[2 * i + 1] = scanner.nextLine();
        }
        int chance = 1;
        for (int i = 0; i < s.length / 2; i++) {
            String s1 = s[2 * i];
            String s2 = s[2 * i + 1];
            for (int j = 0; j < s1.length(); j++) {
                if(s1.charAt(j) == s2.charAt(j)){
                    if(j == s1.length() - 1){
                        System.out.println("Yes");
                    }
                    continue;
                }else {
                    if(j + 1 >= s1.length()){
                        System.out.println("No");
                        break;
                    }
                    if(chance > 0 && s1.charAt(j + 1) == s2.charAt(j) && s1.charAt(j) == s2.charAt(j + 1)){
                        chance--;
                        if(j == s1.length() - 2){
                            System.out.println("Yes");
                        }
                        j++;
                        continue;
                    }else {
                        System.out.println("No");
                        break;
                    }
                }
            }
            chance = 1;
        }
    }
}
