package com.cdac.tester;

import com.cdac.dao.TeamDAO;
import com.cdac.dao.TeamDAOImpl;
import com.cdac.pojos.Team;

import java.util.Scanner;

public class AddTeamTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TeamDAO teamDAO = new TeamDAOImpl();

        try {
            // Creating a new Team instance
            Team team = new Team();

            // Taking user input for the team details
            System.out.println("Enter Team Name:");
            team.setName(sc.nextLine());

            System.out.println("Enter Team Abbreviation:");
            team.setAbbreviation(sc.nextLine());

            System.out.println("Enter Owner Name:");
            team.setOwner(sc.nextLine());

            System.out.println("Enter Maximum Age of Players:");
            team.setMaxAge(sc.nextInt());

            System.out.println("Enter Batting Average:");
            team.setBattingAvg(sc.nextDouble());

            System.out.println("Enter Wickets Taken:");
            team.setWicketsTaken(sc.nextInt());

            // Adding the team to the database
            teamDAO.addTeam(team);
            System.out.println("Team added successfully!");
        } catch (Exception e) {
            System.err.println("Error occurred while adding the team: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
