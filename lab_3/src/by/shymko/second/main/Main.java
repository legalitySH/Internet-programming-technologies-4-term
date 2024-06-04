package by.shymko.second.main;

import by.shymko.second.products.*;
import by.shymko.second.shopexception.*;
import by.shymko.second.store.Bookstore;
import by.shymko.second.store.Seller;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {


    static{
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }

    private static final Logger logger = LogManager.getLogger("Logger");
    public static void PrintMenu()
    {
        System.out.println("1 - Добавить издание");
        System.out.println("2 - Удалить издание");
        System.out.println("3 - Получить список изданий");
        System.out.println("4 - Получить общую стоимость магазина");
    }

    public static void PrintEditionTypes()
    {
        System.out.println("1 - Книга");
        System.out.println("2 - Журнал");
        System.out.println("3 - Газета");
    }

    public static void AddToBookstore(int editionType, Bookstore store) throws IssueFormatException, PriceFormatException, EmptyNameException, YearFormatException, NullPageException, IOException {
        Scanner scanner = new Scanner(System.in);
        switch (editionType)
        {
            case 1:
            {
                System.out.println("Введите название книги:");
                String title = scanner.nextLine();

                System.out.println("Введите цену книги:");
                double price = scanner.nextDouble();

                Genre genre = Genre.DEFAULT;
                SetChosenGenre(genre);

                System.out.println("Введите год издания");
                int year = scanner.nextInt();
                System.out.println("Введите автора");
                String author = scanner.nextLine();
                author = scanner.nextLine();
                System.out.println("Введите количество страниц");
                int pagesCount = scanner.nextInt();

                Book newBook = new Book(title,price,genre,year,logger,author,pagesCount);
                store.add(newBook);

                break;
            }
            case 2:
            {
                System.out.println("Введите название журнала:");
                String title = scanner.nextLine();

                System.out.println("Введите цену журнала:");
                double price = scanner.nextDouble();

                Genre genre = Genre.DEFAULT;
                SetChosenGenre(genre);

                System.out.println("Введите год издания");
                int year = scanner.nextInt();
                System.out.println("Введите номер выпуска");
                String issue = scanner.nextLine();

                Magazine newMagazine = new Magazine(title,price,genre,year,logger,issue);
                store.add(newMagazine);
                break;
            }
            case 3:
            {
                System.out.println("Введите название газеты:");
                String title = scanner.nextLine();

                System.out.println("Введите цену газеты:");
                double price = scanner.nextDouble();

                Genre genre = Genre.DEFAULT;
                SetChosenGenre(genre);

                System.out.println("Введите год издания");
                int year = scanner.nextInt();

                Newspapper newspapper = new Newspapper(title,price,genre,year,logger);
                store.add(newspapper);
                break;
            }
            default:
            {
                System.out.println("Неверный вариант ответа");
            }
        }
    }

    public static void SetChosenGenre(Genre genre)
    {
        System.out.println("Выберите жанр книги:");
        System.out.println("1 - Вымысел");
        System.out.println("2 - Научно-популярный");
        System.out.println("3 - Детективный");
        System.out.println("4 - Роман");
        System.out.println("5 - Научная фантастика");
        System.out.println("6 - Ужастик");
        Scanner scanner = new Scanner(System.in);
        int genreChoice = scanner.nextInt();
        switch (genreChoice)
        {
            case 1:
            {
                genre = Genre.FICTION;
                break;
            }
            case 2:
            {
                genre = Genre.NON_FICTION;
                break;
            }
            case 3:
            {
                genre = Genre.MYSTERY;
                break;
            }
            case 4:
            {
                genre = Genre.ROMANCE;
                break;
            }
            case 5:
            {
                genre = Genre.SCIENCE_FICTION;
                break;
            }
            case 6:
            {
                genre = Genre.HORROR;
            }
        }
    }


    public static void main(String[] args) throws PriceFormatException, NullPageException, EmptyNameException, YearFormatException, IssueFormatException, EditionFindException, IOException {
        try
        {
            logger.info("Start program");
            Bookstore store = new Bookstore(logger);
            Seller seller = new Seller(logger);
            while (true)
            {
                PrintMenu();
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                switch (choice)
                {
                    case 1:
                    {
                        System.out.println("Выберите тип издания: ");
                        PrintEditionTypes();
                        int  editionType = scanner.nextInt();
                        AddToBookstore(editionType,store);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Введите название для удаления");
                        String deletedName = scanner.nextLine();
                        deletedName = scanner.nextLine();
                        Edition deletedEdition = store.getEditionByTitle(deletedName);
                        store.Remove(deletedEdition);
                        break;
                    }
                    case 3:
                    {
                        List<Edition> editionList = store.getEditionList();
                        for (Edition edition : editionList) {
                            System.out.println(edition);
                        }
                        break;
                    }
                    case 4:
                    {
                        if(store.getEditionList().size() == 0)
                        {
                            System.out.println("Общая цена магазина = 0");
                        }
                        else
                        {
                            System.out.println("Общая цена магазина = " + store.GetOverPrice());
                        }
                        break;
                    }
                    default:
                    {
                        System.out.println("Неверный вариант ответа");
                    }
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
