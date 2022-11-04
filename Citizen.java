import java.util.List;
import java.util.Random;

public class Citizen implements Good,Curable,Player{
    private String name ,role,info;
    private boolean isAlive,immunity;
    private int index;

    public Citizen(int index) {
        this.info = "Good Health";
        this.role = "Citizen";
        this.isAlive = true;
        this.index = index;
        System.out.println("Citizens in game");
    }
    public void move(List<Player> players,List<Player> dead){
        System.out.println("Citizens lock all their doors and fall asleep");
    }
    public int linch(List<Player> players){
        Random random = new Random();

        int c =  random.nextInt(players.size());
        return players.get(c).getIndex();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isImmunity() {
        return immunity;
    }

    @Override
    public void setImmunity(boolean immunity) {
        this.immunity = immunity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
