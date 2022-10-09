package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Ex02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] input=scanner.nextLine().split(" ");
        int countPush=Integer.parseInt(input[0]);
        int countPop=Integer.parseInt(input[1]);
        int numberToSearch=Integer.parseInt(input[2]);

        List<String> numbers= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        ArrayDeque<Integer> stackNumbers=new ArrayDeque<>();
        for(int i=0;i< numbers.size();i++){
            stackNumbers.push(Integer.parseInt(numbers.get(i)));
        }
        for(int i=0;i<countPop;i++){
            stackNumbers.pop();
        }
        if(stackNumbers.isEmpty()){
            System.out.println(0);
        }else if(stackNumbers.contains(numberToSearch)){
            System.out.println(true);
        }else {
            //System.out.println(Collections.min(stackNumbers));

            int minNumber=Integer.MAX_VALUE;
            for (int num: stackNumbers) {
                if(minNumber>num){
                    minNumber=num;
                }
            }
            System.out.println(minNumber);
//            int minNumber=stackNumbers.stream().mapToInt(e->e).min().getAsInt();
//            System.out.println(minNumber);
        }
    }

}
