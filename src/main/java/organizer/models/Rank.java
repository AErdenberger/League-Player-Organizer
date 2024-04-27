package organizer.models;

public enum Rank {
    UNRANKED("Unranked"),
    IRON("Iron"),
    BRONZE("Bronze"),
    SILVER("Silver"),
    GOLD("Gold"),
    PLATINUM("Platinum"),
    EMERALD("Emerald"),
    DIAMOND("Diamond"),
    MASTER("Master"),
    GRANDMASTER("Grandmaster"),
    CHALLENGER("Challenger");

    private final String displayRank;

    Rank(String displayRank){
        this.displayRank = displayRank;
    }

    public String getDisplayRank() {
        return displayRank;
    }
}