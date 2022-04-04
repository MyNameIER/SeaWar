import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;


public class Placement {

    List<String> allBattlePosition = new ArrayList();
    List<String> allNeaBattlePosition = new ArrayList();
    private int count;

    public void testBattlePlacement(int f, int m) {
        BattleShipsPosition battleShipsPosition = new BattleShipsPosition();
        battleShipsPosition.testFieldPosition();
        allBattlePosition.addAll(battleShipsPosition.battleship);
        allNeaBattlePosition.addAll(battleShipsPosition.nearBattleship);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("test.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        TestField testField = new TestField();
        for (;f <= m;f++ ) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            testField = session.get(TestField.class, f);
            testField.setName((String) battleShipsPosition.finalFieldShips.get(f - 1));
            session.save(testField);
            transaction.commit();
        }
        sessionFactory.close();
    }

    public void battlePlacement(int i, int k) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
          Ships ships = new Ships();
          for (;i <= k;i++ ) {
              Session session = sessionFactory.openSession();
              Transaction transaction = session.beginTransaction();
              ships = session.get(Ships.class, i);
              ships.setName((String) allBattlePosition.get(i - 1));
              session.save(ships);
              transaction.commit();
          }
        sessionFactory.close();
    }

    public void neaBattlePlacement(int j, int n) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("secondhibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        NeaShips neaShips = new NeaShips();
        for (;j <= n;j++ ) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            neaShips = session.get(NeaShips.class, j);
            neaShips.setName((String) allNeaBattlePosition.get(j-1));
            session.save(neaShips);
            transaction.commit();
        }
        sessionFactory.close();
    }

    public void testCruiserPlacement(int a, int l) {
        CruiserShipsPosition cruiserShipsPosition = new CruiserShipsPosition();
        cruiserShipsPosition.testFieldPosition();
        allBattlePosition.addAll(cruiserShipsPosition.cruiserShip);
        allNeaBattlePosition.addAll(cruiserShipsPosition.nearCruiserShip);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("test.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        TestField testField = new TestField();
        for (;a <= l;a++ ) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            testField = session.get(TestField.class, a);
            testField.setName((String) cruiserShipsPosition.finalFieldShips.get(a - 1));
            session.save(testField);
            transaction.commit();
        }
        sessionFactory.close();
    }

    public void cruiserPlacement(int i, int k) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Ships ships = new Ships();
        for (;i <= k;i++ ) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            ships = session.get(Ships.class, i);
            ships.setName((String) allBattlePosition.get(i - 1));
            session.save(ships);
            transaction.commit();
        }
        sessionFactory.close();
    }

    public void neaCruiserPlacement(int j, int n) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("secondhibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        NeaShips neaShips = new NeaShips();
        for (; j <= n; j++) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            neaShips = session.get(NeaShips.class, j);
            neaShips.setName((String) allNeaBattlePosition.get(j - 1));
            session.save(neaShips);
            transaction.commit();
        }
        sessionFactory.close();
    }

    public void testSecondPlacement(int a, int l) {
        SecondCruiserPosition secondCruiserPosition = new SecondCruiserPosition();
        secondCruiserPosition.testFieldPosition();
        allBattlePosition.addAll(secondCruiserPosition.secondCruiser);
        allNeaBattlePosition.addAll(secondCruiserPosition.nearSecondCruiser);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("test.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        TestField testField = new TestField();
        for (;a <= l;a++ ) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            testField = session.get(TestField.class, a);
            testField.setName((String) secondCruiserPosition.finalFieldShips.get(a - 1));
            session.save(testField);
            transaction.commit();
        }
        sessionFactory.close();
    }

    public void secondPlacement(int i, int k) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Ships ships = new Ships();
        for (;i <= k;i++ ) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            ships = session.get(Ships.class, i);
            ships.setName((String) allBattlePosition.get(i - 1));
            session.save(ships);
            transaction.commit();
        }
        sessionFactory.close();
    }

    public void neaSecondPlacement(int j, int n) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("secondhibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        NeaShips neaShips = new NeaShips();
        for (; j <= n; j++) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            neaShips = session.get(NeaShips.class, j);
            neaShips.setName((String) allNeaBattlePosition.get(j - 1));
            session.save(neaShips);
            transaction.commit();
        }
        sessionFactory.close();
    }

    public void tableMyShot(int i) {
        UserShot userShot = new UserShot();
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("secondhibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        MyShot myShot = new MyShot();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            myShot = session.get(MyShot.class, i);
            myShot.setName((String) userShot.MyShot);
            session.save(myShot);
            transaction.commit();
             sessionFactory.close();
    }

}
