import duke.command.Command;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;
import java.io.FileNotFoundException;

/**
 * Duke is a Personal Assistant Chatbot that helps a person to keep track of various things.
 */
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    String getResponse(String input) {
        return "Duke heard: " + input;
    }


    /**
     * Initialises a session for Duke and loads tasks, if any, from a previous session.
     */
    public Duke() {
        ui = new Ui();
        storage = new Storage("/users/dominique/documents/cs2103t/duke/data/duke.txt");
        try {
            tasks = new TaskList(storage.load());
        } catch (FileNotFoundException e) {
            ui.showLoadingError(e);
            tasks = new TaskList();
        }
    }

    /**
     * Begins a session of Duke by initialising a Duke object with the filepath to load and store the task list.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        new Duke().run();
    }


    /**
     * Reads the program until termination.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                System.err.println(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

}
