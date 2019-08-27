public class Event extends Task {

    protected String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    @Override
    public String toSave() {
        return "E | " + super.getBinaryStatus() + " | " + super.description + " | " + time;
    }

    @Override
    public String toString() {
        return "[E][" + super.getStatusIcon() + "] " + super.description + " (at: " + time + ")";
    }
}