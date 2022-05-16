package k15hkii.se114.bookstore.commands;

public interface ICommand {

    boolean canExecute();

    void execute();

}
