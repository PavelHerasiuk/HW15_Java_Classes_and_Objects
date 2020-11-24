package by.epam.test1.main;

public class CheckTest1 {
    public static void main(String[] args) {
        Test1 one = new Test1();

        one.printVar();
        System.out.println("\nСуммма: " + one.getSum());
        System.out.println("Максимум: " + one.getMax());

        System.out.print("\nСмена переменных:");
        one.setA(20);
        one.setB(5);

        System.out.println();
        one.printVar();
        System.out.println("\nСуммма: " + one.getSum());
        System.out.println("Максимум: " + one.getMax());
    }
}