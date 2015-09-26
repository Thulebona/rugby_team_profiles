package za.ac.cput.rugbyTeamProfiles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.rugbyTeamProfiles.domain.PlayerProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamsLogRanking;
import za.ac.cput.rugbyTeamProfiles.repository.TeamProfileRepository;
import za.ac.cput.rugbyTeamProfiles.repository.TeamsLogRankingRepository;
import za.ac.cput.rugbyTeamProfiles.services.LogRankingServices;

import java.util.List;


/**
 * Created by student on 2015/04/18.
 */
@RestController
@RequestMapping("/api/**")
public class ViewProfile {

    @Autowired
    LogRankingServices services;
    TeamProfileRepository repository;
    //-------------------Retrieve All teams--------------------------------------------------------

    @RequestMapping(value="/teams", method= RequestMethod.GET)///get teams
    public ResponseEntity<List<TeamsLogRanking>> getTeams(){
        List<TeamsLogRanking> teams = services.getAllTeams();
        if(teams.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-------------------Retrieve Team Subject--------------------------------------------------------

    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamProfile> getSubject(@PathVariable("id") long id) {
        TeamProfile teamProfile = services.getTeam(id);
        if (teamProfile == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teamProfile, HttpStatus.OK);
    }
    //-------------------Create a team--------------------------------------------------------

    @RequestMapping(value = "/team/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createTeam(@RequestBody TeamProfile teamProfile,UriComponentsBuilder ucBuilder) {
    //     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        repository.save(teamProfile);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/team/{id}").buildAndExpand(teamProfile.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


/*
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
    */




}
