package za.ac.cput.rugbyTeamProfiles.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;
import za.ac.cput.rugbyTeamProfiles.services.Imp.TeamProfileServiceImpl;
import za.ac.cput.rugbyTeamProfiles.services.TeamProfileService;

import java.util.List;


/**
 * Created by student on 2015/04/18.
 */
@RestController
@RequestMapping("/api/**")
public class TeamProfileApi {
    
    private TeamProfileService service = new TeamProfileServiceImpl();
    //-------------------Retrieve All teams--------------------------------------------------------
    @RequestMapping(value="/teams", method= RequestMethod.GET)///get teams
    public ResponseEntity<List<TeamProfile>> getTeams(){
        List<TeamProfile> teams = service.findAll();
        if(teams.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //-------------------Retrieve Team Subject--------------------------------------------------------
    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamProfile> getTeam(@PathVariable("id") long id) {
        TeamProfile teamProfile = service.findById(id);
        if (teamProfile == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teamProfile, HttpStatus.OK);
    }
    //-------------------Create a team--------------------------------------------------------
    @RequestMapping(value = "/team/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createTeam(@RequestBody TeamProfile teamProfile,UriComponentsBuilder ucBuilder) {
        service.save(teamProfile);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/team/{id}").buildAndExpand(teamProfile.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
