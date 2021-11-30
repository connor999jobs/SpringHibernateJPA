package com.example.springhibernatejpa.controller;

import com.example.springhibernatejpa.Dao.TeamService;
import com.example.springhibernatejpa.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/team/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView("add-team-form");
        modelAndView.addObject("team", new Team());
        return modelAndView;
    }


    @RequestMapping(value = "/team/add/process")
    public ModelAndView addTeam(@ModelAttribute Team team){

        ModelAndView modelAndView = new ModelAndView("home");
        teamService.addTeam(team);

        String message = "Team was successfully added. ";
        modelAndView.addObject("message", message);

        return modelAndView;
    }


    @RequestMapping(value = "/team/list")
    public ModelAndView listOfTeam(){
        ModelAndView modelAndView = new ModelAndView("list-of-team");
        List teams = teamService.getTeams();
        modelAndView.addObject("teams", teams);
        return modelAndView;
    }


    @RequestMapping(value="/team/edit/{id}", method= RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-team-form");
        Team team = teamService.getTeam(id);
        modelAndView.addObject("team",team);
        return modelAndView;
    }


    @RequestMapping(value = "/team/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edditingTeam(@ModelAttribute Team team, @PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("home");
        teamService.updateTeam(team);
        String message = "Team was successfully changed";
        modelAndView.addObject("message", message);
        return modelAndView;
    }


    @RequestMapping(value = "/team/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("home");
        teamService.deleteTeam(id);
        String message = "Team was successfully delete";
        modelAndView.addObject("message", message);
        return  modelAndView;
    }

}
