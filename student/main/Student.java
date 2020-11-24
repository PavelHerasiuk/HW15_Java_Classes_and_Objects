package by.epam.student.main;

/*
 * 3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер
 * группы, успеваемость (массив из пяти элементов). Создайте массив из десяти
 * элементов такого типа. Добавьте возможность вывода фамилий и номеров групп
 * студентов, имеющих оценки, равные только 9 или 10.
 */
public class Student {

    private final String name;
    private final int group;
    private final int[] grades;

    private Student(String name, int group, int[] grades) {
        this.name = name;
        this.group = group;
        this.grades = grades;
    }

    private static void printExcellentStudent(Student[] students) {
        for (Student student : students) {
            int minGrade = 10;
            for (int grade : student.grades) {
                if (grade < minGrade) {
                    minGrade = grade;
                }
            }
            if (minGrade >= 9) {
                System.out.printf("Excellent student: %s, from group %d. %n", student.name, student.group);
            }
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[10];

        students[0] = new Student("Parvanov A.K.", 1, new int[]{7, 8, 8, 7, 10});
        students[1] = new Student("Andrew A.I.", 2, new int[]{8, 8, 6, 10, 8});
        students[2] = new Student("Semyonov A.F.", 3, new int[]{3, 5, 8, 10, 6});
        students[3] = new Student("Pavlov A.T.", 4, new int[]{10, 10, 10, 9, 10});
        students[4] = new Student("Zhukov A.C.", 2, new int[]{9, 9, 9, 9, 9});
        students[5] = new Student("Markov A.H.", 8, new int[]{9, 8, 10, 10, 9});
        students[6] = new Student("Davidov I.V.", 4, new int[]{10, 9, 8, 10, 9});
        students[7] = new Student("Pancakes A.M.", 3, new int[]{4, 6, 7, 8, 7});
        students[8] = new Student("Lavrov D.A.", 6, new int[]{10, 9, 9, 10, 9});
        students[9] = new Student("Romanov A.S", 3, new int[]{10, 10, 10, 10, 9});

        printExcellentStudent(students);
    }
}