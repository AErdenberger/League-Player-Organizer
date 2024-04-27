package organizer.models;

public class Player{
    private int id;
    private String name;
    private String ingame;
    private Rank Rank;
    private Role Primary;
    private Role Secondary;

    public Player(int id, String name, String ingame, Rank rank, Role primary, Role secondary) {
        this.id = id;
        this.name = name;
        this.ingame = ingame;
        Rank = rank;
        Primary = primary;
        Secondary = secondary;
    }

    public Player(){

    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public String getIngame() {
        return ingame;
    }

    public Rank getRank() {
        return Rank;
    }

    public Role getPrimary() {
        return Primary;
    }

    public Role getSecondary() {
        return Secondary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngame(String ingame) {
        this.ingame = ingame;
    }

    public void setRank(organizer.models.Rank rank) {
        Rank = rank;
    }

    public void setPrimary(Role primary) {
        Primary = primary;
    }

    public void setSecondary(Role secondary) {
        Secondary = secondary;
    }

    @Override
    public java.lang.String toString() {
        final java.lang.StringBuilder sb = new java.lang.StringBuilder("Player{");
        sb.append("name='").append(name).append('\'');
        sb.append(", ingame='").append(ingame).append('\'');
        sb.append(", Rank=").append(Rank);
        sb.append(", Primary=").append(Primary);
        sb.append(", Secondary=").append(Secondary);
        sb.append('}');
        return sb.toString();
    }
}

