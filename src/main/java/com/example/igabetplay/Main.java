package com.example.igabetplay;


import java.util.Scanner;

import models.MatchManagment;
import models.Menu;
import models.Player;
import models.PlayerManagment;
import models.Person;
import models.Team;
import models.TeamManagment;
import models.TeamInformation;

public class Main {
    public static void main(String[] args) {
        // Instaciacion unica de todas las clases.
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        Player player = new Player(null, 0, 0, 0, null, null, 0, 0, 0);
        PlayerManagment playerManagment = new PlayerManagment();
        Person staff = new Person(null, 0, 0, null);
        Team team = new Team(null);
        TeamInformation teamInformation = new TeamInformation();
        TeamManagment teamManagment = new TeamManagment();
        MatchManagment matchManagment = new MatchManagment();
        menu.mainMenu(input, player, staff, team, teamInformation, teamManagment, playerManagment, matchManagment);
    }

}