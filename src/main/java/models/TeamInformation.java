package models;
import java.util.ArrayList;

public class TeamInformation {

    public TeamInformation() {
        
    }

    public void getTeamStats(ArrayList<Team> teams, TeamMetrics metric, String message) {
        if (teams.isEmpty()) {
            System.out.println("No hay equipos registrados");
            return;
        }

        Team teamMax = teams.get(0);
        int maxMetric = metric.getMetric(teamMax);

        for (Team team : teams) {
            int currentMetric = metric.getMetric(team);
            if (currentMetric > maxMetric) {
                teamMax = team;
                maxMetric = currentMetric;
            }
        }
        System.out.println(message + teamMax.name + " con: " + maxMetric);
    }
    
    
}
