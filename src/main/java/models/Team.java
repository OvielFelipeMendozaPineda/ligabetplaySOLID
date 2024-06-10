package models;

import java.util.ArrayList;

public class Team {
    public String name;
    public int PJ;
    public int PG;
    public int PP;
    public int PE;
    public int GF;
    public int GC;
    public int TP;
    ArrayList<Player> players;
    ArrayList<Person> staff;
    public Team(String name) {
        this.name = name;
        this.PJ = 0;
        this.PG = 0;
        this.PP = 0;
        this.PE = 0;
        this.GF = 0;
        this.GC = 0;
        this.TP = 0;
        this.players = new ArrayList<Player>();
        this.staff = new ArrayList<Person>();
    }
}
