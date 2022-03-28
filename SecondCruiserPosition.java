import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class SecondCruiserPosition implements ShipsPosition {
    List secondCruiser = new ArrayList();
    List nearSecondCruiser = new ArrayList();
    List finalFieldShips = new ArrayList();
    public static int count;
    private Integer x;
    private Integer y;
    private String ordinate;
    private int letter;
    private int rec = 0;

    @Override
    public Integer getOrdinate() {
        x = (int) (1 + Math.random() * 6);
        return x;
    }

    @Override
    public Integer getAbscissa() {
        y = (int) (2 + Math.random() * 8);
        return y;
    }
    @Override
    public String getLetter(int j) {
        int n = x;
        switch (j) {
            case 1:
                n = n ;
                break;
            case 2:
                n = n + 1;
                break;
            case 3:
                n = n + 2;
                break;
            case 4:
                n = n + 3;
                break;
            case 5:
                n = n + 4;
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
            secondCruiser.add(ordinate + n);
            getLetter(3);
            secondCruiser.add(ordinate + n);
            getLetter(4);
            secondCruiser.add(ordinate + n);
        return secondCruiser;
    }

    @Override
    public List<String> neaShipPosition() {
        for (int j = 0; j <= 2; j++) {
            switch (j) {
                case 0:
                    int n = y - 1;
                    getLetter(1);
                    nearSecondCruiser.add(ordinate + n);
                    getLetter(2);
                    nearSecondCruiser.add(ordinate + n);
                    getLetter(3);
                    nearSecondCruiser.add(ordinate + n);
                    getLetter(4);
                    nearSecondCruiser.add(ordinate + n);
                    getLetter(5);
                    nearSecondCruiser.add(ordinate + n);
                    break;
                case 1:
                    n = y;
                    getLetter(1);
                    nearSecondCruiser.add(ordinate + n);
                    getLetter(5);
                    nearSecondCruiser.add(ordinate + n);
                    break;
                case 2:
                    n = y + 1;
                    getLetter(1);
                    nearSecondCruiser.add(ordinate + n);
                    getLetter(2);
                    nearSecondCruiser.add(ordinate + n);
                    getLetter(3);
                    nearSecondCruiser.add(ordinate + n);
                    getLetter(4);
                    nearSecondCruiser.add(ordinate + n);
                    getLetter(5);
                    nearSecondCruiser.add(ordinate + n);
                    break;
            }
        }
        return nearSecondCruiser;
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

    public int Count() {
        for (Object ele : nearSecondCruiser) {
            if (finalFieldShips.contains(ele)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public List<String> testFieldPosition() {
        getOrdinate();
        getAbscissa();
        shipPosition();
        neaShipPosition();
        freedomFields(1,67);
        System.out.println("Еще раз");
        for (Object ele : secondCruiser) {
            if (finalFieldShips.contains(ele)) {
                rec++;
                continue;
            }
            rec = 0;
            break;
        }
        if (rec != 3) {
            secondCruiser.clear();
            nearSecondCruiser.clear();
            finalFieldShips.clear();
            testFieldPosition();
        }
        else {

            finalFieldShips.removeAll(secondCruiser);
            finalFieldShips.removeAll(nearSecondCruiser);
            System.out.println("Новые не битые поля плоского");
            finalFieldShips.forEach(System.out::print);
            System.out.println();
            secondCruiser.forEach(System.out::print);
            System.out.println();
            nearSecondCruiser.forEach(System.out::print);
            System.out.println();
        }
        return finalFieldShips;
    }
}


