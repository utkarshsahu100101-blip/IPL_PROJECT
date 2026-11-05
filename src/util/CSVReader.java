package util;

import model.Delivery;
import model.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private static final String CSV_SPLIT_REGEX = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

    public static List<Match> readMatches(String filePath) {
        List<Match> matches = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            reader.readLine(); // skip header
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                matches.add(createMatch(splitCsvLine(line)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matches;
    }

    public static List<Delivery> readDeliveries(String filePath) {
        List<Delivery> deliveries = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            reader.readLine(); // skip header
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                deliveries.add(createDelivery(splitCsvLine(line)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deliveries;
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
        return value.replace("\"\"", "\"");
    }

    private static int toInt(String value) {
        return value.isEmpty() ? 0 : Integer.parseInt(value);
    }

    private static Match createMatch(String[] d) {
        return new Match(
                toInt(d[0]), toInt(d[1]), d[2], d[3], d[4], d[5], d[6], d[7], d[8],
                toInt(d[9]) != 0, d[10], toInt(d[11]), toInt(d[12]),
                d[13], d[14], d[15], d[16], d[17]
        );
    }

    private static Delivery createDelivery(String[] d) {
        return new Delivery(
                toInt(d[0]), toInt(d[1]), d[2], d[3], toInt(d[4]), toInt(d[5]),
                d[6], d[7], d[8], toInt(d[9]) != 0,
                toInt(d[10]), toInt(d[11]), toInt(d[12]), toInt(d[13]), toInt(d[14]),
                toInt(d[15]), toInt(d[16]), toInt(d[17]),
                d[18], d[19], d[20]
        );
    }
}