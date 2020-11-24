package by.epam.customer.main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
/*
 * 8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод  toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 *    Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 *    Найти и вывести:
 *    a) список покупателей в алфавитном порядке;
 *    b) список покупателей, у которых номер кредитной карточки находится в заданном интервале.
 */

public class Main {

    public static void main(String[] args) {
        CustomerBase vipClient = new CustomerBase("VIP clients", new ArrayList<>());

        vipClient.addCustomer("Pavlov", "Aleksei", "Sergeevich", "Minsk", new BigInteger("1111111111111111"), 72348678);
        vipClient.addCustomer("Markova", "Anastasia", "Vladislavovna", "Hrodno", new BigInteger("2222222222222222"), 23458789);
        vipClient.addCustomer("David", "Yegor", "Vasilievich", "Brest", new BigInteger("3333333333333333"), 38567891);
        vipClient.addCustomer("Tramp", "Svetlana", "Konstantinovna", "Mogilev", new BigInteger("4444444444444444"), 43698912);
        vipClient.addCustomer("Romanov", "Dmitry", "Antonovich", "Brest", new BigInteger("5555555555555555"), 46789523);

        System.out.println("Список покупателей в алфавитном порядке:");
        vipClient.sortName();
        for (int i = 0; i < vipClient.getBase().size(); i++) {
            System.out.println(vipClient.getBase().get(i));
        }

        System.out.println("\nСписок покупателей, у которых номер кредитной карточки находится в заданном интервале:");
        ArrayList<Customer> list = vipClient.getCustomerByCreditCardRange("2000000000000000", "5000000000000000");
        list.sort(Comparator.comparing(Customer::getCardNumber));
        if (list.size() == 0) {
            System.out.println("Банковские карты не найдены");
        } else {
            for (Customer customer : list) {
                System.out.println(customer);
            }
        }
    }
}