package com.example.springhibernatejpa.Dao;

import com.example.springhibernatejpa.model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDAOImpl implements TeamDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addTeam(Team team) {
        getCurrentSession().save(team);
    }

    @Override
    public void updateTeam(Team team) {
        Team teamToUpdate = getTeam(team.getId());
        teamToUpdate.setName(team.getName());
        teamToUpdate.setRating(team.getRating());
        getCurrentSession().update(teamToUpdate);
    }

    @Override
    public Team getTeam(int id) {
        Team team = (Team) getCurrentSession().get(Team.class, id);
        return team;
    }

    @Override
    public void deleteTeam(int id) {
        Team team = getTeam(id);
        if (team != null)
            getCurrentSession().delete(team);

    }

   @SuppressWarnings("unchecked")
    public List getTeams() {
        return getCurrentSession().createQuery("from  Team ").list();
    }
}
