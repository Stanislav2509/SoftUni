package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex06HotPotato {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> children= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        ArrayDeque<String> childrenNames =new ArrayDeque<>();
        for (String name:children) {
            childrenNames.offer(name);
        }
        int repeat=Integer.parseInt(scanner.nextLine());
        while (childrenNames.size()!=1){
          for(int i=1;i<=repeat;i++){
              String currentChild= childrenNames.poll();
              if(i!=repeat){
                  childrenNames.offer(currentChild);
              }else {
                  System.out.println("Removed "+currentChild);
              }
          }

        }
        System.out.println("Last is "+ childrenNames.peek());
    }
}
