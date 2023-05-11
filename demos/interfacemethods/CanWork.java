package interfacemethods;

public interface CanWork {

    void work();

    boolean isFinished();

    default int getPercentage() {
        return isFinished() ? 100 : 0;
    }

    public static void finishIfHalfFinished(CanWork canWork) {
        if (canWork.getPercentage() > 50) {
            canWork.work();
        }
    }

}
