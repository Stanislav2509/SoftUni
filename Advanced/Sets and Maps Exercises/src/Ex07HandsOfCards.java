import java.util.*;

public class Ex07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        LinkedHashMap<String, Set<String>> player=new LinkedHashMap<>();
        String input =scanner.nextLine();
        while (!input.equals("JOKER")){
            String name= input.split(": ")[0];
            String curCards= input.split(": ")[1];
            player.putIfAbsent(name,new HashSet<>());
            Set<String> cards = player.get(name);
            Collections.addAll(cards,curCards.split(", "));

            input =scanner.nextLine();
        }

        for(var entry:player.entrySet()){
            String name =entry.getKey();
            int points=getTotalPoints(entry.getValue());
            System.out.println(name+": "+ points);
        }
    }

    private static int getTotalPoints(Set<String> cards) {
        int points=0;
        for(String card:cards){
            String power=card.substring(0,card.length()-1);
            String type=card.substring(card.length()-1);
             points+=getPower(power)*getTypePower(type);
        }
        return points;
    }

    private static int getTypePower(String type) {
        int pts=0;
        switch (type){
            case "S":
                pts =4;
                break;
            case "H":
                pts= 3;
                break;
            case "D":
                pts= 2;
                break;
            case "C":
                pts= 1;
                break;
        }
        return pts;
    }

    private static int getPower(String power) {
        int points=0;
        try{
            points=Integer.parseInt(power);
        }catch (Exception e){
            switch (power){
                case "J":
                    points=11;
                    break;
                case "Q":
                    points=12;
                    break;
                case "K":
                    points=13;
                    break;
                case "A":
                    points=14;
                    break;
            }
        }
        return points;

    }
}
