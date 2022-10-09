package teamworkProjects;

import java.util.*;

public class Main {
    static class Player implements Comparable<Player>{
        private String name;
        private String teamName;
        private String rank;

        public Player(String name, String teamName, String rank) {
            this.name = name;
            this.teamName = teamName;
            this.rank = rank;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        @Override
        public int compareTo(Player o) {
            return this.getName().compareTo(o.getName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int countTeams=Integer.parseInt(scanner.nextLine());
        List<String>teamNamesList=new ArrayList<>();
        List<Player> players=new ArrayList<>();
        String command= scanner.nextLine();

        while (!command.equals("end of assignment")){
            if(command.contains(">")){
                String[] teamData=command.split("->");
                String member=teamData[0];
                String teamName=teamData[1];
                boolean isExistTeam=false;
                boolean isExistMember=false;
                for(int i=0;i<players.size();i++){
                    if (players.get(i).getTeamName().equals(teamName)) {
                        isExistTeam = true;
                    }
                    if(players.get(i).getName().equals(member)){
                        isExistMember=true;
                    }
                }
                if(!isExistTeam){
                    System.out.printf("Team %s does not exist!%n",teamName);
                }else if(isExistMember){
                    System.out.printf("Member %s cannot join team %s!%n",member,teamName);
                }
                else {
                    Player player=new Player(member,teamName,"member");
                    players.add(player);
                }

            }else {
                String[] teamData=command.split("-");
                String leader=teamData[0];
                String teamName=teamData[1];
                boolean isExistTeam=false;
                boolean isExistLeader=false;
                for(int i=0;i<players.size();i++){
                    if (players.get(i).getTeamName().equals(teamName)) {
                        isExistTeam = true;
                    }
                    if(players.get(i).getName().equals(leader)){
                        isExistLeader=true;
                    }
                }
                if(isExistTeam){
                    System.out.printf("Team %s was already created!%n",teamName);
                }else if(isExistLeader&&!isExistTeam){
                    System.out.printf("%s cannot create another team!%n",leader);
                }
                else {
                    Player player=new Player(leader,teamName,"leader");
                    players.add(player);
                    teamNamesList.add(player.getTeamName());
                    System.out.printf("Team %s has been created by %s!%n",teamName,leader);
                }
            }

            command= scanner.nextLine();
        }

        List<Player>disbandedTeam=new ArrayList<>();
        Map<String, Integer> countRepeatOnTeam=new TreeMap<>();

        for(int i=0;i<teamNamesList.size();i++){
            int countRepeatTeam=0;
            int index=0;
            for(int k=0;k<players.size();k++){
                if(teamNamesList.get(i).equals(players.get(k).getTeamName())){
                    countRepeatTeam++;
                    index=k;
                }
            }
            countRepeatOnTeam.put(teamNamesList.get(i),countRepeatTeam);

            if(countRepeatTeam==1){
                disbandedTeam.add(players.get(index));
                players.remove(index);
            }
        }

        Collections.sort(players);

        List<String>teamNames=new ArrayList<>(countRepeatOnTeam.keySet());
        for(int i=0;i<teamNames.size();i++){
            for(int k=0;k<players.size();k++){
                if(players.get(k).getTeamName().equals(teamNames.get(i))&&players.get(k).getRank().equals("leader")){
                    System.out.println(players.get(k).getTeamName());
                    System.out.println("- "+players.get(k).getName());
                }
            }
            for(int k=0;k<players.size();k++){
                if(players.get(k).getTeamName().equals(teamNames.get(i))&&players.get(k).getRank().equals("member")){
                    System.out.println("-- "+players.get(k).getName());
                }
            }
        }

        Collections.sort(disbandedTeam);
        System.out.println("Teams to disband:");

        for (int i = 0; i < disbandedTeam.size(); i++) {
            System.out.println(disbandedTeam.get(i).getTeamName());
        }
    }
}
