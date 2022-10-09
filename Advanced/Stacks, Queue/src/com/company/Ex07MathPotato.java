package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex07MathPotato {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> children= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        ArrayDeque<String> childrenNames =new ArrayDeque<>();
        for (String name:children) {
            childrenNames.offer(name);
        }
        int repeat=Integer.parseInt(scanner.nextLine());
        int countCycles=1;
        while (childrenNames.size()!=1){
            int numberDivisors=0;

            for(int i=1;i<=repeat;i++){
                String currentChild=childrenNames.peek();

                if(i!=repeat){
                    childrenNames.poll();
                    childrenNames.offer(currentChild);
                }else {
                    if(countCycles>1){
                        for(int k=1;k<= repeat*2;k++){
                            if(countCycles%k==0){
                                numberDivisors++;
                            }
                        }
                    }
                    if(numberDivisors!=2){
                        childrenNames.poll();
                        System.out.println("Removed "+currentChild);
                        countCycles++;
                    }else {
                        System.out.println("Prime "+currentChild);
                        countCycles++;
                    }

                }
            }

        }
        System.out.println("Last is "+ childrenNames.peek());
    }
}
