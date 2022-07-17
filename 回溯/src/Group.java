import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    //删数问题，给一串数字，给删除数量，求剩余部分组成的最大数字，不能改变数字顺序
    public static void main(String[] args) {
        String num = "568741235896331";
        System.out.println(deleteK(4,num));
    }
    public static Long deleteK(int k,String s){
        List<Long> res= new ArrayList<>();
        List<Character> temp =new ArrayList<>();
        helper(res,temp,s,0,k);
        Collections.sort(res);
        return res.get(res.size()-1);
    }
    public static void helper(List<Long> res,List<Character> temp, String s, int start,int k){
        if(temp.size()==(s.length()-k)){
            StringBuilder sb =new StringBuilder();
            for(Character c:temp){
                sb.append(c);
            }
            res.add(Long.valueOf(sb.toString()));
            return;
        }
        for (int i = start; i <s.length() ; i++) {
            temp.add(s.charAt(i));
            helper(res,temp,s,i+1,k);
            temp.remove(temp.size()-1);
        }
    }
}
