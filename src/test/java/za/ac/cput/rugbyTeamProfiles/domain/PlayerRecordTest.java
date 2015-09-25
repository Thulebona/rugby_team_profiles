package za.ac.cput.rugbyTeamProfiles.domain;

import org.junit.Assert;
import org.junit.Before;
import za.ac.cput.rugbyTeamProfiles.factory.PlayerRecordsFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class PlayerRecordTest {
    private PlayerRecords record;
    private Map<String,String> values;
    private PlayerProfile player;
    @Before
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
    }
  //  @Test
    public void testRecords() throws Exception {
       // player = new PlayerProfile.Builder("kt93").player_name("john you").build();
        values.put("recordDate","19/02/2014");
        values.put("recordDescription","player of the tournament");

        record = PlayerRecordsFactory.getPlayer_Record(values/*,player*/);
        Assert.assertEquals("19/02/2014", record.getRecordDate());
    }
  //  @Test
    public void testRecordsUpdate() throws Exception {
       // player = new PlayerProfile.Builder("kt93").player_name("john you").build();
        values.put("recordDate","19/02/2014");
        values.put("recordDescription","player of the tournament");

        record = PlayerRecordsFactory.getPlayer_Record(values/*,player*/);

        PlayerRecords newPlayerRec = new PlayerRecords.Builder(record.getRecordDate())
                                          .copy(record)
                                          .recordDescription("player of the season")
                                          //.recordDate("12/8/2009")
                                          .build();

        Assert.assertEquals("player of the season", newPlayerRec.getRecordDescription());
        Assert.assertEquals("player of the tournament", record.getRecordDescription());

        Assert.assertEquals("12/8/2009", newPlayerRec.getRecordDate());
        Assert.assertEquals("19/02/2014", record.getRecordDate());

    }
}
