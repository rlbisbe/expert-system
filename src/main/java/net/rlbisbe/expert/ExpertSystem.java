package net.rlbisbe.expert;

public class ExpertSystem {

    private Stage current;

    public ExpertSystem(FileLoader<Stage> fileLoader) {
        current = fileLoader.loadFromFile();
    }

    public String getMessage() {
        return current.getStatus();
    }

    public void answer(boolean isYes) {
        if (isYes){
            current = current.getYes();
        } else {
            current = current.getNo();
        }
    }

    public boolean isDone() {
        return current.isEnd();
    }
}
