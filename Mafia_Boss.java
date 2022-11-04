import java.util.List;
import java.util.Random;

public class Mafia_Boss implements Evil , Curable,Player{
    private String name ,role,info ;
    private boolean isAlive,immunity;
    private int index;
    View view = new View();

    @Override
    public boolean isImmunity() {
        return immunity;
    }

    public Mafia_Boss() {
        this.info = "Good Health";
        this.role = "Mafia Boss";
        this.isAlive = true;
        this.index = 8;
        System.out.println("Mafia boss in game");
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private void kill(Player player){
        player.setAlive(false);
        player.setInfo(" shooted by Mafia");
        System.out.println("Mafia is going to shoot someone");
    }
    public boolean getImmunity() {
        return immunity;
    }
    public int linch(List<Player> players){
        Random random = new Random();
        return random.nextInt(players.size());
    }
    public void move(List<Player> players,List<Player> dead){
        System.out.println("Mafia awaking");
        System.out.println("Mafia choose the victim:");
        view.printAll(players,8);
        System.out.println("Type victim id:");
        int victim = view.makeChoose();
        for (int i = 0; i < players.size();i++){
            if (players.get(i).getIndex() == victim){
                kill(players.get(i));
                System.out.println("Mafia Shooted victim");
            };
        }

        System.out.println("Mafia sleeping");

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
