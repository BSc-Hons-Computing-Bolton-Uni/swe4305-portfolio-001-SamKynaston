package Interfaces;

public interface Menu<T> {
    boolean isQuitting = false;

    void SetName(String name);
    void DisplayOptions();
    T UserInput();
    T Execute();
    String GetName();
}
