package organizer.models;

public enum Role{
    TOP("Top"),
    JUNGLE("Jungle"),
    MID("Mid"),
    BOT("Bot"),
    SUPPORT("Support");

    private String displayRole;

    Role(String displayRole) {
        this.displayRole = displayRole;
    }

    public String getDisplayRole() {
        return displayRole;
    }
}