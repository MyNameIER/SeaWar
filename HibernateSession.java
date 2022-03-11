import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateSession {
    public void hibernateSession()
    {
        ShipsPosition shipsPosition = new ShipsPosition();
        shipsPosition.getAbscissa();
        shipsPosition.getOrdinate();
        shipsPosition.battleShipPosition();
        shipsPosition.neaBattleShipPosition();
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
;
          Ships ships = new Ships();
        for (int i = 1; i <= 4;i++ ) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            ships = session.get(Ships.class, i);
            ships.setName((String) shipsPosition.battleship.get(i-1));
            session.save(ships);
            transaction.commit();
        }
        sessionFactory.close();
    }

}
