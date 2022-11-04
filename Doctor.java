import java.util.List;
import java.util.Random;

public class Doctor implements Curable , Good,Player{

    private String name ,role,info ;
    private boolean isAlive,immunity;
    private int index;
    View view = new View();

    public Doctor() {
        this.info = "Good Health";
        this.index = 2;
        this.isAlive = true;
        this.role = "Doctor";
        System.out.println("Doctor become");
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void Cure(Player player){
        player.setAlive(true);
        player.setInfo(" Cured by Doctor");
    }
    private void process(List<Player> players){
        int cure = view.makeChoose();
        for (int i = 0; i < players.size();i++){
            if (players.get(i).getIndex() == cure){
                Cure(players.get(i));
                System.out.println("Doctor  done his work ");
            }
        }
    }
    public void move(List<Player> players,List<Player> dead){
        System.out.println("Doctor is going to cure someone");
        System.out.println("Type victim for today");
        view.printAll(players,2);
        process(players);
        System.out.println("Doctor fall asleep");


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
