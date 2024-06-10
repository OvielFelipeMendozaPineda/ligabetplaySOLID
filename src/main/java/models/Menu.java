package models;

import java.util.Scanner;

public class Menu {
    public Menu() {}

    public void mainMenu(Scanner input, Player player, Person staff, Team team, TeamInformation teamInformation, TeamManagment teamManagment, PlayerManagment playerManagment, MatchManagment matchManagment) {
        while (true) {
            System.out.println("SISTEMA GESTOR DE LA LIGA BETPLAY.");
            System.out.println("1. Gestor de equipos.\n2. Gestor de jugadores.\n3. Gestor de partidos.\n0. Salir.");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    teamsMenu(input, team, teamManagment, teamInformation, playerManagment);
                    break;
                case 2:
                    playersMenu(input, playerManagment);
                    break;
                case 3:
                    matchesMenu(input, matchManagment, teamManagment, playerManagment);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

    public static void teamsMenu(Scanner input, Team team, TeamManagment teamManagment, TeamInformation teamInformation, PlayerManagment playerManagment) {
        while (true) {
            System.out.println("Gestor de equipos.");
            System.out.println("1. Crear nuevo equipo.\n2. Editar equipo.\n3. Eliminar equipo.\n4. Listar equipos existentes.\n0. Regresar.\n");
            System.out.print("Seleccione una opción: ");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del equipo.\n");
                    input.nextLine(); // Clear the buffer
                    String teamName = input.nextLine();
                    teamManagment.createTeam(teamName);
                    break;
                case 2:
                    if (teamManagment.getTeams().isEmpty()) {
                        System.out.println("No hay equipos disponibles para editar.");
                        break;
                    }
                    System.out.println("Seleccione el equipo que desea editar.\n");
                    teamManagment.listTeams();
                    int teamIndex = input.nextInt() - 1;
                    if (teamIndex >= 0 && teamIndex < teamManagment.getTeams().size()) {
                        Team editTeam = teamManagment.getTeam(teamIndex);
                        teamManagment.editTeam(input, editTeam, playerManagment);
                    } else {
                        System.out.println("Índice de equipo inválido.");
                    }
                    break;
                case 3:
                    if (teamManagment.getTeams().isEmpty()) {
                        System.out.println("No hay equipos disponibles para eliminar.");
                        break;
                    }
                    System.out.println("Seleccione el equipo que desea eliminar.");
                    teamManagment.listTeams();
                    teamIndex = input.nextInt() - 1;
                    if (teamIndex >= 0 && teamIndex < teamManagment.getTeams().size()) {
                        team = teamManagment.getTeam(teamIndex);
                        teamManagment.removeTeam(team);
                    } else {
                        System.out.println("Índice de equipo inválido.");
                    }
                    break;
                case 4:
                    teamManagment.listTeams();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

    public static void playersMenu(Scanner input, PlayerManagment playerManagment) {
        while (true) {
            System.out.println("Gestor de jugadores.");
            System.out.println("1. Crear nuevo jugador.\n2. Editar jugador.\n3. Eliminar jugador.\n4. Listar jugadores existentes.\n0. Regresar.\n");
            System.out.print("Seleccione una opción: ");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    playerManagment.registerPlayer(input);
                    break;
                case 2:
                    if (playerManagment.getPlayers().isEmpty()) {
                        System.out.println("No hay jugadores disponibles para editar.");
                        break;
                    }
                    System.out.print("Seleccione el jugador que desea editar: ");
                    playerManagment.showPlayers(false);
                    int editPlayerIndex = input.nextInt() - 1;
                    if (editPlayerIndex >= 0 && editPlayerIndex < playerManagment.getPlayers().size()) {
                        Player editPlayer = playerManagment.players.get(editPlayerIndex);
                        playerManagment.editPlayer(input, editPlayer);
                    } else {
                        System.out.println("Índice de jugador inválido.");
                    }
                    break;
                case 3:
                    if (playerManagment.getPlayers().isEmpty()) {
                        System.out.println("No hay jugadores disponibles para eliminar.");
                        break;
                    }
                    System.out.print("Seleccione un jugador para borrar: ");
                    playerManagment.showPlayers(false);
                    int removePlayerIndex = input.nextInt() - 1;
                    if (removePlayerIndex >= 0 && removePlayerIndex < playerManagment.getPlayers().size()) {
                        Player removePlayer = playerManagment.players.get(removePlayerIndex);
                        System.out.println("Se removió al jugador: " + removePlayer.name);
                        playerManagment.removePlayer(removePlayer);
                    } else {
                        System.out.println("Índice de jugador inválido.");
                    }
                    break;
                case 4:
                    playerManagment.showPlayers(false);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

    public static void matchesMenu(Scanner input, MatchManagment matchManagment, TeamManagment teamManagment, PlayerManagment playerManagment) {
        while (true) {
            System.out.println("Gestor de partidos.");
            System.out.println("1. Registrar nuevo partido.\n2. Editar partido.\n3. Eliminar partido.\n4. Listar partidos existentes.\n0. Regresar.\n");
            System.out.print("Seleccione una opción: ");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    matchManagment.createMatch(input, teamManagment, playerManagment);
                    break;
                case 2:
                    // Lógica para editar un partido
                    break;
                case 3:
                    // Lógica para eliminar un partido
                    break;
                case 4:
                    matchManagment.listMatches();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}
