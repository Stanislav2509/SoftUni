package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex05KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        String command= scanner.nextLine();

        //броя на най-дългата поредица от единици
        int maxSubsequenceOfOnes=0;
        //лист от броя на най-дългите поредици от единици за всяко въведено ДНК
        List<Integer> listOfMaxSubsequenceOfOnes=new ArrayList<>();

        //първоначанлия индекс откъдето почва броенето за 'maxSubsequenceOfOnes'
        int minLeftmostStartingIndex=0;
        List<Integer> listOfMinLeftmostStartingIndex=new ArrayList<>();
        //всички въведени ДНК-та
        List<String> listOfDNA=new ArrayList<>();
        //индех в 'listOfDNA' за най-доброто ДНК
        int indexOfBestDNA=0;

        //с равни поредици от единици с равен начален индекс
        boolean flag=false;
        List<Integer> listOfSumOnElementInDNA=new ArrayList<>();
        List<Integer> indexesOfSubsequenceOfOnes=new ArrayList<>();
        int countDNA=0;

        while (!command.equals("Clone them!")){
            countDNA++;
            listOfDNA.add(command);
            String DNAStr=command.replaceAll("[^0-1]","");
            int [] DNAArr=Arrays.stream(DNAStr.split("")).mapToInt(Integer::parseInt).toArray();
            int sumOnElementInDNA=0;
            //колко пъти се повтаря единица в ДНК-то докато не срещне нула
            int currentSubsequenceOfOnes=0;
            //най-големия брой от поредни единици в текущото ДНК
            int currentMaxSubsequenceOfOnes=0;
            //има ли нула в текущото ДНК
            boolean hasZero=false;
            //първоначалния индекс, в който започва броенето на най-дългата поредица от единици в текущото ДНК
            int currentMinLeftmostStartingIndex=0;

            for (int i = 0; i < DNAArr.length; i++) {
                sumOnElementInDNA+=DNAArr[i];
                //намираме най-дългата поредица от едини в текущото ДНК и от кой индекс започва
                if(DNAArr[i]==1){
                    currentSubsequenceOfOnes++;
                    indexesOfSubsequenceOfOnes.add(i);
                }
                else {
                    if(currentSubsequenceOfOnes>currentMaxSubsequenceOfOnes){
                        currentMinLeftmostStartingIndex=indexesOfSubsequenceOfOnes.get(0);
                        currentMaxSubsequenceOfOnes=currentSubsequenceOfOnes;
                        hasZero=true;
                    }
                        currentSubsequenceOfOnes=0;
                        indexesOfSubsequenceOfOnes.clear();
                }
            }

            if(DNAArr[DNAArr.length-1]==1){
                indexesOfSubsequenceOfOnes.clear();
            }

            //ДНК-то е било само от единици
            if(!hasZero){
                currentMaxSubsequenceOfOnes=currentSubsequenceOfOnes;
            }

            listOfMaxSubsequenceOfOnes.add(currentMaxSubsequenceOfOnes);
            listOfMinLeftmostStartingIndex.add(currentMinLeftmostStartingIndex);
            listOfSumOnElementInDNA.add(sumOnElementInDNA);

            if(countDNA>=2){
                //първото ДНК е с по-голяма поредица от единици отколкото второто ДНК
                if(listOfMaxSubsequenceOfOnes.get(countDNA-2)>listOfMaxSubsequenceOfOnes.get(countDNA-1)){
                    maxSubsequenceOfOnes=listOfMaxSubsequenceOfOnes.get(countDNA-2);
                    indexOfBestDNA=countDNA-2;
                    listOfMaxSubsequenceOfOnes.remove(countDNA-1);
                    countDNA--;
                }
                //второто ДНК е с по-голяма поредица от единици отколкото първото ДНК
                else if(listOfMaxSubsequenceOfOnes.get(countDNA-1)>listOfMaxSubsequenceOfOnes.get(countDNA-2)){
                    maxSubsequenceOfOnes=listOfMaxSubsequenceOfOnes.get(countDNA-1);
                    indexOfBestDNA=countDNA-1;
                    listOfMaxSubsequenceOfOnes.remove(countDNA-2);
                    countDNA--;
                }
                //двете ДНК са с еднакви поредици от единици,но започват от различен индекс
                else if(listOfMaxSubsequenceOfOnes.get(countDNA-2)==listOfMaxSubsequenceOfOnes.get(countDNA-1)
                && listOfMinLeftmostStartingIndex.get(countDNA-2)!=listOfMinLeftmostStartingIndex.get(countDNA-1)){


                    if(listOfMinLeftmostStartingIndex.get(countDNA-2)<listOfMinLeftmostStartingIndex.get(countDNA-1)){
                        maxSubsequenceOfOnes=listOfMaxSubsequenceOfOnes.get(countDNA-2);
                        indexOfBestDNA=countDNA-2;
                        listOfMaxSubsequenceOfOnes.remove(countDNA-1);
                        countDNA--;
                    }else {
                        maxSubsequenceOfOnes=listOfMaxSubsequenceOfOnes.get(countDNA-1);
                        indexOfBestDNA=countDNA-1;
                        listOfMaxSubsequenceOfOnes.remove(countDNA-2);
                        countDNA--;
                    }

                }
                //двете ДНК са с еднакви поредици от единици и започват от еднакъв индекс индекс
                else if(listOfMaxSubsequenceOfOnes.get(countDNA-2)==listOfMaxSubsequenceOfOnes.get(countDNA-1)
                        && listOfMinLeftmostStartingIndex.get(countDNA-2)==listOfMinLeftmostStartingIndex.get(countDNA-1)){

                    flag=true;
                    if(listOfSumOnElementInDNA.get(countDNA-2)>listOfSumOnElementInDNA.get(countDNA-1)){
                        maxSubsequenceOfOnes=listOfMaxSubsequenceOfOnes.get(countDNA-2);
                        indexOfBestDNA=countDNA-2;
                        listOfMaxSubsequenceOfOnes.remove(countDNA-1);
                        countDNA--;
                    }
                    else {
                        maxSubsequenceOfOnes=listOfMaxSubsequenceOfOnes.get(countDNA-1);
                        indexOfBestDNA=countDNA-1;
                        listOfMaxSubsequenceOfOnes.remove(countDNA-2);
                        countDNA--;
                    }
                }
            }

            command=scanner.nextLine();
        }

        String []bestDNAArr=listOfDNA.get(indexOfBestDNA).split("!");
        StringBuilder bestDNA= new StringBuilder();
        for(int i=0;i<bestDNAArr.length;i++){
            bestDNA.append(bestDNAArr[i]+" ");
        }



        if(flag){
            System.out.printf("Best DNA sample %d with sum: %d.%n" +
                    "%s",indexOfBestDNA+1,listOfSumOnElementInDNA.get(indexOfBestDNA), bestDNA);
        }else {
            System.out.printf("Best DNA sample %d with sum: %d.%n" +
                    "%s",indexOfBestDNA+1,maxSubsequenceOfOnes, bestDNA);
        }
    }
}