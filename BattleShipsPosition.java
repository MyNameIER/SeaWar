import java.util.ArrayList;
import java.util.List;

public class BattleShipsPosition implements ShipsPosition {
    List battleship = new ArrayList();
    List nearBattleship = new ArrayList();
    List finalFieldShips = new ArrayList();
    List allShipPosition = new ArrayList();
    List allNearShipPosition = new ArrayList();
    ArrayList destroyer = new ArrayList();
    ArrayList speedboat = new ArrayList();
    private Integer x;
    private Integer y;
    private String ordinate;
    private int letter;
    final String[][] fieldShips = {{"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10"},
            {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10"},
            {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10"},
            {"d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10"},
            {"e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10"},
            {"f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10"},
            {"g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9", "g10"},
            {"h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10"},
            {"i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i10"},
            {"j1", "j2", "j3", "j4", "j5", "j6", "j7", "j8", "j9", "j10"}};

    @Override
    public Integer getOrdinate() {
        x = (int) (2 + Math.random() * 8);
        return x;
    }

    @Override
    public Integer getAbscissa() {
        y = (int) (1 + Math.random() * 5);
        return y;
    }
    @Override
    public String getLetter(int j) {
        int n = x;
        switch (j) {
            case 1:
                n = n - 1;
                break;
            case 2:
                n = n;
                break;
            case 3:
                n = n + 1;
                break;
        }
        letter = n;
        switch (letter) {
            case 1:
                ordinate = "a";
                break;
            case 2:
                ordinate = "b";
                break;
            case 3:
                ordinate = "c";
                break;
            case 4:
                ordinate = "d";
                break;
            case 5:
                ordinate = "e";
                break;
            case 6:
                ordinate = "f";
                break;
            case 7:
                ordinate = "g";
                break;
            case 8:
                ordinate = "h";
                break;
            case 9:
                ordinate = "i";
                break;
            case 10:
                ordinate = "j";
                break;
        }
        return ordinate;
    }
    @Override
    public List<String> shipPosition() {
        int n = y;
        getLetter(2);
        for (int i = 0; i <= 3; i++) {
            n++;
            battleship.add(ordinate + n);
        }
        return battleship;
    }

    @Override
    public List<String> neaShipPosition() {
        for (int j = 0; j <= 2; j++) {
            switch (j) {
                case 0:
                    int n = y - 1;
                    getLetter(1);
                    for (int i = 0; i <= 5; i++) {
                        n++;
                        nearBattleship.add(ordinate + n);
                    }
                    break;
                case 1:
                    n = y;
                    getLetter(2);
                    nearBattleship.add(ordinate + y);
                    nearBattleship.add(ordinate + (n+5));
                    break;
                case 2:
                    n = y - 1;
                    getLetter(3);
                    for (int i = 0; i <= 5; i++) {
                        n++;
                        nearBattleship.add(ordinate + n);
                    }
                    break;
            }
        }
        return nearBattleship;
    }

    @Override
    public List<String> freedomFields(int m, int n) {
        return null;
    }

    @ Override
    public List <String> testFieldPosition () {
        for (int i = 0; i < fieldShips.length; i++) {
            for (int j = 0; j < fieldShips[i].length; j++) {
                finalFieldShips.add(fieldShips[i][j]);
            }
        }
        getAbscissa();
        getOrdinate();
        shipPosition();
        neaShipPosition();
        finalFieldShips.removeAll(battleship);
        finalFieldShips.removeAll(nearBattleship);
        finalFieldShips.forEach(System.out::print);
        System.out.println();
        battleship.forEach(System.out::print);
        System.out.println();
        nearBattleship.forEach(System.out::print);
        System.out.println();
        return finalFieldShips;
    }

}

