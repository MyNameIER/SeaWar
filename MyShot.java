import javax.persistence.*;

@Entity
@Table(name = "myshot")
public class MyShot
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "myshot_id")
    private  int id;

    @Column(name = "name_myshot")
    private  String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


