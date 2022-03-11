import javax.persistence.*;

    @Entity
    @Table(name = "battleship")
    public class Ships
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "battleship_id")
        private  int id;

        @Column(name = "name_battleship")
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
