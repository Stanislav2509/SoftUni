package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //String phoneNumber = "(555) 555-5555";
        String phoneNumber = "1!!0!1!!!1!1!!0";
        String cleaned = phoneNumber.replaceAll("[^0-1]",""); // "5555555555"
        int [] DNAArr= Arrays.stream(cleaned.split("")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<DNAArr.length;i++){
            System.out.println(DNAArr[i]);
        }
    }
}
