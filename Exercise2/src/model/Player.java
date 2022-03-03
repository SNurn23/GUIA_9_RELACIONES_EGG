package model;

public class Player {

    private Integer id;
    private String name;
    private boolean bWet;

    public Player(int id, String name, boolean bWet) {
        this.id = id;
        this.name = name;
        this.bWet = bWet;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isbWet() {
        return bWet;
    }

    public void setbWet(boolean bWet) {
        this.bWet = bWet;
    }

    @Override
    public String toString() {
        return String.format("Player: %s, Wet? %s\n",name,bWet) ;
    }

}
