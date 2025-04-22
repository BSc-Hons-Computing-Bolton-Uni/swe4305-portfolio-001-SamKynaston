package Objects;

import Interfaces.ExtendedT;
import Interfaces.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class OptionMenu<T extends ExtendedT> implements Menu<Action> {
    private String Name;
    private ArrayList<Action> Options;

    public OptionMenu(String name) {
        SetName(name);
        this.Options = new ArrayList<>();
    }

    public void AddAction(Action action) {
        Options.add(action);
    }

    @Override
    public void SetName(String name) {
        this.Name = name;
    }

    @Override
    public Action Execute() {
        System.out.println(Name);
        DisplayOptions(Options);

        return UserInput(Options);
    }

    @Override
    public String GetName() {
        return Name;
    }
}
