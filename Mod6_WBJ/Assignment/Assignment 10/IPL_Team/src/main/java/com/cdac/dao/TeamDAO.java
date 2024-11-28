package com.cdac.dao;

import com.cdac.pojos.Team;
import java.util.List;

public interface TeamDAO {
   void addTeam(Team team);
   Team getTeamById(Long id);
   List<Team> getAllTeams();
   
   List<Team> findTeamsByCriteria(double battingAvg, int maxAge);
   List<Object[]> getAllTeamDetails();
   int updateMaxAge(String teamName, int newAge);
   int deleteTeamByAbbreviation(String abbreviation);
}
