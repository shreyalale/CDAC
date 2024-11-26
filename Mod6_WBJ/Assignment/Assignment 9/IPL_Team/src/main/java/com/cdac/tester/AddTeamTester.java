package com.cdac.tester;

import com.cdac.dao.TeamDAO;
import com.cdac.dao.TeamDAOImpl;
import com.cdac.pojos.*;

public class AddTeamTester {
	public static void main(String[] args) {
		TeamDAO teamDAO = new TeamDAOImpl();
		Team team = new Team();
		team.setName("DELHI CAPITALS");
		team.setAbbreviation("DC");
		team.setOwner("owner4");
		team.setMaxAge(31);
		team.setBattingAvg(48.5);
		team.setWicketsTaken(12);

		teamDAO.addTeam(team);
		System.out.println("Team added Successfully!!");
	}
}
