package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<String> backURls=new ArrayDeque<>();
        ArrayDeque<String> forwardURls=new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentURl=null;

        while (!input.equals("Home")){

            if(input.equals("back")){
                if(backURls.isEmpty()){
                    System.out.println("no previous URLs");
                    input= scanner.nextLine();
                    continue;
                }else {
                    forwardURls.push(currentURl);
                    currentURl= backURls.pop();

                }
            }else if(input.equals("forward")){
                if(forwardURls.isEmpty()){
                    System.out.println("no next URLs");
                    input= scanner.nextLine();
                    continue;
                }else {
                    backURls.push(currentURl);
                    currentURl=forwardURls.pop();

                }
            }
            else {
                if(currentURl!=null){
                    backURls.push(currentURl);
                }
                currentURl=input;

            }
            System.out.println(currentURl);
            input= scanner.nextLine();
        }

    }
}
