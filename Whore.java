import java.util.List;
import java.util.Random;

public class Whore implements Curable, Good,Player {
    private String name,role,info  ;
    private boolean isAlive,immunity;
    private int index;
    View view = new View();
    public Whore() {
        this.info = "Good Health";
        this.index = 1;
        this.isAlive = true;
        this.role = "Whore";
        System.out.println("Whore in game");
    }
    private void process(List<Player> players){
        int sex = view.makeChoose();
        for (int i = 0; i < players.size();i++){
            if (players.get(i).getIndex() == sex){
                getSomeSex(players.get(i));
                System.out.println("Whore was too fucked  tonight");
            };
        }
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void move(List<Player> players,List<Player> dead){
        System.out.println("Whore wear her best clothes and looking for sex tonight");
        System.out.println("Type sex victim for today");
        view.printAll(players,1);
        process(players);
        System.out.println("Whore fall asleep");


    }
    public void getSomeSex(Player player){
        player.setImmunity(true);
        player.setInfo(" Fucked by whore all night");
        System.out.println("Whore found some sex tonight");
    }
    public int linch(List<Player> players){
        Random random = new Random();

        int c =  random.nextInt(players.size());
        return players.get(c).getIndex();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
