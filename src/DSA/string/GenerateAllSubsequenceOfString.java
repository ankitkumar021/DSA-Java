package DSA.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsequenceOfString {
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String s ="ab";
        generate( s,"");
       // System.out.println(list);


    }
    public static void generate(String input,String output){
        if(input.length()==0){
          //  list.add(output);
            System.out.println(output);
            return;
        }
        //with
        generate(input.substring(1),output+input.charAt(0));
        //without
        generate(input.substring(1),output);


    }
}
