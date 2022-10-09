package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex01WinningTicket {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> tickets= Arrays.stream(scanner.nextLine().split("\\s*,\\s*")).collect(Collectors.toList());
        for(String ticket:tickets){
            if(ticket.length()==20){
                String leftHalf=getLeftHalf(ticket);
                String rightHalf=getRightHalf(ticket);

                String regex="[$@#^]+";
                Pattern pattern =Pattern.compile(regex);
                String winningLeftHalf=getWinningSymbols(pattern,leftHalf);
                String winningRightHalf=getWinningSymbols(pattern,rightHalf);


                Map<Character,Integer>leftSymbolsLength=symbolsLength(winningLeftHalf);
                Map<Character,Integer>rightSymbolsLength=symbolsLength(winningRightHalf);

                if(leftSymbolsLength.isEmpty()||rightSymbolsLength.isEmpty()){
                    System.out.printf("ticket \"%s\" - no match%n",ticket);continue;
                }

                List<Character> mostRepeatSymbol= leftSymbolsLength.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(1).map(Map.Entry::getKey).collect(Collectors.toList());
                int leftSymbolLength=leftSymbolsLength.get(mostRepeatSymbol.get(0));
                int rightSymbolLength=rightSymbolsLength.get(mostRepeatSymbol.get(0));
                int minLength=Math.min(leftSymbolLength,rightSymbolLength);

                if(leftSymbolLength==rightSymbolLength&&rightSymbolLength>=6&&rightSymbolLength<10){
                    System.out.printf("ticket \"%s\" - %d%c%n",ticket,rightSymbolLength,mostRepeatSymbol.get(0));
                }else if(leftSymbolLength==rightSymbolLength&&rightSymbolLength==10){
                    System.out.printf("ticket \"%s\" - %d%c Jackpot!%n",ticket,rightSymbolLength,mostRepeatSymbol.get(0));
                }else if(leftSymbolLength!=rightSymbolLength&&minLength>=6&&minLength<10){
                    System.out.printf("ticket \"%s\" - %d%c%n",ticket,minLength,mostRepeatSymbol.get(0));
                }
                else {
                    System.out.printf("ticket \"%s\" - no match%n",ticket);
                }
            }
            else {
                System.out.println("invalid ticket");
            }
        }
    }
    private static Map<Character,Integer>symbolsLength(String winningHalf){
        Map<Character,Integer>symbolsLength=new LinkedHashMap<>();
        for(int i=0;i<winningHalf.length();i++){
            int countRepeatSymbols=0;
            char symbol=winningHalf.charAt(i);
            loop: for(int k=i+1;k<winningHalf.length();k++){
                if(symbol==winningHalf.charAt(k)){
                    countRepeatSymbols++;
                    symbolsLength.put(symbol,countRepeatSymbols+1);
                    i++;
                }else {
                    break loop;
                }
            }
        }
        return  symbolsLength;
    }

    private static String getWinningSymbols(Pattern pattern,String string) {
        Matcher matcher= pattern.matcher(string);
        String winningHalf="";
        while (matcher.find()){
            winningHalf=matcher.group();
        }
        return winningHalf;
    }

    private static String getRightHalf(String ticket) {
        StringBuilder rightHalf=new StringBuilder();
        for(int i=10;i<20;i++){
          rightHalf.append(ticket.charAt(i));
        }
        return rightHalf.toString();
    }

    private static String getLeftHalf(String ticket) {
        StringBuilder leftHalf=new StringBuilder();
        for(int i=0;i<10;i++){
            leftHalf.append(ticket.charAt(i));
        }
        return leftHalf.toString();
    }
}
