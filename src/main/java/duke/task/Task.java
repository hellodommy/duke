package duke.task;

/**
 * Tasks include events, deadlines and todo actions.
 */
public class Task {

    protected String description;
    protected boolean isDone;

    /**
     * Creates a task that is initialised as incomplete.
     *
     * @param description An activity that the user should attend/complete.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Formats the task to be stored in the hard disk.
     *
     * @return Formatted task with its details.
     */
    public String toSave() {
        return "";
    }

    /**
     * Marks a task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Gets the status of the task as done or undone.
     *
     * @return v or x if done or undone respectively.
     */
    public String getStatusIcon() {
        return (isDone ? "v" : "x"); //return tick or X symbols
    }

}