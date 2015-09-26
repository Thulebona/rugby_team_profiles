package za.ac.cput.rugbyTeamProfiles.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.rugbyTeamProfiles.domain.PlayerProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;
import za.ac.cput.rugbyTeamProfiles.services.Imp.PlayerProfileProfileServiceImpl;
import za.ac.cput.rugbyTeamProfiles.services.PlayerProfileService;

/**
 * Created by thule on 2015/09/24.
 */
@RestController
@RequestMapping(value = "/")
public class LandingPage {
    private PlayerProfileService service = new PlayerProfileProfileServiceImpl();

    @RequestMapping(value = "/player/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createPlayer(@RequestBody PlayerProfile playerProfile,UriComponentsBuilder ucBuilder) {
        PlayerProfile player = new PlayerProfile.Builder("TE-931206")
                .player_name("Thulebona Hadebe")
                .DOB("1993-12-06")
                .position("3")
                .height(1.9)
                .test(8)
                .test_tries(50)
                .weight(50.0)
                .build();
        service.save(player);
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
                .weight(50.0)
                .build();
        return player;
    }
}
