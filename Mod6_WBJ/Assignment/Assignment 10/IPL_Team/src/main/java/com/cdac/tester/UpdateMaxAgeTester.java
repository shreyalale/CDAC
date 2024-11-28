package com.cdac.tester;

import com.cdac.dao.TeamDAO;
import com.cdac.dao.TeamDAOImpl;

import java.util.Scanner;

public class UpdateMaxAgeTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TeamDAO dao = new TeamDAOImpl();

        try {
            // Taking user input for the team name and new max age
            System.out.println("Enter the team name to update max age:");
            String teamName = sc.nextLine();

            System.out.println("Enter the new max age for the team:");
            int newMaxAge = sc.nextInt();

            // Calling the DAO method to update the max age for the specified team
            int result = dao.updateMaxAge(teamName, newMaxAge);

            // Displaying the result of the update operation
            if (result > 0) {
                System.out.println("Rows updated: " + result);
            } else {
                System.out.println("No team found with the name: " + teamName);
            }
        } catch (Exception e) {
            System.err.println("Error occurred while updating max age: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
