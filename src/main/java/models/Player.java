package models;

import java.time.LocalDate;

public class Player extends Person {
    int dorsal;
    String position;
    LocalDate admissionDate;
    int scoredGoals;
    int yellowCards;
    int redCards;
    boolean taken;
    public Player(String name, int age, int id, int dorsal, String position, LocalDate admissionDate,
            int scoredGoals, int yellowCards, int redCards) {
        super(name, age, id, "Jugador");
        this.dorsal = dorsal;
        this.position = position;
        this.admissionDate = admissionDate;
        this.scoredGoals = scoredGoals;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.taken = false;
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }
    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
    public int getScoredGoals() {
        return scoredGoals;
    }
    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }
    public int getYellowCards() {
        return yellowCards;
    }
    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }
    public int getRedCards() {
        return redCards;
    }
    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
    public boolean isTaken() {
        return taken;
    }
    public void setTaken(boolean taken) {
        this.taken = taken;
    }
    public void incrementYellowCards() {
        this.yellowCards += 1;
    }

    public void incrementRedCards() {
        this.redCards += 1;
    }

}
