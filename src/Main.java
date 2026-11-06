import model.Delivery;
import model.Match;
import service.Analyzer;
import util.CSVReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Match> matchList = new ArrayList<>();
    public static List<Delivery> deliveryList = new ArrayList<>();



    public static void main(String[] args) {
        matchList =CSVReader.readMatches();

        deliveryList = CSVReader.readDeliveries();

        Analyzer analyzer = new Analyzer();
       analyzer.matchesPerYear(matchList);
       analyzer.countTeamWins(matchList);
        analyzer.countExtraRunsByTeams(deliveryList);
//        int[] pointer =analyzer.getRangeId(2017,matchList);
//        System.out.println(pointer[0]);
//        System.out.println(pointer[1]);
     analyzer.getExtraRunesByYear(2016,matchList,deliveryList);
        //System.out.println(extraRun);
      analyzer.printTopEconomyBowler(2011,5,matchList,deliveryList);
       // analyzer.getTopScorerInYear(2011,matchList,deliveryList);


    }




}