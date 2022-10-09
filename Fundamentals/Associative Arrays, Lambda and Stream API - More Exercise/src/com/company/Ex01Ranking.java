package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Ex01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> contestPassword = new LinkedHashMap<>();
        Map<String, List<String>> userContests = new TreeMap<>();
        Map<String, List<Integer>> userPoints = new LinkedHashMap<>();
        Map<String, Integer> userTotalPoints = new TreeMap<>();

        while (!input.equals("end of contests")) {
            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            contestPassword.put(contest, password);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("end of submissions")) {
            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String username = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);
            if (contestPassword.containsKey(contest)) {
                String pass = contestPassword.get(contest);
                if (pass.equals(password)) {
                    putUserPoints(userPoints, userContests, username, points, contest);
                    putUserContests(userContests, username, contest);

                }
            }

            input = scanner.nextLine();
        }


        putUserTotalPoints(userTotalPoints, userPoints);
        List<String> bestUser = userTotalPoints.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1).map(entry -> entry.getKey()).collect(Collectors.toList());

        int firstValue = userTotalPoints.get(bestUser.get(0));
        System.out.printf("Best candidate is %s with total %d points.%n", bestUser.get(0), firstValue);
        sortContestByPoints(userContests, userPoints);
        System.out.println("Ranking: ");

        for (Map.Entry<String, List<String>> entry : userContests.entrySet()) {
            System.out.println(entry.getKey());
            List<Integer> points = userPoints.get(entry.getKey());
            List<String> contents = entry.getValue();
            for (int i = 0; i < contents.size(); i++) {
                System.out.printf("#  %s -> %d%n", contents.get(i), points.get(i));
            }

        }

    }


    public static void putUserContests(Map<String, List<String>> userContests, String username, String contest) {
        if (!userContests.containsKey(username)) {
            userContests.put(username, new ArrayList<>());
        }
        if (!userContests.get(username).contains(contest)) {
            userContests.get(username).add(contest);
        }

    }

    public static void putUserPoints(Map<String, List<Integer>> userPoints, Map<String, List<String>> userContests,
                                     String username, int points, String contest) {
        List<Integer> currentPoints = userPoints.get(username);
        List<String> currentContests = userContests.get(username);

        if (userPoints.containsKey(username) && currentContests.contains(contest)) {
            int contestIndex = 0;
            for (int i = 0; i < currentContests.size(); i++) {
                if (currentContests.get(i).equals(contest)) {
                    contestIndex = i;
                    break;
                }
            }

            if (currentPoints.get(contestIndex) < points) {
                currentPoints.set(contestIndex, points);
                userPoints.put(username, currentPoints);
            }
        } else if (userPoints.containsKey(username) && !currentContests.contains(contest)) {
            userPoints.get(username).add(points);
        } else if (!userPoints.containsKey(username)) {
            userPoints.put(username, new ArrayList<>());
            userPoints.get(username).add(points);
        }
    }

    public static void putUserTotalPoints(Map<String, Integer> userTotalPoints, Map<String, List<Integer>> userPoints) {
        for (Map.Entry<String, List<Integer>> entry : userPoints.entrySet()) {
            String username = entry.getKey();
            List<Integer> points = entry.getValue();
            int totalPoints = 0;
            for (Integer currentPoints : points) {
                totalPoints += currentPoints;
            }
            userTotalPoints.put(username, totalPoints);
        }


    }

    public static void sortContestByPoints(Map<String, List<String>> userContests, Map<String, List<Integer>> userPoints) {
        for (Map.Entry<String, List<String>> entry : userContests.entrySet()) {
            String username = entry.getKey();
            List<String> contests = entry.getValue();
            List<Integer> points = userPoints.get(username);
            List<Integer> copyPoints = new ArrayList<>();
            List<String> copyContests = new ArrayList<>();
            for (Integer point : points) {
                copyPoints.add(point);
            }
            for (String contest : contests) {
                copyContests.add(contest);
            }
            Collections.sort(points);
            Collections.reverse(points);
            for (int i = 0; i < points.size(); i++) {
                for (int k = 0; k < copyPoints.size(); k++) {
                    if (points.get(i) == copyPoints.get(k)) {
                        String currentContest = copyContests.get(k);
                        contests.add(i, currentContest);
                        contests.remove(contests.size() - 1);
                    }
                }
            }
        }
    }
}
