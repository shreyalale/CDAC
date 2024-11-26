package com.cdac.dao;

import com.cdac.pojos.Team;
import java.util.List;

public interface TeamDAO {
   void addTeam(Team team);
   Team getTeamById(Long id);
   List<Team> getAllTeams();
}
