import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class CruiserShipsPosition implements ShipsPosition {
    List cruiserShip = new ArrayList();
    List nearCruiserShip = new ArrayList();
    List finalFieldShips = new ArrayList();
    private Integer x;
    private Integer y;
    private String ordinate;
    private String testLatter;
    private int letter;
    private int rec = 0;

    @Override
    public Integer getOrdinate() {
        x = (int) (2 + Math.random() * 8);
        return x;
    }

    @Override
    public Integer getAbscissa() {
        y = (int) (1 + Math.random() * 6);
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
        for (int i = 0; i <= 2; i++) {
            n++;
            cruiserShip.add(ordinate + n);
        }
        return cruiserShip;
    }

    @Override
    public List<String> neaShipPosition() {
        for (int j = 0; j <= 2; j++) {
            switch (j) {
                case 0:
                    int n = y - 1;
                    getLetter(1);
                    for (int i = 0; i <= 4; i++) {
                        n++;
                        nearCruiserShip.add(ordinate + n);
                    }
                    break;
                case 1:
                    n = y;
                    getLetter(2);
                    nearCruiserShip.add(ordinate + n);
                    nearCruiserShip.add(ordinate + (y + 4));
                    break;
                case 2:
                    n = y - 1;
                    getLetter(3);
                    for (int i = 0; i <= 4; i++) {
                        n++;
                        testLatter = (ordinate + n);
                        nearCruiserShip.add(ordinate + n);
                    }
                    break;
            }
        }
        return nearCruiserShip;
    }

    @Override
    public List<String> freedomFields(int f, int m) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("test.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        TestField testField = new TestField();
        for (;f <= m;f++ ) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            testField = session.get(TestField.class,f);
            finalFieldShips.add(testField.getName());
            session.save(testField);
            transaction.commit();
        }
        sessionFactory.close();
        finalFieldShips.forEach(System.out::print);
        System.out.println();
        return finalFieldShips;
    }

    @ Override
    public List<String> testFieldPosition() {
        getOrdinate();
        getAbscissa();
        shipPosition();
        neaShipPosition();
        freedomFields(1,82);
        System.out.println("Еще раз Крейсер");
        for (Object ele : cruiserShip) {
            if (finalFieldShips.contains(ele)) {
                rec++;
                continue;
            }
            rec = 0;
            break;
        }
        if (rec != 3) {
            cruiserShip.clear();
            nearCruiserShip.clear();
            finalFieldShips.clear();
            testFieldPosition();
        } else {

            finalFieldShips.removeAll(cruiserShip);
            finalFieldShips.removeAll(nearCruiserShip);
            System.out.println("Новые не битые поля Крейсера");
            finalFieldShips.forEach(System.out::print);
            System.out.println();
            cruiserShip.forEach(System.out::print);
            System.out.println();
            nearCruiserShip.forEach(System.out::print);
            System.out.println();
        }
        return finalFieldShips;
    }
}


