import java.util.Scanner;

public class Hello {
    private Scanner scanner = new Scanner(System.in);
    private String shot;
    private boolean CheckShot;
    public String exit;
    private String[][] field = {{"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10"},
            {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10"},
            {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10"},
            {"d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10"},
            {"e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10"},
            {"f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10"},
            {"g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9", "g10"},
            {"h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10"},
            {"i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i10"},
            {"j1", "j2", "j3", "j4", "j5", "j6", "j7", "j8", "j9", "j10"}};

    public void checkEntrants() {
        System.out.println("Играем?");
        String question = scanner.nextLine();
        if (question.equals("yes")) {
            exit = "Продолжаем";
            int MachineNumber = (int) (Math.random() * 10);
            int YourNumber = (int) (Math.random() * 10);
            System.out.println("Бот число " + MachineNumber + " Твое число " + YourNumber);
            if (MachineNumber > YourNumber) {
                System.out.println("Ходит бот");
            } else {
                System.out.println("Твой ход");
                shot = scanner.nextLine();
            }
        } else {
            exit = "Пока";
            System.out.println(exit);
        }
    }

    public String getShot() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (shot.equals(field[i][j])) {
                    CheckShot = true;
                }
            }
        }
        if (CheckShot) {
            System.out.println("Хороший выстрел");
        } else {
            System.out.println("Пробуем еще раз");
            shot = scanner.nextLine();
            shot = getShot();
        }
        return shot;
    }
}
