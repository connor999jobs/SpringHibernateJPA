package com.example.springhibernatejpa.Dao;

import com.example.springhibernatejpa.model.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamServiceImpl implements TeamService{
    @Autowired
    public TeamDAO teamDAO;

    @Override
    public void addTeam(Team team) {
        teamDAO.addTeam(team);
    }

    @Override
    public void updateTeam(Team team) {
        teamDAO.updateTeam(team);

    }

    @Override
    public Team getTeam(int id) {
        return teamDAO.getTeam(id);
    }

    @Override
    public void deleteTeam(int id) {
        teamDAO.deleteTeam(id);

    }

    @Override
    public List getTeams() {
        return teamDAO.getTeams();
    }
}
