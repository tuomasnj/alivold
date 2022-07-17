import java.util.Arrays;

public class _621 {
    public static void main(String[] args) {
        int n=0;
        char[] tasks={'A','A','A','B','B','B'};
        System.out.println(leastInterval(tasks,n));
    }
    public static int leastInterval(char[] tasks,int n){
        int[] arr=new int[26];
        for (int i = 0; i < tasks.length; i++) {
            arr[tasks[i]-'A']+=1;
        }
        Arrays.sort(arr);
        int max=arr[25];
        int count=0;
        for (int i = arr.length-1; i >=0 ; i--) {
            if(arr[i]==max){
                count++;
            }
        }
        return Math.max(tasks.length,(max-1)*(n+1)+count);
    }
}
