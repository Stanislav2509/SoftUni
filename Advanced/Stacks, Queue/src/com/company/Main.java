package com.company;

public class Main {

    public static void main(String[] args) {
	// prime numbers
        for(int i=2;i<=13;i++){
            int x=1;
            for(int k=2;k<i;k++){
                if(i%k==0){
                    x=0;
                    break;
                }
            }
            if(x==1){
                System.out.println(i);
            }
        }

    }
}
