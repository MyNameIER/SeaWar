public class Main {

    public static void main(String[] args) {
//        Hy();
//        whoFirst();
//    }
//    public static void Hy() {
//        Hello hello = new Hello();
//        hello.Hi();
//        if (hello.exit.equals("Пока")) {
//            System.exit(0);
//        }
//    }
//    public static void whoFirst() {
//        UserShot userShot = new UserShot();
//        Hello hello = new Hello();
//        hello.Hi();
//        System.out.println("Расставляю корабли");

        Placement placement = new Placement();

        placement.testBattlePlacement(1,82);
        placement.battlePlacement(1, 4);
        placement.neaBattlePlacement(1,14);

        placement.testCruiserPlacement(1,67);
        placement.cruiserPlacement(5,7);
        placement.neaCruiserPlacement(15,26);

        placement.testSecondPlacement(1, 52 + SecondCruiserPosition.count);
        placement.secondPlacement(8,10);
        placement.neaSecondPlacement(27,38);

//        System.out.println("Начинаем");
//        userShot.War();
//
//            userShot.myShot();
//            System.out.println(userShot.MyShot);
//            System.out.println("Твой ход");

        }
    }

