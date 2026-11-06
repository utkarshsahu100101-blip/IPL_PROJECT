package service;

import model.Delivery;
import model.Match;

import java.util.*;

public class Analyzer {

    public void matchesPerYear(List<Match> matches){
        TreeMap<Integer,Integer> map = new TreeMap<>();
         for(Match match :matches){
             int key =match.getSeason();
map.put(key, map.getOrDefault(key,0)+1);
         }

         for(Map.Entry<Integer,Integer> entry : map.entrySet()){
             System.out.println("Year: "+entry.getKey()+" Matches: "+entry.getValue());
         }

    }

    public void countTeamWins(List<Match> matches){
        Map<String,Integer> map = new HashMap<>();
        for(Match match:matches) {
            String key = match.getWinner();
            if (key.equals(""))key="no result";
            map.put(key,map.getOrDefault(key,0)+1);
        }

        for(Map.Entry<String ,Integer> entry:map.entrySet()){
            System.out.println("Team: "+entry.getKey()+", Wins: "+entry.getValue());
        }

    }
    public void countExtraRunsByTeams(List<Delivery> deliveries){
        Map<String,Integer> map = new HashMap<>();
        for(Delivery delivery: deliveries){
            String key=delivery.getBattingTeam();
            map.put(key,map.getOrDefault(key,0)+delivery.getExtraRuns());
        }

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println("Team: "+entry.getKey()+", Extra Runes: "+entry.getValue());
        }

    }

    public int[] getRangeId(int year , List<Match> matchList){
        boolean sFind=false;
        int[] pointer = new int[2];
        for(Match match:matchList){
            if(!sFind && match.getSeason()==year ){
                pointer[0]=match.getId();
                sFind=true;
            }
            if(sFind && match.getSeason()!=year){
                pointer[1]=match.getId()-1;
                return pointer;
            }
        }

        if(pointer[1]==0 && sFind){
            pointer[1]=matchList.get(matchList.size()-1).getId();
        }
        return pointer;
    }

    public void getExtraRunesByYear(int year,List<Match> matchList ,List<Delivery> deliveries){
        int[] range=getRangeId(year,matchList);
Map<String,Integer> map = new HashMap<>() ;
for(Delivery delivery:deliveries){
            if(delivery.getMatchId()>=range[0] && delivery.getMatchId()<=range[1]){
                String key = delivery.getBowlingTeam();
                map.put(key,map.getOrDefault(key,0)+delivery.getExtraRuns());
            }
        }
        for(Map.Entry<String,Integer>entry:map.entrySet()){
            System.out.println("Teams: "+ entry.getKey()+", Extra Runs: "+entry.getValue());
        }
    }

    public void printTopEconomyBowler(int year, int top, List<Match> matchList, List<Delivery> deliveries) {
        int[] range = getRangeId(year, matchList);

        Map<String, int[]> map = new HashMap<>();
        for (Delivery delivery : deliveries) {
            if (delivery.getMatchId() >= range[0] && delivery.getMatchId() <= range[1]) {
                String key = delivery.getBowler();
                int[] array = map.computeIfAbsent(key, k -> new int[2]);
                array[0]++;
                array[1] += delivery.getTotalRuns();
            }
        }

        TreeMap<Float, List<String>> tmap = new TreeMap<>();
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            float over = entry.getValue()[0] / 6;
            float eco = entry.getValue()[1] / over;
            tmap.computeIfAbsent(eco, k -> new ArrayList<>()).add(entry.getKey());
        }

        for (Map.Entry<Float, List<String>> entry : tmap.entrySet()) {
            for (String bowler : entry.getValue()) {
                System.out.println("Bowler: " + bowler + ", Economy: " + entry.getKey());
                top--;
                if (top < 1) return;
            }
        }
    }




        }




//        readDeliveryDataFromCsv();
//        readMatchDataFromCsv();