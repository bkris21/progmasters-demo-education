package interfacemethods;

public class Trainer implements CanWork {

    private String name;

    private int percentage;

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void work() {
        percentage = 100;
    }

    public void work(int percentage) {
        this.percentage += percentage;
    }

    @Override
    public boolean isFinished() {
        return percentage >= 100;
    }

    @Override
    public int getPercentage() {
        return percentage;
    }
}
