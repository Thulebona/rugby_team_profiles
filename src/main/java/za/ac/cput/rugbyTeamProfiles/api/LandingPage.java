package za.ac.cput.rugbyTeamProfiles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.rugbyTeamProfiles.domain.PlayerProfile;
import za.ac.cput.rugbyTeamProfiles.services.PlayerProfileService;


/**
 * Created by thule on 2015/09/24.
 */
@RestController
@RequestMapping(value = "/")
public class LandingPage {

    @Autowired
    PlayerProfileService service;/* = new PlayerProfileProfileServiceImpl();*/

    @RequestMapping(value = "/player/test", method = RequestMethod.POST)
    public ResponseEntity<Void> createPlayer(@RequestBody PlayerProfile player,UriComponentsBuilder ucBuilder) {

        System.out.println("1"+player.getPlayer_name());
        System.out.println("10"+player.getId());

        service.save(player);
       System.out.println("1 thulebona" + player.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/player/{id}").buildAndExpand(player.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method= RequestMethod.GET)
    public PlayerProfile getPlayer(){

        PlayerProfile player = new PlayerProfile.Builder("TE-931206")
                .player_name("Thulebona Hadebe")
                .DOB("1993-12-06")
                .position("3")
                .height(1.9)
                .test(8)
                .test_tries(50)
                .id(Long.valueOf(8))
                .weight(50.0)
                .build();
        return player;
    }
}
