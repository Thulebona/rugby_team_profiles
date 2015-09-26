package za.ac.cput.rugbyTeamProfiles.services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import za.ac.cput.rugbyTeamProfiles.App;
import za.ac.cput.rugbyTeamProfiles.domain.*;
import za.ac.cput.rugbyTeamProfiles.factory.*;
import za.ac.cput.rugbyTeamProfiles.repository.TeamsLogRankingRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-05-10.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class LogRankingServicesTest extends AbstractTestNGSpringContextTests {

    private TeamsLogRanking log_ranking;
    private TeamProfile team;
    private Map<String, String> value;
    private Map<String, String> playRec_value;
    private Map<String, String> recvalue;
    private Map<String, String> myString;
    private Map<String, Integer> myInt;
    private Map<String, Integer> logValues;
    private Map<String, Double> myDouble;

    private TeamRecords team_rec;

    private PlayerProfile player;
    private PlayerProfile player2;
    private PlayerRecords player_rec;
    private List<PlayerProfile> players;
    private Long id;
    @Autowired
    TeamsLogRankingRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        value = new HashMap<String, String>();
        recvalue = new HashMap<String, String>();
        myString = new HashMap<String, String>();
        myInt = new HashMap<String, Integer>();
        logValues = new HashMap<String, Integer>();
        myDouble = new HashMap<String, Double>();
        players = new ArrayList<PlayerProfile>();
        playRec_value = new HashMap<String, String>();
    }

    //@Test
    public void testCreate() throws Exception {
        //add team profile map;
        value.put("teamName", "Sharks");
        value.put("league", "Currie Cup");
        value.put("home_Ground", "Kings Park Stadium in Durban");
        value.put("headCoach", " Matt Todd");

        // add team record map
        recvalue.put("recordDate", "01/05/2010");
        recvalue.put("recordDescription", "6 times currie cup winners");


        // add PlayerProfile 1
        myString.put("playerID", "851206 5367 088");
        myString.put("player_name", "tendai mtawarira");
        myString.put("DOB", " August-1-1985");
        myString.put("position", "Lock");
        myDouble.put("height", 1.8);
        myDouble.put("weight", 116.0);
        myInt.put("test", 50);
        myInt.put("test_tries", 8);
        player = PlayerProfileFactory.getPlayer_profile(myString, myInt, myDouble/*, player_rec/*,team*/);

        // add PlayerProfile 1
        myString.put("playerID", "841206 6951 088");
        myString.put("player_name", "bismarck du plessis");
        myString.put("DOB", " May-22-1984");
        myString.put("position", "Hooker");
        myDouble.put("height", 1.89);
        myDouble.put("weight", 114.0);
        myInt.put("test", 40);
        myInt.put("test_tries", 10);

        playRec_value.put("recordDate", "01/08/2010");
        playRec_value.put("recordDescription", "best player of the year");

        player_rec = PlayerRecordsFactory.getPlayer_Record(playRec_value/*, player*/);
        player2 = PlayerProfileFactory.getPlayer_profile(myString, myInt, myDouble/*, player_rec/*,team*/);
        team_rec = TeamRecordsFactory.getTeam_Record(recvalue/*, team*/);

        players.add(player);
        players.add(player2);
        team = TeamProfileFactory.getTeamProfile(value, team_rec, players);
        /// add log

        logValues.put("played", 0);
        logValues.put("win", 0);
        logValues.put("lose", 0);
        logValues.put("draw", 0);
        logValues.put("pointFor", 0);
        logValues.put("pointAgainst", 0);
        logValues.put("bonusPoint", 0);

        log_ranking = TeamsLogFactory.getTeams_log_ranking(team, logValues);
        repository.save(log_ranking);
        id = team.getId();
        Assert.assertNotNull(id);

    }
}