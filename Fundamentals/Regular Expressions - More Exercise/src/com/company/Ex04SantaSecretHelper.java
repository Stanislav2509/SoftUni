package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex04SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int key=Integer.parseInt(scanner.nextLine());
        String input= scanner.nextLine();
        while (!input.equals("end")){
            StringBuilder decrypt=new StringBuilder();
            for(int i=0;i<input.length();i++){
                decrypt.append((char)(input.charAt(i)-key));
            }

            String regex="@(?<name>[A-Za-z]+)([^@!:>-]+)?!(?<behavior>[GN])!";
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decrypt.toString());
            String name="";
            String behavior="";
            while (matcher.find()){
                name= matcher.group("name");
                behavior= matcher.group("behavior");
            }


            if(behavior.equals("G")){
                System.out.println(name);
            }
            input= scanner.nextLine();
        }
    }
}
