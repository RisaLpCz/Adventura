package Settings;

public class Statistics {
    private long starTime;
    private long endTime;
    private long gameTime;
    private int numberOfInteractions;
    private int numberOfQuests;

    public Statistics() {
        setStarTime(System.currentTimeMillis());
        this.numberOfInteractions = 0;
        this.numberOfQuests = 0;
    }

    public void calculate() {
        long timeInMilis = getEndTime() - getStarTime();
        setGameTime(timeInMilis / 60000);
    }

    @Override
    public String toString() {
        calculate();
        return "Doba hraní je " + (int) getGameTime() + " minut, prošlích dialogů " + getNumberOfInteractions() + " a přijmutých questů " + getNumberOfQuests();
    }

    public int getNumberOfQuests() {
        return numberOfQuests;
    }

    public void setNumberOfQuests(int numberOfQuests) {
        this.numberOfQuests = numberOfQuests;
    }

    public int getNumberOfInteractions() {
        return numberOfInteractions;
    }

    public void setNumberOfInteractions(int numberOfInteractions) {
        this.numberOfInteractions = numberOfInteractions;
    }

    public long getStarTime() {
        return starTime;
    }

    public void setStarTime(long starTime) {
        this.starTime = starTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getGameTime() {
        return gameTime;
    }

    public void setGameTime(long gameTime) {
        this.gameTime = gameTime;
    }
}
