package com.cdac.tester;

import com.cdac.dao.TeamDAO;
import com.cdac.dao.TeamDAOImpl;
import com.cdac.pojos.Team;

import java.util.List;
import java.util.Scanner;

public class FindTeamsByCriteriaTester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TeamDAO dao = new TeamDAOImpl();

		try {
			// Taking user input for batting average and max age
			System.out.println("Enter minimum batting average:");
			double battingAvg = sc.nextDouble();

			System.out.println("Enter maximum age: ");
			int maxAge = sc.nextInt();

			// Calling the DAO method to find teams by criteria
			List<Team> teams = dao.findTeamsByCriteria(battingAvg, maxAge);

			// Display the found teams
			if (teams.isEmpty()) {
				System.out.println("No teams found matching the criteria.");
			} else {
				teams.forEach(System.out::println);
			}
		} catch (Exception e) {
			System.err.println("Error occurred while fetching teams: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}
