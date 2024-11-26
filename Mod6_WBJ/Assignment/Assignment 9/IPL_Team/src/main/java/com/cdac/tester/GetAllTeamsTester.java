package com.cdac.tester;

import java.util.List;

import com.cdac.dao.TeamDAO;
import com.cdac.dao.TeamDAOImpl;
import com.cdac.pojos.Team;

//public class GetAllTeamsTester {
//    public static void main(String[] args) {
//		TeamDAO teamDAO = new TeamDAOImpl();
//		List<Team> teams = teamDAO.getAllTeams();
//		System.out.println("List of Teams: ");
//		for(Team team: teams) {
//			System.out.println("Name: " +team.getName() +", Owner: " +team.getOwner());
//		}
//	}
//}


public class GetAllTeamsTester {
    public static void main(String[] args) {
        TeamDAO teamDAO = new TeamDAOImpl();

        // Fetching all teams from the database
        List<Team> teams = teamDAO.getAllTeams();

        System.out.println("List of Teams:");
        for (Team team : teams) {
            System.out.println("-------------------------------");
            System.out.println("ID: " + team.getId());
            System.out.println("Name: " + team.getName());
            System.out.println("Abbreviation: " + team.getAbbreviation());
            System.out.println("Owner: " + team.getOwner());
            System.out.println("Max Age: " + team.getMaxAge());
            System.out.println("Batting Avg: " + team.getBattingAvg());
            System.out.println("Wickets Taken: " + team.getWicketsTaken());
        }
    }
}
