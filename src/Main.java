import model.Delivery;
import model.Match;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    public static List<Match> matchList = new ArrayList<>();
    public static List<Delivery> deliveryList = new ArrayList<>();

    public static void main(String[] args) {

readDeliveryDataFromCsv();
readMatchDataFromCsv();


    }
    private static void readDeliveryDataFromCsv() {

        String filePath = "deliveries.csv";

        try (
                Reader reader = Files.newBufferedReader(Path.of(filePath));
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .get()
                        .parse(reader)
        ) {

            for (CSVRecord record : parser) {
                deliveryList.add(createDelivery(record));
            }

            System.out.println("Total deliveries: " + deliveryList.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Delivery createDelivery(CSVRecord data) {

        return new Delivery(
                Integer.parseInt(data.get(0)),  // matchId
                Integer.parseInt(data.get(1)),  // inning
                data.get(2),                    // battingTeam
                data.get(3),                    // bowlingTeam
                Integer.parseInt(data.get(4)),  // over
                Integer.parseInt(data.get(5)),  // ball
                data.get(6),                    // batsman
                data.get(7),                    // nonStriker
                data.get(8),                    // bowler
                Integer.parseInt(data.get(9)) != 0,  // isSuperOver
                Integer.parseInt(data.get(10)), // wideRuns
                Integer.parseInt(data.get(11)), // byeRuns
                Integer.parseInt(data.get(12)), // legbyeRuns
                Integer.parseInt(data.get(13)), // noballRuns
                Integer.parseInt(data.get(14)), // penaltyRuns
                Integer.parseInt(data.get(15)), // batsmanRuns
                Integer.parseInt(data.get(16)), // extraRuns
                Integer.parseInt(data.get(17)), // totalRuns
                data.get(18),                   // playerDismissed
                data.get(19),                   // dismissalKind
                data.get(20)                    // fielder
        );
    }

    private static void readMatchDataFromCsv() {

        String filePath = "matches.csv";

        try (
                Reader reader = Files.newBufferedReader(Path.of(filePath));
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .get()
                        .parse(reader)
        ) {

            for (CSVRecord record : parser) {
                matchList.add(createMatch(record));
            }

            System.out.println("Total matches: " + matchList.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

        printAllPlayerOfTheMatch();
    }

    private static Match createMatch(CSVRecord data) {

        return new Match(
                Integer.parseInt(data.get(0)),  // id
                Integer.parseInt(data.get(1)),  // season
                data.get(2),                    // city
                data.get(3),                    // date
                data.get(4),                    // team1
                data.get(5),                    // team2
                data.get(6),                    // tossWinner
                data.get(7),                    // tossDecision
                data.get(8),                    // result
                Integer.parseInt(data.get(9)) != 0,  // dlApplied
                data.get(10),                   // winner
                Integer.parseInt(data.get(11)), // winByRuns
                Integer.parseInt(data.get(12)), // winByWickets
                data.get(13),                   // playerOfMatch
                data.get(14),                   // venue
                data.get(15),                   // umpire1
                data.get(16),                   // umpire2
                data.get(17)                    // umpire3
        );
    }
    private static void printAllPlayerOfTheMatch(){
        for(Match match :matchList){
            System.out.println(match.getPlayerOfMatch());
        }
    }









}