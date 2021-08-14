import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    LocalDateTime moment;

    static int GS = (int) Math.pow(10, 9);

    public Gigasecond(LocalDate moment) {
        this.moment = this.computeDateTimePlusGS(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = this.computeDateTimePlusGS(moment);
    }

    private LocalDateTime computeDateTimePlusGS(LocalDateTime moment) {
        return moment.plusSeconds(Gigasecond.GS);
    }

    public LocalDateTime getDateTime() {
        return this.moment;
    }
}
