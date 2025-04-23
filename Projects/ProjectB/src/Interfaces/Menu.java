package Interfaces;

import Core.Main;
import Objects.Action;
import Objects.Input;

import java.util.ArrayList;
import java.util.Scanner;

public interface Menu<T extends ExtendedT> {
    void SetName(String name);
    String GetName();

    default void DisplayOptions(ArrayList<T> Options) {
        for (int option = 0; option < Options.size(); option++) {
            T OptionClass = Options.get(option);

            System.out.println(option+1 + ". " + OptionClass.Print());
        }

        System.out.println("0. Exit");
    }

    default T UserInput(ArrayList<T> Options) {
        while (true) {
            int choice = Input.ReadIntInRange("Select an option: ", 0, Options.size());

            if (choice <= Options.size() && choice >= 1) {
                T selected = Options.get(choice-1);

                if (selected instanceof Action action) {
                    action.Execute();
                }

                return Options.get(choice-1);
            } else if (choice <= 0) {
                return null;
            }
        }
    }

    T Execute();
}
