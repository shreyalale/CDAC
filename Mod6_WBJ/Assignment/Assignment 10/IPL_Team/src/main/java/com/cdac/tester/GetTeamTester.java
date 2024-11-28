//package com.cdac.tester;
//
//import com.cdac.dao.TeamDAO;
//import com.cdac.dao.TeamDAOImpl;
//import com.cdac.pojos.Team;
//
//public class GetTeamTester {
// public static void main(String[] args) {
//	TeamDAO teamDAO = new TeamDAOImpl();
//	Team team = teamDAO.getTeamById(1L);
//	if(team != null) {
//		System.out.println("Team Details: ");
//		System.out.println("Name: " +team.getName());
//		System.out.println("Owner: " +team.getOwner());
//	} else {
//			System.out.println("Team not found!");
//		}
//	}
//}
//
package com.cdac.tester;

import com.cdac.dao.TeamDAO;
import com.cdac.dao.TeamDAOImpl;
import com.cdac.pojos.Team;

public class GetTeamTester {
    public static void main(String[] args) {
        TeamDAO teamDAO = new TeamDAOImpl();

        // Fetching team details by ID
        Long teamId = 1L;  // Replace with the desired ID
        Team team = teamDAO.getTeamById(teamId);

        if (team != null) {
            System.out.println("Team Details:");
            System.out.println("ID: " + team.getId());
            System.out.println("Name: " + team.getName());
            System.out.println("Abbreviation: " + team.getAbbreviation());
            System.out.println("Owner: " + team.getOwner());
            System.out.println("Max Age: " + team.getMaxAge());
            System.out.println("Batting Avg: " + team.getBattingAvg());
            System.out.println("Wickets Taken: " + team.getWicketsTaken());
        } else {
            System.out.println("Team not found!");
        }
    }
}

