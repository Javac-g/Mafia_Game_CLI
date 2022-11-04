import java.util.*;

public class Mechanics {
    List<Player> players = new ArrayList<>();
    List<Good> white = new ArrayList<>();
    List<Evil> black = new ArrayList<>();
    List<Player> dead = new ArrayList<>();
    String[] names = {"Alex","Jhonny B","Robin Bobin","Max","Stikk","Banger","Kate","Malcolm","Allegra"};
    Citizen citizen1;
    Commissar commissar ;
    Doctor doctor;
    Whore whore ;
    Mafia_Boss boss;
    Mafia_B mafia_b;
    Mafia_A mafia_a;
    Maniak maniak;
    View view = new View();

    public Mechanics() {
        citizen1 = new Citizen(7);

        commissar = new Commissar();
        doctor = new Doctor();
        whore = new Whore();
        boss = new Mafia_Boss();
        mafia_b = new Mafia_B();
        mafia_a = new Mafia_A();
        maniak = new Maniak();
        players.add(citizen1);
        players.add(commissar);
        players.add(doctor);
        players.add(whore);
        players.add(boss);
        players.add(mafia_a);
        players.add(mafia_b);
        players.add(maniak);
        white.add(citizen1);
        white.add(whore);
        white.add(doctor);
        white.add(commissar);
        black.add(maniak);
        black.add(mafia_b);
        black.add(mafia_a);
        black.add(boss);

    }
    Map<Integer,Integer> result = new HashMap<>();
//    private final static Scanner scanner = new Scanner(System.in);
    public void start(){


         Collections.shuffle(players);
         for (int i = 0;i < players.size();i++){
             players.get(i).setName(names[i]);
         }
         System.out.println("All roles is distributed");
         System.out.println("Gane begins");


    }



     Player getPlay(Integer max){
        for (Map.Entry<Integer, Integer> value: result.entrySet()){
            if (value.getKey().equals(max)){
                for (Player x :players){
                    if (x.getIndex() == value.getKey()){
                        System.out.println("Most votes Number: " + value.getValue()+"  For person:   "+x.getName()+ " : index: " + + value.getKey() );
                        return x;
                    }
                }


            }
        }
        return null;
    }
    private void day(){
        int[] possible = new int[10];

        view.printDay(players,dead);
        int user_choose = view.linching(players);
        int whore_choose = whore.linch(players);
        int maniak_choose = maniak.linch(players);
        int mafia_boss_choose = boss.linch(players);
        int m_a_choose = mafia_a.linch(players);
        int m_b_choose = mafia_b.linch(players);
        int doctor_choose = doctor.linch(players);
        int commissar_choose = commissar.linch(players);
        int citizen_choose = citizen1.linch(players);
        int[]vote = {user_choose,whore_choose,maniak_choose,mafia_boss_choose,m_a_choose,m_b_choose,doctor_choose,commissar_choose,citizen_choose};

        for (int j : vote) {
            possible[j] = possible[j] + 1;
            result.put(j, possible[j]);
        }
        System.out.println(result);
        Integer max = Collections.max(result.keySet());

        Player x = getPlay(max);
         if(x.isImmunity()) {
             System.out.println(x.getName() + " have immunity for today");
         }
         else if (!x.isImmunity()) {
              System.out.println("Was linched: " + x.getName());
              dead.add(x);
              players.remove(x);

           }
         ;


    }
    private void night(){
        System.out.println("Becomes night, all residens are slepeing");
        for (int i = 0; i < players.size();i++){
            players.get(i).move(players,dead);
        }

    }


    public void game() {
        System.out.println("The game mafia begins");
        System.out.println("Roles will be ordered in a minute");
        start();
        while (true){
            night();
            day();
            if (!whore.isAlive() && !doctor.isAlive() && !commissar.isAlive() && !citizen1.isAlive()){
                System.out.println("Evil win");
                 break;
            }else if (
                    !maniak.isAlive() && !mafia_a.isAlive() && !mafia_b.isAlive() && !boss.isAlive()
            ){
                System.out.println("Good win");
                break;
            }














        }
    }
}
