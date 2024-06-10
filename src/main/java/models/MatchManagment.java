package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MatchManagment {
    ArrayList<Match> matches;

    public MatchManagment() {
        this.matches = new ArrayList<Match>();
    }

    public void assignGoal(Scanner input, Team team) {
        while (true) {
            System.out.println("Seleccione qué jugador marcó gol:");
            team.players.forEach(player -> System.out.println(String.format("Jugador: %s", player.name)));
            Player goalPlayer = team.players.get(input.nextInt() - 1);
            System.out.println("Ingrese la cantidad de goles para " + goalPlayer.name + ":");
            goalPlayer.scoredGoals += input.nextInt();
            System.out.println("¿Desea agregar más goles para otro jugador? 1. Sí. 2. No.");
            if (input.nextInt() != 1) {
                break;
            }
        }
    }

    public void assignCards(Scanner input, ArrayList<Team> teams, PlayerStat stat, int cardType) {
        if (teams.isEmpty()) {
            System.out.println("No hay equipos registrados.");
            return;
        }
        String cardTypeName = (cardType == 1) ? "amarillas" : "rojas";
        System.out.println("Seleccione a qué equipo desea asignar tarjetas " + cardTypeName + ".");
        int i = 1;
        for (Team team : teams) {
            System.out.println(i + ". " + team.name);
            i++;
        }
        int teamIndex = input.nextInt() - 1;
        Team selectedTeam = teams.get(teamIndex);

        while (true) {
            System.out.println("Seleccione qué jugador de " + selectedTeam.name + " fue amonestado con tarjeta " + cardTypeName + ".");
            selectedTeam.players.forEach(player -> System.out.println(String.format("Jugador: %s", player.name)));
            Player player = selectedTeam.players.get(input.nextInt() - 1);
            stat.stat(player);
            System.out.println("¿Desea asignar otra tarjeta " + cardTypeName + " a otro jugador? 1. Sí. 2. No.");
            if (input.nextInt() != 1) {
                break;
            }
        }
    }

    public Match createMatch(Scanner input, TeamManagment teamManagment, PlayerManagment playerManagment) {
        LocalDate date = null;
        Team localTeam = null;
        Team foreignTeam = null;
        int localScore = 0;
        int foreignScore = 0;
        String comments = null;
        Team winnerTeam = null;
        boolean draw;
        while (true) {
            System.out.println("Registrar partido");
            System.out.println(
                    "1. Ingresar fecha.\n2. Ingresar equipo local\n3. Ingresar equipo visitante\n4. Goles local.\n5. Goles visitante\n6. Tarjetas amarillas\n7. Tarjetas rojas\n8. Guardar y salir\n0. Cancelar.");
            int opcUser = input.nextInt();
            input.nextLine();
            switch (opcUser) {
                case 1:
                    System.out.print("Ingrese fecha del partido en formato yyyy-mm-dd: ");
                    String userDate = input.nextLine();
                    date = LocalDate.parse(userDate);
                    break;
                case 2:
                    System.out.println("Seleccione el equipo que juega de local:");
                    teamManagment.listTeams();
                    localTeam = teamManagment.getTeam(input.nextInt() - 1);
                    break;
                case 3:
                    System.out.println("Seleccione el equipo visitante:");
                    teamManagment.listTeams();
                    foreignTeam = teamManagment.getTeam(input.nextInt() - 1);
                    break;
                case 4:
                    System.out.println("Ingrese goles del equipo local: " + localTeam.name);
                    localScore = input.nextInt();
                    localTeam.GF = localScore;
                    foreignTeam.GC = localScore;
                    assignGoal(input, localTeam);
                    break;
                case 5:
                    System.out.println("Ingrese los goles del equipo visitante: " + foreignTeam.name);
                    foreignScore = input.nextInt();
                    foreignTeam.GF = foreignScore;
                    localTeam.GC = foreignScore;
                    assignGoal(input, foreignTeam);
                    break;
                case 6:
                    assignCards(input, teamManagment.getTeams(), Player::incrementYellowCards, 1);
                    break;
                case 7:
                    assignCards(input, teamManagment.getTeams(), Player::incrementRedCards, 2);
                    break;
                case 8:
                    input.nextLine();
                    System.out.print("Ingrese comentarios sobre el partido: ");
                    comments = input.nextLine();
                    String matchName = localTeam.name + " vs " + foreignTeam.name;
                    if (localScore == foreignScore) {
                        localTeam.PE += 1;
                        foreignTeam.PE +=1;
                        localTeam.TP += 1;
                        foreignTeam.TP += 1;
                        draw = true;
                    }
                    if (localScore > foreignScore) {
                        localTeam.PG += 1;
                        foreignTeam.PP += 1;
                        localTeam.TP += 3;
                        winnerTeam = localTeam;
                        draw = false;
                    } else {
                        localTeam.PP += 1;
                        foreignTeam.PG += 1;
                        foreignTeam.TP += 3;
                        winnerTeam = foreignTeam;
                        draw = false;
                    }
                    localTeam.PJ +=1 ;
                    foreignTeam.PJ += 1;
                    Match newMatch = new Match(matchName, date, foreignTeam, localTeam, localScore, foreignScore, winnerTeam, draw, comments);
                    this.matches.add(newMatch);
                    return newMatch;
                case 0:
                    return null;
                default:
                    System.out.println("¡Opción incorrecta!");
                    break;
            }
        }
    }
    public void listMatches() {
        this.matches.forEach(match -> {
            System.out.println("Nombre del partido: " + match.matchName);
            System.out.println("Fecha del partido: " + match.date);
            System.out.println("Equipo local: " + match.localTeam.name);
            System.out.println("Equipo visitante: " + match.foreignTeam.name);
            System.out.println("Goles del equipo local: " + match.localScore);
            System.out.println("Goles del equipo visitante: " + match.foreignScore);
            System.out.println("Equipo ganador: " + ((match.winnerTeam != null) ? match.winnerTeam.name : "Empate"));
            System.out.println("Comentarios: " + match.comments);
            System.out.println("--------------------------------------");
        });
    }
    
}
