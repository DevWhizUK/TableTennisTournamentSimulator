public class Player {
    private final String name;
    private final int backhandSkill;
    private final int forehandSkill;

    public Player(String name, int backhandSkill, int forehandSkill) {
        this.name = name;
        this.backhandSkill = backhandSkill;
        this.forehandSkill = forehandSkill;
    }

    public String getName() {
        return name;
    }

    public int getBackhandSkill() {
        return backhandSkill;
    }

    public int getForehandSkill() {
        return forehandSkill;
    }

    @Override
    public String toString() {
        return name + " (Backhand: " + backhandSkill + ", Forehand: " + forehandSkill + ")";
    }
}

