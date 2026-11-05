import model.Delivery;
import model.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Match> matchList = new ArrayList<>();
    public static List<Delivery> deliveryList = new ArrayList<>();

    private static final String CSV_SPLIT_REGEX = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

    public static void main(String[] args) {
        readDeliveryDataFromCsv();
        readMatchDataFromCsv();
    }


    private static String[] splitCsvLine(String line) {
        String[] parts = line.split(CSV_SPLIT_REGEX, -1);
        for (int i = 0; i < parts.length; i++) {
            parts[i] = clean(parts[i]);
        }
        return parts;
    }

    private static String clean(String value) {
        value = value.trim();
        if (value.length() >= 2 && value.startsWith("\"") && value.endsWith("\"")) {
            value = value.substring(1, value.length() - 1);
        }
        return value.replace("\"\"", "\"");   // escaped quotes "" -> "
    }

    private static int toInt(String value) {
        return value.isEmpty() ? 0 : Integer.parseInt(value);
    }


    private static void readDeliveryDataFromCsv() {
        String filePath = "deliveries.csv";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            reader.readLine(); // skip header

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                deliveryList.add(createDelivery(splitCsvLine(line)));
            }

            System.out.println("Total deliveries: " + deliveryList.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Delivery createDelivery(String[] data) {
        return new Delivery(
                toInt(data[0]),          // matchId
                toInt(data[1]),          // inning
                data[2],                 // battingTeam
                data[3],                 // bowlingTeam
                toInt(data[4]),          // over
                toInt(data[5]),          // ball
                data[6],                 // batsman
                data[7],                 // nonStriker
                data[8],                 // bowler
                toInt(data[9]) != 0,     // isSuperOver
                toInt(data[10]),         // wideRuns
                toInt(data[11]),         // byeRuns
                toInt(data[12]),         // legbyeRuns
                toInt(data[13]),         // noballRuns
                toInt(data[14]),         // penaltyRuns
                toInt(data[15]),         // batsmanRuns
                toInt(data[16]),         // extraRuns
                toInt(data[17]),         // totalRuns
                data[18],                // playerDismissed
                data[19],                // dismissalKind
                data[20]                 // fielder
        );
    }


    private static void readMatchDataFromCsv() {
        String filePath = "matches.csv";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            reader.readLine(); // skip header

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                matchList.add(createMatch(splitCsvLine(line)));
            }

            System.out.println("Total matches: " + matchList.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

        printAllPlayerOfTheMatch();
    }

    private static Match createMatch(String[] data) {
        return new Match(
                toInt(data[0]),          // id
                toInt(data[1]),          // season
                data[2],                 // city
                data[3],                 // date
                data[4],                 // team1
                data[5],                 // team2
                data[6],                 // tossWinner
                data[7],                 // tossDecision
                data[8],                 // result
                toInt(data[9]) != 0,     // dlApplied
                data[10],                // winner
                toInt(data[11]),         // winByRuns
                toInt(data[12]),         // winByWickets
                data[13],                // playerOfMatch
                data[14],                // venue
                data[15],                // umpire1
                data[16],                // umpire2
                data[17]                 // umpire3
        );
    }

    private static void printAllPlayerOfTheMatch() {
        for (Match match : matchList) {
            System.out.println(match.getPlayerOfMatch());
        }
    }
}