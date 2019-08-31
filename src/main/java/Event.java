/**
 * Events are tasks that start at a specific time and ends at a specific time.
 */
public class Event extends Task {

    protected DateTime dateTime;
    protected String timeInFile;

    /**
     * Creates an event task with the specified description and date/time.
     *
     * @param description Event to attend to.
     * @param dateTimeString Date/time of the event.
     */
    public Event(String description, String dateTimeString) {
        super(description);
        this.dateTime = dateTime.create(dateTimeString);
        this.timeInFile = dateTimeString;
    }

    /**
     * Parses the command given to Duke and creates a event task if possible.
     *
     * @param fullCommand Full command split by the word "event".
     * @return Event object created.
     * @throws DukeException If the deadline has no description, or no date/time.
     */
    public static Event parse(String[] fullCommand) throws DukeException {
        if (fullCommand.length == 1) {
            throw new DukeException("     OOPS!!! The description of an event cannot be empty :-(");
        }
        String[] detailsArray = fullCommand[1].split(" /at ", 2);
        if (detailsArray.length == 1) {
            throw new DukeException("     OOPS!!! Please specify a date and time for your event :-(");
        }
        return new Event(detailsArray[0], detailsArray[1]);
    }

    /**
     * Formats the event to be stored in the hard disk.
     *
     * @return Event details in the format E | 1 or 0 | description | time.
     */
    @Override
    public String toSave() {
        return "E | " + super.getBinaryStatus() + " | " + super.description + " | " + timeInFile;
    }

    /**
     * Formats the event to be displayed to the user.
     *
     * @return Event details in the format [E][v or x] description (at: date and time).
     */
    @Override
    public String toString() {
        return "[E][" + super.getStatusIcon() + "] " + super.description + " (at: " + dateTime + ")";
    }
}