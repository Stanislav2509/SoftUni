package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String>usernames= Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());


        for(int i=0;i< usernames.size();i++){
            if(usernames.get(i).length()<3||usernames.get(i).length()>16){
                usernames.remove(i);i--;
            }
        }
        for(int i=0;i<usernames.size();i++){
          loop:  for(int k=0;k<usernames.get(i).length();k++){
                char ch=usernames.get(i).charAt(k);
                if(!Character.isLetterOrDigit(ch)&&ch!='-'&&ch!='_'){
                    usernames.remove(i);i--;break loop;
                }
            }
        }
        for (String username : usernames) {
            System.out.println(username);
        }

    }
}
