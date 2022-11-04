import java.util.List;

public interface Player {
    void setInfo(String str);
    String getInfo();

    void move(List<Player> players,List<Player> dead);
    int linch(List<Player> players);
    void setImmunity(boolean immunity);
    String getRole();
    void setAlive(boolean alive);
    void setName(String name);
    String getName();
    int getIndex();
    boolean isAlive();
    boolean isImmunity();
};
