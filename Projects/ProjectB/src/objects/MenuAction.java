package objects;

@FunctionalInterface
public interface MenuAction {
    MenuActionContext Context = MenuActionContext.GetContext();

    void Execute();

    default MenuActionContext GetContext() {
        return Context;
    }
}
