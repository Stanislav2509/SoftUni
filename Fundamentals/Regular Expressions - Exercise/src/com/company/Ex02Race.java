package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        Map<String, Integer> participantsDistance = new LinkedHashMap<>();
        participants.forEach(name -> participantsDistance.put(name, 0));

        String letterRegex = "[A-Za-z]+";
        Pattern letterPattern = Pattern.compile(letterRegex);

        String numberRegex = "[0-9]";
        Pattern numberPattern = Pattern.compile(numberRegex);

        while (!input.equals("end of race")) {
            StringBuilder nameBuilder = new StringBuilder();
            Matcher letterMatcher = letterPattern.matcher(input);
            while (letterMatcher.find()) {
                nameBuilder.append(letterMatcher.group());
            }

            int distance = 0;
            Matcher numberMatcher = numberPattern.matcher(input);
            while (numberMatcher.find()) {
                distance += Integer.parseInt(numberMatcher.group());
            }
            String name = nameBuilder.toString();
            if (participantsDistance.containsKey(name)) {
                participantsDistance.put(name, participantsDistance.get(name) + distance);
            }

            input = scanner.nextLine();
        }
        List<String> top3Participants=participantsDistance.entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("1st place: "+top3Participants.get(0));
        System.out.println("2nd place: "+top3Participants.get(1));
        System.out.println("3rd place: "+top3Participants.get(2));
    }
}

