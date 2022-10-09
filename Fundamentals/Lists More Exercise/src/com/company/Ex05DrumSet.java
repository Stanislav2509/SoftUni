package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex05DrumSet {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double savings=Double.parseDouble(scanner.nextLine());
        List<Integer> qualityOnDrums= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer>copyQuality=new ArrayList<>();
        for (Integer qualityOnDrum : qualityOnDrums) {
            copyQuality.add(qualityOnDrum);
        }
        String command= scanner.nextLine();

        while (!command.equals("Hit it again, Gabsy!")){
            int power=Integer.parseInt(command);
            for(int i=0;i< qualityOnDrums.size();i++){
                qualityOnDrums.set(i, qualityOnDrums.get(i)-power);
            }

            for(int i=0;i<qualityOnDrums.size();i++){
                if(qualityOnDrums.get(i)<=0){
                    int drumPrice= copyQuality.get(i)*3;
                    if(drumPrice<=savings){
                        savings-=drumPrice;
                        qualityOnDrums.set(i, copyQuality.get(i));
                    }else {
                        qualityOnDrums.remove(i);
                        copyQuality.remove(i);
                        i--;
                    }
                }
            }

            command= scanner.nextLine();
        }
        for(int number:qualityOnDrums){
            System.out.print(number+" ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.",savings);
    }
}
