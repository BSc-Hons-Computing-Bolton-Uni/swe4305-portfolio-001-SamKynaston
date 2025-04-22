package Objects;

import Interfaces.ExtendedT;

public class Action implements ExtendedT {
    private String Name;
    private Runnable Action;

    public Action(String name, Runnable action) {
        SetName(name);
        SetAction(action);
    }

    public void Execute() {
        Action.run();
    }

    public void SetAction(Runnable action) {
        this.Action = action;
    }

    public String GetName() {
        return Name;
    }

    public void SetName(String name) {
        this.Name = name;
    }

    @Override
    public String Print() {
        return Name;
    }
}
