
package model;

public class Delivery {

    private int matchId;
    private int inning;
    private String battingTeam;
    private String bowlingTeam;
    private int over;
    private int ball;
    private String batsman;
    private String nonStriker;
    private String bowler;
    private boolean isSuperOver;
    private int wideRuns;
    private int byeRuns;
    private int legbyeRuns;
    private int noballRuns;
    private int penaltyRuns;
    private int batsmanRuns;
    private int extraRuns;
    private int totalRuns;
    private String playerDismissed;
    private String dismissalKind;
    private String fielder;


    // Constructor
    public Delivery(int matchId, int inning, String battingTeam,
                    String bowlingTeam, int over, int ball,
                    String batsman, String nonStriker, String bowler,
                    boolean isSuperOver, int wideRuns, int byeRuns,
                    int legbyeRuns, int noballRuns, int penaltyRuns,
                    int batsmanRuns, int extraRuns, int totalRuns,
                    String playerDismissed, String dismissalKind,
                    String fielder) {

        this.matchId = matchId;
        this.inning = inning;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.over = over;
        this.ball = ball;
        this.batsman = batsman;
        this.nonStriker = nonStriker;
        this.bowler = bowler;
        this.isSuperOver = isSuperOver;
        this.wideRuns = wideRuns;
        this.byeRuns = byeRuns;
        this.legbyeRuns = legbyeRuns;
        this.noballRuns = noballRuns;
        this.penaltyRuns = penaltyRuns;
        this.batsmanRuns = batsmanRuns;
        this.extraRuns = extraRuns;
        this.totalRuns = totalRuns;
        this.playerDismissed = playerDismissed;
        this.dismissalKind = dismissalKind;
        this.fielder = fielder;
    }

    // Getters

    public int getMatchId() {
        return matchId;
    }

    public int getInning() {
        return inning;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }

    public int getOver() {
        return over;
    }

    public int getBall() {
        return ball;
    }

    public String getBatsman() {
        return batsman;
    }

    public String getNonStriker() {
        return nonStriker;
    }

    public String getBowler() {
        return bowler;
    }

    public boolean isSuperOver() {
        return isSuperOver;
    }

    public int getWideRuns() {
        return wideRuns;
    }

    public int getByeRuns() {
        return byeRuns;
    }

    public int getLegbyeRuns() {
        return legbyeRuns;
    }

    public int getNoballRuns() {
        return noballRuns;
    }

    public int getPenaltyRuns() {
        return penaltyRuns;
    }

    public int getBatsmanRuns() {
        return batsmanRuns;
    }

    public int getExtraRuns() {
        return extraRuns;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public String getPlayerDismissed() {
        return playerDismissed;
    }

    public String getDismissalKind() {
        return dismissalKind;
    }

    public String getFielder() {
        return fielder;
    }
}
