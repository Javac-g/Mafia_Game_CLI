import java.util.List;
import java.util.Random;

public class Mafia_B implements Evil ,Curable,Player{
    private String name ,role,info;
    private boolean isAlive,immunity;
    private int index;

    public Mafia_B() {
        this.info = "Good Health";
        this.role = "Mafia Member";
        this.isAlive = true;
        this.index = 5;
        System.out.println("Mafia sixes in game");
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
    @Override
    public void move(List<Player> players, List<Player> dead) {
        System.out.println("Mafia sixes doing something");
    }
    public boolean isImmunity() {
        return immunity;
    }

    @Override
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
