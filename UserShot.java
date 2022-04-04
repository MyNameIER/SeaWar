import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserShot {

    private Scanner scanner = new Scanner(System.in);
    List <String> ShipPosition = new ArrayList();
    private boolean bang;
    public String MyShot;
    private int id = 0;
    private String MyLetter;
    private String answer;
    private Boolean next;
    public int mutable = 0;


    public List<String> Position (int f, int m) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("test.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        TestField testField = new TestField();
        for (;f <= m;f++ ) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            testField = session.get(TestField.class,f);
            ShipPosition.add(testField.getName());
            session.save(testField);
            transaction.commit();
        }
        sessionFactory.close();
        ShipPosition.forEach(System.out::print);
        System.out.println();
        return ShipPosition;
    }

    public Boolean Bang() {
        Hello hello = new Hello();
        if (ShipPosition.contains(hello.shot)) {
            bang = true;
        } else
            bang = false;
        return bang;
    }

    public int Id() {
        Hello hello = new Hello();
        id = 0;
        for (Object ele: ShipPosition) {
            if (!(hello.shot == ele)) {
                id++;
            }
            else
                break;
        }
        return id;
    }

    public void delShot() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Ships ships = new Ships();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            ships = session.get(Ships.class, id);
            ships.setName("a11");
            session.save(ships);
            transaction.commit();
            sessionFactory.close();
    }

    public String myShot() {
        int MyNumber = (int) (Math.random() * 10);
        int NumberMyLetter = (int) (Math.random() * 10);
            switch (NumberMyLetter) {
                case 1:
                    MyLetter = "a";
                    break;
                case 2:
                    MyLetter = "b";
                    break;
                case 3:
                    MyLetter = "c";
                    break;
                case 4:
                    MyLetter = "d";
                    break;
                case 5:
                    MyLetter = "e";
                    break;
                case 6:
                    MyLetter = "f";
                    break;
                case 7:
                    MyLetter = "g";
                    break;
                case 8:
                    MyLetter = "h";
                    break;
                case 9:
                    MyLetter = "i";
                    break;
                case 10:
                    MyLetter = "j";
                    break;
            }
            MyShot = (MyLetter + MyNumber);
        return MyShot;
    }

    public String Answer() {
        System.out.println(myShot());
        System.out.println("Попал?");
        answer = scanner.nextLine();
        return answer;
    }

    public void Next() {
        Placement placement = new Placement();
        System.out.println("Мой ход");
        myShot();
        Answer();
        if (answer.equals("yes")) {
            Next();
            placement.tableMyShot(mutable);
        }

    }

    public String War() {
        Hello hello = new Hello();
        hello.getShot();
        Position(1,10);
        Bang();
        if(!bang) {
            Next();
            mutable++;
            }
        else {
            Id();
            delShot();
            War();
        }
        Answer();
        if (answer.equals("yes")) {

        }
        return MyShot;
    }
}
