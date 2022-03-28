public class Main
{

    public static void main(String[] args)
    {
//        Hello hello = new Hello();
//        hello.checkEntrants();
//        if (hello.exit.equals("Пока")) {
//            System.exit(0);
//        }
//        hello.getShot();

        Placement placement = new Placement();

        placement.testBattlePlacement(1,82);
        placement.battlePlacement(1, 4);
        placement.neaBattlePlacement(1,14);

        placement.testCruiserPlacement(1,67);
        placement.cruiserPlacement(5,7);
        placement.neaCruiserPlacement(15,26);

        placement.testSecondPlacement(1, SecondCruiserPosition.count);
        placement.secondPlacement(8,10);
        placement.neaSecondPlacement(27,38);


//        SecondCruiserPosition secondCruiserPosition = new SecondCruiserPosition();
//        secondCruiserPosition.testFieldPosition();

    }
}
