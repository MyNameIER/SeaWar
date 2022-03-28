import java.util.List;

public interface ShipsPosition {

    Integer getOrdinate();

    Integer getAbscissa();

    String getLetter(int j);

    List<String> shipPosition();

    List<String> neaShipPosition();

    List <String> freedomFields(int m, int n);

    List<String> testFieldPosition();
}
