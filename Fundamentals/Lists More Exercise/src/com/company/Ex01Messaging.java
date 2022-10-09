package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex01Messaging {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String>numbers= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        StringBuilder text= new StringBuilder(scanner.nextLine());
        StringBuilder result= new StringBuilder();

        for(int i=0;i<numbers.size();i++){
            int sum=0;
            int []digits=Arrays.stream(numbers.get(i).split("")).mapToInt(Integer::parseInt).toArray();
            for(int k=0;k<digits.length;k++){
                 sum+=digits[k];
            }
            if(sum>text.length()){
                result.append(text.charAt(1));
                text.deleteCharAt(1);
            }else {
                result.append(text.charAt(sum));
                text.deleteCharAt(sum);
            }
        }
        String []str=result.toString().split("");
        for(String item:str){
            System.out.print(item);
        }
    }
}
