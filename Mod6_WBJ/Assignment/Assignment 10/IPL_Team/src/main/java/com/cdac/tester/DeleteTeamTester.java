package com.cdac.tester;

import com.cdac.dao.TeamDAO;
import com.cdac.dao.TeamDAOImpl;

import java.util.Scanner;

public class DeleteTeamTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TeamDAO dao = new TeamDAOImpl();

        try {
            // Taking user input for team abbreviation
            System.out.println("Enter the team delete:");
            String abbreviation = sc.nextLine();

            // Calling the delete method
            int result = dao.deleteTeamByAbbreviation(abbreviation);

            // Display the result of the delete operation
            System.out.println("Rows deleted: " + result);
        } catch (Exception e) {
            System.err.println("Error occurred while deleting the team: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
