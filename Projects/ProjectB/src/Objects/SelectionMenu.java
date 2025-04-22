package Objects;

import Interfaces.*;

import java.util.ArrayList;

public class SelectionMenu<T extends ExtendedT> implements Menu<T> {
    private String Name;
    private final ArrayList<T> Options;

    public SelectionMenu(String name, ArrayList<T> options) {
        SetName(name);
        this.Options = options;
    }

    public void AddOption(T option) {
        Options.add(option);
    }

    @Override
    public void SetName(String name) {
        this.Name = name;
    }

    @Override
    public T Execute() {
        System.out.println(Name);
        DisplayOptions(Options);

        return UserInput(Options);
    }

    @Override
    public String GetName() {
        return Name;
    }
}
