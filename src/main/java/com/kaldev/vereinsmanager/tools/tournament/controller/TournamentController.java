package com.kaldev.vereinsmanager.tools.tournament.controller;



import com.kaldev.vereinsmanager.data.controller.FieldController;
import com.kaldev.vereinsmanager.data.entity.Field;
import com.kaldev.vereinsmanager.tools.tournament.entity.Game;
import com.kaldev.vereinsmanager.tools.tournament.entity.Team;
import com.kaldev.vereinsmanager.tools.tournament.entity.Tournament;
import com.kaldev.vereinsmanager.tools.tournament.repository.TournamentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tournament/tournaments")
public class TournamentController {
    private TournamentRepository tournamentRepository;
    private TeamController teamController;
    private GameController gameController;
    private FieldController fieldController;

    public TournamentController(TournamentRepository tournamentRepository, TeamController teamController, GameController gameController, FieldController fieldController) {
        this.tournamentRepository = tournamentRepository;
        this.teamController = teamController;
        this.gameController = gameController;
        this.fieldController = fieldController;
    }

    @GetMapping("")
    public List<Tournament> tournaments(){
        return tournamentRepository.findAll();
    }

    @PostMapping("/new")
    public @ResponseBody HttpStatus addNewTournament (
            @RequestParam int idOfClub,
            @RequestParam String title,
            //TODO: Add teams and playfields, generate Games
            @RequestParam String teams,
            @RequestParam int pointsPerVictory,
            @RequestParam int pointsPerEqual,
            @RequestParam int lengthOfGame,
            @RequestParam int lengthOfBrake,
            @RequestParam int tournamentMode,
            @RequestParam int amountGroups
    ) {

        try {
            Tournament tournament = new Tournament();

            tournament.setIdOfClub(idOfClub);
            tournament.setTitle(title);

            if (pointsPerVictory != 3 || pointsPerEqual != 1){
                tournament.setPointsPerVictory(pointsPerVictory);
                tournament.setPointsPerEqual(pointsPerEqual);
            }

            tournament.setLengthOfGame(lengthOfGame);
            tournament.setLengthOfBreak(lengthOfBrake);
            tournament.setTournamentMode(tournamentMode);
            tournament.setAmountGroups(amountGroups);
            tournamentRepository.save(tournament);

            String participatingTeamIDs = CreateTeams(teams, tournament);
            StringBuilder stringBuilder = CreateGroups(amountGroups, participatingTeamIDs);

            //TODO: Implement different modes (e.g not everyone plays against each other)
            generateGames(stringBuilder.substring(0,stringBuilder.length()-1),tournament.getId());


            tournament.setGroup(stringBuilder.substring(0,stringBuilder.length()-1));
            tournament.setTeams(participatingTeamIDs.substring(0, participatingTeamIDs.length() - 1));
            tournamentRepository.save(tournament);


            return HttpStatus.OK;

        } catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }
    }

    private String CreateTeams(String teams, Tournament tournament) {
        String[] participatingTeams = teams.split(",");

        for (String team: participatingTeams
        ) {
            teamController.addNewTeam(team, tournament.getId());
        }

        String participatingTeamIDs = "";
        List<Team> teamList = teamController.getAllTeamsFromTournament(tournament.getId());

        for (Team team: teamList
             ) {
            int id = team.getId();
            participatingTeamIDs += id + ",";
        }
        return participatingTeamIDs;
    }

    private static StringBuilder CreateGroups(int amountGroups, String participatingTeamIDs) {
        String[] teamIDsArray = participatingTeamIDs.split(",");

        List<String> teamIDsList = Arrays.asList(teamIDsArray);
        Collections.shuffle(teamIDsList);

        int totalTeams = teamIDsList.size();
        int groups = Math.min(amountGroups, totalTeams);  // Ensure number of groups doesn't exceed the total number of teams
        int teamsPerGroup = totalTeams / groups;
        List<List<String>> groupList = new ArrayList<>();

        for (int i = 0; i < groups; i++) {
            int startIndex = i * teamsPerGroup;
            int endIndex = startIndex + teamsPerGroup;
            List<String> group = teamIDsList.subList(startIndex, endIndex);
            groupList.add(group);
        }

        int remainingTeams = totalTeams % groups;
        if (remainingTeams > 0) {
            List<String> lastGroup = groupList.get(groupList.size() - 1);
            List<String> remainingTeamsList = teamIDsList.subList(totalTeams - remainingTeams, totalTeams);
            lastGroup.addAll(remainingTeamsList);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (List<String> group:groupList
             ) {
            stringBuilder.append("{").append(groupList.indexOf(group)).append(":");
            for (String teamID:group
                 ) {
                if (group.indexOf(teamID) != 0){
                    stringBuilder.append(",").append(teamID);
                } else{
                    stringBuilder.append(teamID);
                }

            }
            stringBuilder.append("},");
        }
        return stringBuilder;
    }

    private void generateGames(String inputString, int tournamentID) {
        List<Game> games = new ArrayList<>();
        String[] groups = inputString.split("\\},\\{"); // Split groups

        int groupID = 0;
        for (String group : groups) {
            // Remove the opening and closing brackets
            group = group.replaceAll("[\\{\\}]", "");

            String[] teamIDs = group.split(":")[1].split(","); // Split team IDs

            // Generate games for each team against every other team in the group
            int round = 0;
            for (int i = 0; i < teamIDs.length - 1; i++) {
                for (int j = i + 1; j < teamIDs.length; j++) {
                    int homeTeamID = Integer.parseInt(teamIDs[i]);
                    int guestTeamID = Integer.parseInt(teamIDs[j]);

                    // Create a new game with the provided fields
                    Game game = new Game();
                    game.setTournamentID(tournamentID);
                    game.setRound(round);
                    game.setHomeTeamID(homeTeamID);
                    game.setGuestTeamID(guestTeamID);
                    game.setGroupID(groupID);
                    game.setPlayed(false);
                    // Set any other required fields for the game
                    games.add(game);
                    round++;
                }
            }

            List<Field> fields = fieldController.fieldList();
            int fieldAmount = fields.size();

            List<Integer> teamsThatPlayedThatRound = new ArrayList<>();
            for (Game game:games
                 ) {

            }


            groupID++;
        }

        gameController.addGame(games);
    }
}
