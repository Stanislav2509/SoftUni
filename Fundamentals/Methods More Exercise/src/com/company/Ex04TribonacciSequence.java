package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=Integer.parseInt(scanner.nextLine());

        for (String item:searchTribonacciSequence(num)){
            System.out.print(item+" ");
        }

    }

    public static List<String> searchTribonacciSequence(int num){
        List<String>result=new ArrayList<>();
        int num1=0,num2=0,num3,num4;
        int startIndex=0, endIndex=3;

        for(int i=1;i<=num;i++){

            if(i==1){
                num1++;
                result.add(String.valueOf(num1));
            }else if(i==2){
                num2++;
                result.add(String.valueOf(num2));
            }else if(i==3){
                num4=num1+num2;
                result.add(String.valueOf(num4));
            }
            else {
                List<String>subList=result.subList(startIndex,endIndex);

                num1=Integer.parseInt(subList.get(0));
                num2=Integer.parseInt(subList.get(1));
                num3=Integer.parseInt(subList.get(2));
                num4=num1+num2+num3;
                result.add(String.valueOf(num4));
                startIndex++;
                endIndex++;
            }

        }
        return  result;
    }
}
