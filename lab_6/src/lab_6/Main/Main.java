package lab_6.Main;

import lab_6.DAO.LettersDAOImpl;
import lab_6.Models.User;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LettersDAOImpl lettersManager = new LettersDAOImpl();

        lettersManager.openConnection();

        User minLetterLengthUser =  lettersManager.getMinLetterLengthUser();

        System.out.println("ID пользователя с самым коротким письмом - " + minLetterLengthUser.getId());
        System.out.println("Информация о письмах пользователей: ");
        lettersManager.getUsersLetterInfo();
        List<User> usersBySubject = lettersManager.getUsersByReceivedLetterSubject("Приветствие");
        System.out.println("Пользователи, которые получали письма с темой \"Приветствие\"");
        for (User user : usersBySubject) {
            System.out.println(user);
        }
        System.out.println();
        System.out.println("Пользователи, которые не получали письма с темой \"Приветствие\" ");
        List<User> usersByNotReceivedSubject = lettersManager.getUsersByNotReceivedLetterSubject("Приветствие");

        for (User user : usersByNotReceivedSubject) {
            System.out.println(user);
        }

        System.out.println("Отправление письма с заданного человека с заданной темой");
        Date currentDate = new Date();
        currentDate.setYear(1990);
        currentDate.setMonth(Calendar.JUNE);
        currentDate.setDate(15);

        User user = new User(1, "Иван Иванов", currentDate);
        lettersManager.sendLetterToAllRecipients(user, "Я мусульман" , "Боже чел, забайчен на письмо!");


    }
}
