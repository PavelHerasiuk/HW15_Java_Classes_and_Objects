package by.epam.train.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления. Создайте данные
 * в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по номерам поездов.
 * Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами назначения
 * должны быть упорядочены по времени отправления.
 */
public class Train {

    private final String destination;
    private final String trainNumber;
    private final Date departureTime;
    private static final SimpleDateFormat ft = new SimpleDateFormat("HH:mm");

    private Train(String destination, String trainNumber, Date departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    private static void sortTrainNumber(Train[] trains) {
        Train temp;
        for (int i = 0; i < trains.length; i++) {
            for (int j = trains.length - 1; j > i; j--) {
                if (trains[i].trainNumber.compareTo(trains[j].trainNumber) > 0) {
                    temp = trains[i];
                    trains[i] = trains[j];
                    trains[j] = temp;
                }
            }
        }
    }

    private static void sortTrainDestination(Train[] trains) {
        Train temp;
        for (int i = 0; i < trains.length; i++) {
            for (int j = trains.length - 1; j > i; j--) {
                int compare = trains[i].destination.compareTo(trains[j].destination);
                if (compare > 0) {
                    temp = trains[i];
                    trains[i] = trains[j];
                    trains[j] = temp;
                } else if (compare == 0) {
                    if (trains[i].departureTime.compareTo(trains[j].departureTime) > 0) {
                        temp = trains[i];
                        trains[i] = trains[j];
                        trains[j] = temp;
                    }
                }
            }
        }
    }

    private static String printTrainInformation(Train[] trains, String trainNumber) {

        for (Train train : trains) {
            if (train.trainNumber.equalsIgnoreCase(trainNumber)) {
                return "destination: " + train.destination + ", departure time: " + ft.format(train.departureTime);
            }
        }
        return null;
    }

    public static void main(String[] args) throws ParseException {
        Train[] trains = new Train[5];
        trains[0] = new Train("Minsk", "123A", ft.parse("20:30"));
        trains[1] = new Train("Hrodna", "345A", ft.parse("12:35"));
        trains[2] = new Train("Brest", "657I", ft.parse("14:45"));
        trains[3] = new Train("Hrodno", "789V", ft.parse("17:35"));
        trains[4] = new Train("Minsk", "102Z", ft.parse("06:55"));
        System.out.println("Список номеров поездов: ");

        sortTrainNumber(trains);

        //проверка сортировки по номерам
        for (Train train : trains) {
            System.out.println(train.trainNumber);
        }

        //вывод информации о поезде по его номеру
        String request = "345A";
        System.out.printf("%n Train #%s, ", request);
        System.out.println(printTrainInformation(trains, request) + "\n");

        sortTrainDestination(trains);

        //проверка сортировки по пункту назначения
        for (Train train : trains) {
            System.out.println(train.destination + " " + train.trainNumber + " - " + ft.format(train.departureTime));
        }
    }
}