package za.ac.cput.rugbyTeamProfiles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.rugbyTeamProfiles.domain.PlayerProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamsLogRanking;
import za.ac.cput.rugbyTeamProfiles.services.LogRankingServices;

import java.util.List;


/**
 * Created by student on 2015/04/18.
 */
@RestController
@RequestMapping("/Ranking/**")
public class ViewProfile {

    @Autowired
    LogRankingServices services;

    @RequestMapping(value="/teams", method= RequestMethod.GET)
    List<TeamsLogRanking> getTeams(){
        return services.getAllTeams();
    }
    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
    public TeamProfile getTeam(@PathVariable Long id){
        return services.getTeam(id);
    }
    @RequestMapping(value="/players/{id}", method= RequestMethod.GET)
    public List<PlayerProfile> getPlayers(@PathVariable Long id){
        return services.getPlayers(id);
    }
    @RequestMapping(value = "/player/{id}/{p}/",method = RequestMethod.GET)
    public PlayerProfile getPlayer(@PathVariable Long id,@PathVariable Integer p){
        return services.getPlayers(id).get(p.intValue()-1);
    }


}
