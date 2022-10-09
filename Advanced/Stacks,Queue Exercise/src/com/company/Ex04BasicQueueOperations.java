package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] input=scanner.nextLine().split(" ");
        int countPoll=Integer.parseInt(input[1]);
        int numberToSearch=Integer.parseInt(input[2]);

        List<String> numbers= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        ArrayDeque<Integer> queueNumbers=new ArrayDeque<>();
        for(int i=0;i< numbers.size();i++){
            queueNumbers.offer(Integer.parseInt(numbers.get(i)));
        }
        for(int i=0;i<countPoll;i++){
            queueNumbers.poll();
        }
        if(queueNumbers.isEmpty()){
            System.out.println(0);
        }else if(queueNumbers.contains(numberToSearch)){
            System.out.println(true);
        }else {
            //System.out.println(Collections.min(queueNumbers));

            int minNumber=Integer.MAX_VALUE;
            for (int num: queueNumbers) {
                if(minNumber>num){
                    minNumber=num;
                }
            }
            System.out.println(minNumber);
//            int minNumber=queueNumbers.stream().mapToInt(e->e).min().getAsInt();
//            System.out.println(minNumber);
        }
    }
}
