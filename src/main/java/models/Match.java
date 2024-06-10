package models;

import java.time.LocalDate;

public class Match {
    String matchName;
    LocalDate date;
    Team foreignTeam;
    Team localTeam;
    int localScore;
    int foreignScore;
    Team winnerTeam;
    boolean draw;
    String comments;

    
    public Match(String matchName, LocalDate date, Team foreignTeam, Team localTeam, int localScore, int foreignScore,
            Team winnerTeam, boolean draw, String comments) {
        this.matchName = matchName;
        this.date = date;
        this.foreignTeam = foreignTeam;
        this.localTeam = localTeam;
        this.localScore = localScore;
        this.foreignScore = foreignScore;
        this.winnerTeam = winnerTeam;
        this.draw = draw;
        this.comments = comments;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Team getLocalTeam() {
        return localTeam;
    }
    public void setLocalTeam(Team localTeam) {
        this.localTeam = localTeam;
    }
    public Team getForeignTeam() {
        return foreignTeam;
    }
    public void setForeignTeam(Team foreignTeam) {
        this.foreignTeam = foreignTeam;
    }
    public String getMatchName() {
        return matchName;
    }
    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }
    public int getLocalScore() {
        return localScore;
    }
    public void setLocalScore(int localScore) {
        this.localScore = localScore;
    }
    public int getForeignScore() {
        return foreignScore;
    }
    public void setForeignScore(int foreignScore) {
        this.foreignScore = foreignScore;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public void setWinnerTeam(Team winnerTeam) {
        this.winnerTeam = winnerTeam;
    }
    
}
