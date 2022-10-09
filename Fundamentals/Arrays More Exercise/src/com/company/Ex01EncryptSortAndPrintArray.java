package com.company;

import java.util.Scanner;

public class Ex01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int lines=Integer.parseInt(scanner.nextLine());
        String name;
        char letter;
        int []sumArr=new int[lines];
        int sum=0;

        for(int i=0;i<lines;i++){
            name= scanner.nextLine();

            for(int k=0;k<name.length();k++){
                letter=name.charAt(k);

                if(letter=='a' || letter=='A' || letter=='e' || letter=='E' || letter=='o' || letter=='O'
                        || letter=='i' || letter=='I' || letter=='u' || letter=='U'){

                    sum+=letter*name.length();

                }else {
                    sum+=letter/name.length();
                }
            }
            sumArr[i]+=sum;
            sum=0;
        }

      int temp;
        for(int i=0;i<sumArr.length;i++){
            for(int k=i+1;k<sumArr.length;k++){
                if(sumArr[i]>sumArr[k]){
                    temp=sumArr[i];
                    sumArr[i]=sumArr[k];
                    sumArr[k]=temp;
                }
            }

        }


        for(int i=0;i<sumArr.length;i++){
            System.out.println(sumArr[i]);
        }

    }
}
