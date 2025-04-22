package Objects;

import Interfaces.*;

import java.util.ArrayList;

public class SelectionMenu<T extends ExtendedT> implements Menu<T> {
    private String Name;
    private final ArrayList<T> Options;
    private boolean isQuitting = false;

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
    public void DisplayOptions() {
        for (T option : Options) {
            System.out.println(option.Print());
        }
    }

    @Override
    public T UserInput() {
        return null;
    }

    @Override
    public T Execute() {
        System.out.println(Name);

        DisplayOptions();

        while (!isQuitting) {
            this.isQuitting = true;
        }

        return Options.get(1);
    }

    @Override
    public String GetName() {
        return Name;
    }
}
