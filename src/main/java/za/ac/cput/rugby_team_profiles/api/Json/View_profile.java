package za.ac.cput.rugby_team_profiles.api.Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.rugby_team_profiles.domain.Player_profile;
import za.ac.cput.rugby_team_profiles.domain.Team_profile;
import za.ac.cput.rugby_team_profiles.domain.Teams_log_ranking;
import za.ac.cput.rugby_team_profiles.services.LogRankingServices;

import java.util.List;


/**
 * Created by student on 2015/04/18.
 */
@RestController
@RequestMapping("/Ranking/**")
public class View_profile {

    @Autowired
    LogRankingServices services;

    @RequestMapping(value="/teams", method= RequestMethod.GET)
    List<Teams_log_ranking> getTeams(){
        return services.getAllTeams();
    }
    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
    public Team_profile getTeam(@PathVariable Long id){
        return services.getTeam(id);
    }
    @RequestMapping(value="/players/{id}", method= RequestMethod.GET)
    public List<Player_profile> getPlayers(@PathVariable Long id){
        return services.getPlayers(id);
    }
    @RequestMapping(value = "/player/{id}/{p}/",method = RequestMethod.GET)
    public Player_profile getPlayer(@PathVariable Long id,@PathVariable Integer p){
        return services.getPlayers(id).get(p.intValue()-1);
    }


}
