package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerManagment {
    ArrayList<Player> players;
    String[] positions;

    public PlayerManagment() {
        this.players = new ArrayList<Player>();
        this.positions = new String[]{"Portero", "Defensa", "Mediocampista", "Delantero"};
    }

    public Player registerPlayer(Scanner input) {
        System.out.print("Ingrese la identificación: ");
        int id = input.nextInt();
        input.nextLine(); 
        System.out.print("Ingrese nombre completo del Jugador: ");
        String name = input.nextLine();
        System.out.print("Ingrese edad del jugador: ");
        int age = input.nextInt();
        input.nextLine(); 
        System.out.print("Ingrese número de dorsal: ");
        int dorsal = input.nextInt();
        input.nextLine(); 
        System.out.println("Seleccione la posición de juego: \n");
        gamePositions();
        int positionIndex = input.nextInt() - 1;
        if (positionIndex < 0 || positionIndex >= this.positions.length) {
            System.out.println("Índice de posición inválido.");
            return null;
        }
        String position = this.positions[positionIndex];
        input.nextLine(); 
        System.out.print("Ingrese fecha de admisión en formato yyyy-mm-dd: ");
        String inputDate = input.nextLine();
        LocalDate admissionDate = LocalDate.parse(inputDate);
        int scoredGoals = 0;
        int yellowCards = 0;
        int redCards = 0;
        Player newPlayer = new Player(name, age, id, dorsal, position, admissionDate, scoredGoals, yellowCards, redCards);
        this.players.add(newPlayer);
        System.out.println("Se registró correctamente al jugador: " + name + " con dorsal: " + dorsal + " y posición: " + position);
        return newPlayer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void gamePositions() {
        int i = 1;
        for (String position : this.positions) {
            System.out.println(String.format("%d. %s.", i, position));
            i++;
        }
    }

    public void showPlayers(boolean onlyUntaken) {
        this.players.forEach(player -> {
            if (!onlyUntaken || !player.isTaken()) {
                System.out.println(String.format("Nombre: %s   Dorsal: %d  Posicion: %s", player.name, player.dorsal, player.position));
            }
        });
    }

    public void removePlayer(Player player) {
        if (player.isTaken()) {
            System.out.println("No se puede remover al jugador ya que se encuentra activo en un equipo");
        } else {
            this.players.remove(player);
            System.out.println("Se removió correctamente al jugador: " + player.name);
        }
    }

    public void editPlayer(Scanner input, Player player) {
        while (true) {
            System.out.println("Editar jugador: " + player.name);
            System.out.println("1. Nombre\n2. Edad\n3. Dorsal\n4. Posición\n5. Fecha de admisión\n6. Goles anotados\n7. Tarjetas amarillas\n8. Tarjetas rojas\n0. Regresar");
            System.out.print("Seleccione una opción: ");
            
            int option = input.nextInt();
            input.nextLine(); 
            switch (option) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    player.name = input.nextLine();
                    break;
                case 2:
                    System.out.print("Ingrese la nueva edad: ");
                    player.age = input.nextInt();
                    input.nextLine(); 
                    break;
                case 3:
                    System.out.print("Ingrese el nuevo dorsal: ");
                    player.dorsal = input.nextInt();
                    input.nextLine(); 
                    break;
                case 4:
                    System.out.print("Seleccione la nueva posición: ");
                    gamePositions();
                    int positionIndex = input.nextInt() - 1;
                    if (positionIndex >= 0 && positionIndex < this.positions.length) {
                        player.position = this.positions[positionIndex];
                    } else {
                        System.out.println("Índice de posición inválido.");
                    }
                    input.nextLine(); 
                    break;
                case 5:
                    System.out.print("Ingrese la nueva fecha de admisión (yyyy-mm-dd): ");
                    String date = input.nextLine();
                    player.admissionDate = LocalDate.parse(date);
                    break;
                case 6:
                    System.out.print("Ingrese la nueva cantidad de goles anotados: ");
                    player.scoredGoals = input.nextInt();
                    input.nextLine(); 
                    break;
                case 7:
                    System.out.print("Ingrese la nueva cantidad de tarjetas amarillas: ");
                    player.yellowCards = input.nextInt();
                    input.nextLine(); 
                    break;
                case 8:
                    System.out.print("Ingrese la nueva cantidad de tarjetas rojas: ");
                    player.redCards = input.nextInt();
                    input.nextLine(); 
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
