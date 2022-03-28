import javax.persistence.*;

@Entity
@Table(name = "neabattleship")
public class NeaShips
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "neabattleship_id")
    private  int id;

    @Column(name = "name_neabattleship")
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