package za.ac.cput.rugbyTeamProfiles.factory;

import za.ac.cput.rugbyTeamProfiles.domain.PlayerRecords;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class PlayerRecordsFactory {

    public static PlayerRecords getPlayer_Record(Map<String,String> values/*,PlayerProfile player*/){
        PlayerRecords record = new PlayerRecords.Builder(values.get("recordDate"))
                                   // .recordDate(values.get("recordDate"))
                                    .recordDescription(values.get("recordDescription"))
                                    .build();
        return record;
    }
}
