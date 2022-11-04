import java.util.List;
import java.util.Scanner;

public class View {
    private final static Scanner scanner = new Scanner(System.in);

    public void printNight(){
        System.out.println("Night becomes");
        System.out.println("All Citizens sleeping now");
    }
    private void deadProcesor(List<Player> players,List<Player> dead){
        for (int i = 0; i < players.size();i++){
            if (!players.get(i).isAlive()){
                dead.add(players.get(i));
                players.remove(players.get(i));
            }
        }
    }
    public void printDay(List<Player> players,List<Player> dead){
        System.out.println("Day becomes");
        System.out.println("All Citizens awaking now,but is everybody still alive?");
        deadProcesor(players,dead);
        System.out.println("Today Dead List:");
        printAllDead(dead);
        System.out.println("Today still alive: ");
        printAllAlive(players);
        System.out.println("[][][]_________ITS TIME TO LINCH_____________[][][]");
        dead.clear();
    }
    public int linching(List<Player> players){
        System.out.println("))))))))---Choose victim---(((((((((");
        printAll(players,100);
        int user = makeChoose();
        return user;
    }
    public int makeChoose(){

        return scanner.nextInt();
    }
    public String makeChoose(String c){
        return scanner.next();
    }
    public void printAllDead(List<Player> dead){
        System.out.println("*****************DEAD LIST*********************");
        for (int i = 0;i < dead.size();i++){

            System.out.println("** Dead - [" + dead.get(i).getName() + "]");
            System.out.println("** Death because ["+dead.get(i).getInfo() + "]" );
            System.out.println("** Role was: [" + dead.get(i).getRole() + "]");
            System.out.println("===================================");

        }
    }
    public void printAllAlive(List<Player> players){
        System.out.println("*****************ALIVE LIST*********************");
        for (int i = 0;i < players.size();i++) {
            System.out.println(  players.get(i).getIndex() + ") ------ " + "[" +players.get(i).getName()+ "]");
            System.out.println("** Status: [" + players.get(i).getInfo()+ "]");
            System.out.println("===================================");
        }
    }
    public void printAll(List<Player> players,int id){

        for (int i = 0;i < players.size();i++) {
            if (players.get(i).getIndex() == id){
                continue;
            }
            System.out.println(players.get(i).getIndex() + ") - " + players.get(i).getName());

        }
    }


}
