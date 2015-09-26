package za.ac.cput.rugbyTeamProfiles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.rugbyTeamProfiles.domain.PlayerProfile;
import za.ac.cput.rugbyTeamProfiles.services.PlayerProfileService;

import java.util.List;

/**
 * Created by thule on 2015/09/26.
 */
@RestController
@RequestMapping("/api/**")
public class PlayersProfileApi {

    @Autowired
    PlayerProfileService service /*= new PlayerProfileProfileServiceImpl()*/;
    //-------------------Retrieve All teams--------------------------------------------------------

    @RequestMapping(value="/players", method= RequestMethod.GET)///get teams
    public ResponseEntity<List<PlayerProfile>> getPlayers(){
        List<PlayerProfile> players = service.findAll();
        System.out.println(players.size());
        if(players.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-------------------Retrieve Team Subject--------------------------------------------------------

    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayerProfile> getPlayer(@PathVariable("id") long id) {
        PlayerProfile playerProfile = service.findById(id);
        if (playerProfile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playerProfile, HttpStatus.OK);
    }
    //-------------------Create a team--------------------------------------------------------

    @RequestMapping(value = "/player/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createPlayer(@RequestBody PlayerProfile playerProfile,UriComponentsBuilder ucBuilder) {
        service.save(playerProfile);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/player/{id}").buildAndExpand(playerProfile.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
