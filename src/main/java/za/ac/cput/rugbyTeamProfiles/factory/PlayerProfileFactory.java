package za.ac.cput.rugbyTeamProfiles.factory;

import za.ac.cput.rugbyTeamProfiles.domain.PlayerProfile;
import za.ac.cput.rugbyTeamProfiles.domain.PlayerRecords;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class PlayerProfileFactory {


    public static PlayerProfile getPlayer_profile(Map<String,String> myStings ,Map<String,Integer> myInt,
                                                  Map<String,Double> myDouble/*, PlayerRecords rec/*,TeamProfile team_profile*/) {

        PlayerProfile player = new PlayerProfile.Builder(myStings.get("playerID"))
                                    .player_name(myStings.get("player_name"))
                                    .DOB(myStings.get("DOB"))
                                    .position(myStings.get("position"))
                                    .height(myDouble.get("height"))
                                    .test(myInt.get("test"))
                                    .test_tries(myInt.get("test_tries"))
                                    .weight(myDouble.get("weight"))
                                    //.player_record(rec)
                                   // .team_profile(team_profile)
                                    .build();

        return player;

    }

}
