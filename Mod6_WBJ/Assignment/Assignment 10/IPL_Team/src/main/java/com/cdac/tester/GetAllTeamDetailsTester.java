package com.cdac.tester;

import com.cdac.dao.TeamDAO;
import com.cdac.dao.TeamDAOImpl;

import java.util.List;

public class GetAllTeamDetailsTester {
    public static void main(String[] args) {
        TeamDAO dao = new TeamDAOImpl();
        List<Object[]> teamDetails = dao.getAllTeamDetails();
        for (Object[] detail : teamDetails) {
            System.out.println("Abbreviation: " + detail[0] + ", Owner: " + detail[1] + ", Max Age: " + detail[2]);
        }
    }
}
