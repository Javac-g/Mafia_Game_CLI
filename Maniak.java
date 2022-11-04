import java.util.List;
import java.util.Random;

public class Maniak implements Evil , Curable,Player{
    private String name ,role,info ;
    private boolean isAlive,immunity;
    private int index;
    View view = new View();


    public Maniak() {
        this.info = "Good Health";
        this.role = "Maniac";
        this.isAlive = true;
        this.index = 4;
        System.out.println("Maniak in game");
    }



    private void process(List<Player> players, List<Player> dead){
        int sex = view.makeChoose();
        for (int i = 0; i < players.size();i++){
            if (players.get(i).getIndex() == sex){
                kill(players.get(i));
//                dead.add(players.get(i));

                System.out.println("Maniac foun some fresh meat");
            };
        }
        System.out.println("Maniac fall asleep");

    }
    public void move(List<Player> players,List<Player> dead){

        System.out.println("Maniac crazy tonight");

        System.out.println("Type victim for today");
        view.printAll(players,4);
        process(players,dead);



    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void kill(Player player){
        player.setAlive(false);
        player.setInfo("Was stabbed by Maniac");
        System.out.println("Maniac is   killing someone");
    }
    public int linch(List<Player> players){
        Random random = new Random();

        int c =  random.nextInt(players.size());
        return players.get(c).getIndex();
    }

    public String getName() {
        return name;
    }

    public boolean isImmunity() {
        return immunity;
    }

    @Override
    public void setImmunity(boolean immunity) {
        this.immunity = immunity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
