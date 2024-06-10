package models;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamManagment {
    private ArrayList<Team> teams;

    public TeamManagment() {
        this.teams = new ArrayList<Team>();
    }

    public ArrayList<Team> getTeams() {
        return this.teams;
    }

    public Team getTeam(int teamIndex) {
        return teams.get(teamIndex);
    }

    public Team createTeam(String name) {
        Team newTeam = new Team(name);
        this.teams.add(newTeam);
        System.out.println("Se creó el equipo bajo el nombre: " + name);
        return newTeam;
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public void removeTeam(Team team) {
        this.teams.remove(team);
        System.out.println("Se removió el equipo: " + team.name);
    }

    public Team searchTeam(String name) {
        for (Team team : teams) {
            if (team.name.equalsIgnoreCase(name)) {
                return team;
            }
        }
        System.out.println("Equipo: " + name + " no está registrado.");
        return null;
    }

    public void listTeams() {
        if (teams.isEmpty()) {
            System.out.println("No hay equipos registrados.");
        } else {
            System.out.println("Listado de equipos:");
            int i = 1;
            for (Team equipo : teams) {
                System.out.println(i + ". " + equipo.name);
                i++;
            }
        }
    }

    public void editPanel(Scanner input, ArrayList<Player> plantel, Team team, PlayerManagment playerManagment) {
        while (true) {
            System.out.println("Plantel del equipo: " + team.name);
            System.out.println("1. Añadir jugador al plantel.\n2. Eliminar jugador del plantel.\n0. Regresar.");
            int option = input.nextInt();
            input.nextLine(); 

            switch (option) {
                case 1:
                    System.out.println("Seleccione el jugador que desea añadir:");
                    playerManagment.showPlayers(true);
                    int addPlayerIndex = input.nextInt() - 1;
                    Player addPlayer = playerManagment.getPlayers().get(addPlayerIndex);
                    team.players.add(addPlayer);
                    System.out.println(String.format("Se añadió al jugador %s al plantel del equipo %s", addPlayer.name, team.name));
                    break;
                case 2:
                    System.out.println("Seleccione el jugador que desea eliminar del plantel.");
                    playerManagment.showPlayers(false);
                    int removePlayerIndex = input.nextInt() - 1;
                    Player removePlayer = team.players.get(removePlayerIndex);
                    System.out.println("Se removió el jugador " + removePlayer.name);
                    team.players.remove(removePlayer);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("¡Opción incorrecta!");
                    break;
            }
        }
    }

    public void editTeam(Scanner input, Team team, PlayerManagment playerManagment) {
        while (true) {
            System.out.println("SISTEMA EDITOR DE EQUIPOS");
            System.out.println("Equipo seleccionado: " + team.name);
            System.out.println("1. Modificar nombre\n2. Modificar plantel\n3. Modificar personal\n4. Regresar.\n");
            switch (input.nextInt()) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre:");
                    input.nextLine(); 
                    team.name = input.nextLine();
                    System.out.println("Se modificó el nombre a: " + team.name);
                    break;
                case 2:
                    editPanel(input, team.players, team, playerManagment);
                    break;
                case 3:
                    // lógica para modificar el personal del equipo
                    break;
                case 4:
                    return;
                default:
                    System.out.println("¡Opción incorrecta!");
                    break;
            }
        }
    }
}
