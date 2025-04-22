package Objects;

import Interfaces.ExtendedT;
import Interfaces.Menu;

public class OptionMenu<T extends ExtendedT> implements Menu<T> {
    private String Name;

    public OptionMenu(String name) {
        SetName(name);
    }

    @Override
    public void SetName(String name) {
        this.Name = name;
    }

    @Override
    public T Execute() {
        return null;
    }

    @Override
    public String GetName() {
        return Name;
    }
}
