import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Commissar implements Good , Curable,Player {
    private String name,role,info ;
    private boolean isAlive,immunity;
    private int index;
    View view = new View();
    private final static Scanner g = new Scanner(System.in);

    public Commissar() {
        this.info = "Good Health";
        this.index = 3;
        this.isAlive = true;
        this.role = "Commissar";
        System.out.println("Commissar created");
    }
    private void investigate(List<Player> players){
        System.out.println("Enter id to investigate:");
        view.printAll(players,3);
        processI(players);

    }
    private void processI(List<Player> players){
        int id = view.makeChoose();
        for (int i = 0; i < players.size();i++){
            if (players.get(i).getIndex() ==id){
                players.get(i).setInfo(" was Investigated by commissar");
                System.out.println(players.get(i).getName() + " : " + players.get(i).getRole());
            };
        }

    }
    private void processK(List<Player> players,List<Player> dead){

        int id = view.makeChoose();
        for (int i = 0; i < players.size();i++){
            if (players.get(i).getIndex() ==id){
                kill(players.get(i));
                System.out.println("Commissar shouted * * * * * * *");
            };
        }

    }

    private void killPlayers(List<Player> players,List<Player> dead){
        System.out.println("Enter id to kill:");
        view.printAll(players,3);
        processK(players,dead);

    }
    public void move(List<Player> players,List<Player> dead){

        System.out.println("Commissar awaken tonight");

        System.out.println("!!!! to investigate or **** to kill");
        String choose = g.next();
        switch (choose){
            case "!!!!":
                investigate(players);
                break;
            case "****":
                killPlayers(players,dead);
        }

        System.out.println("Commisar fall asleep");


    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int linch(List<Player> players){
        Random random = new Random();

        int c =  random.nextInt(players.size());
        return players.get(c).getIndex();
    }
    public boolean isImmunity() {
        return immunity;
    }
    public void investigate(Player player){
        System.out.println("Commissar is going to investigate someone");
        System.out.println("Player role is: " + player.getRole());
    }
    public void  kill(Player player){
        System.out.println("Commissar defended himself,and kill someone");
        player.setInfo(" shooted by Commissar");
        player.setAlive(false);
    }

    public void setImmunity(boolean immunity) {
        this.immunity = immunity;
    }

    public String getName() {
        return name;
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
