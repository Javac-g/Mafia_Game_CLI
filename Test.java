import java.util.*;

public class Test {
    static List<Player> players =  new ArrayList<>();
    static Map<Integer,Integer> result = new HashMap<>();
    static Player getPlay(Integer max){
        for (Map.Entry<Integer, Integer> value: result.entrySet()){
            if (value.getKey().equals(max)){

                int index = value.getKey();;
                for (Player x :players){
                    if (x.getIndex() == value.getKey()){
                        System.out.println("Most votes Number " + value.getKey()+x.getName()+ " : " + + value.getValue() );
                        return x;
                    }
                }


            }
        }
        return null;
    }
    public static void main(String...args){

        players.add(new Commissar());
        players.add(new Doctor());
        players.add(new Whore());
        players.add(new Citizen(7));
        players.add(new Mafia_A());
        players.add(new Mafia_B());
        players.add(new Mafia_Boss());
        players.add(new Maniak());

        int[] possible = new int[10];
        int[] vote = {1,1,1,2,2,3,3,3,3,4,4,4,4,4,4};



        for (int x : vote) {
            System.out.println(possible[x]);
            possible[x] = possible[x] + 1;
            result.put(x, possible[x]);
        }

//        int index = Collections.max(result.values());
        Integer max = Collections.max(result.keySet());
        getPlay(max);

        System.out.println(result);
        System.out.println("Max votes: "+result.keySet());

    }
}
