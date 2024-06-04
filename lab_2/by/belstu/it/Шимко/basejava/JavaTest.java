package by.belstu.it.Шимко.basejava;


import java.util.Arrays;

import static java.lang.Math.*;


@Deprecated // Класс устарел
public class JavaTest {
    static int sint;

     // TODO JavaTest Class

    //c
    final int FIRST_TYPE = 10;
    public final int SECOND_TYPE = 10;
    public static final int THIRD_TYPE = 10;



    public static void main(String[] args) {
        // a
        JavaTest object = new JavaTest();
        char char_var = 'b';
        int int_var = 1245;
        short short_var = 21;
        byte byte_var = 12;
        long long_var = 100000;
        boolean boolean_var = true;
        // b

        var result_1 = "string" + 5;  // "string5"
        var result_2 = "string" + 'c';  // "stringc"
        var result_3 = "string" + 1.2323;  // "string1.2323"
        byte result_4 = (byte) (byte_var + int_var);  // Не забывайте о приведении типов
        int result_5 = (int) (12.34343 + (long) 212312);  // Приведение к int
        long result_6 = (long) (int_var + 2147483647);  // Приведение к long
        boolean result_7 = true && false;  // false
        boolean result_8 = true ^ false;  // true
        // true + false;  - Это не является допустимым выражением
        long number1 = 9223372036854775807L;
        long number2 = 0x7fff_ffff_fffL;
        System.out.println("Статическая переменная:" + sint);
        char char1 = (char) (char_var - 'a');
        char char2 = '\u0061';
        char char3 = 97;
        int sumOfChars = char1 + char2 + char3;
        System.out.println("Сумма символов: " + sumOfChars);

        double result_mod = 3.45 % 2.4;
        System.out.println("Остаток от деления 3.45 на 2.4: " + result_mod);

        double result_div1 = 1.0 / 0.0;
        System.out.println("Результат деления 1.0 на 0.0: " + result_div1);

        double result_div2 = 0.0 / 0.0;
        System.out.println("Результат деления 0.0 на 0.0: " + result_div2);

        double result_log = Math.log(-345);
        System.out.println("Результат логарифма от -345: " + result_log);

        float result_float1 = Float.intBitsToFloat(0x7F800000);
        System.out.println("Результат для 0x7F800000: " + result_float1);

        float result_float2 = Float.intBitsToFloat(0xFF800000);
        System.out.println("Результат для 0xFF800000: " + result_float2);


        // d

        System.out.println("PI: " + PI);
        System.out.println("E:" + E);
        System.out.println("Round PI: " + Math.round(PI));
        System.out.println("Round E: " + Math.round(E));
        System.out.println("Min(P,E): " + Math.min(PI,E));
        System.out.println("Random [0,1): " + Math.random() % 1);


        //e

        // Создание объектов оболочек
        Boolean boolObj1 = true;
        Boolean boolObj2 = false;

        Character charObj1 = 'A';
        Character charObj2 = 'B';

        Integer intObj1 = 10;
        Integer intObj2 = 5;

        Byte byteObj1 = 20;
        Byte byteObj2 = 3;

        Short shortObj1 = 30;
        Short shortObj2 = 7;

        Long longObj1 = 100L;
        Long longObj2 = 25L;

        Double doubleObj1 = 3.14;
        Double doubleObj2 = 2.0;

        System.out.println("Арифметические операции:");
        System.out.println("intObj1 + intObj2 = " + (intObj1 + intObj2));
        System.out.println("doubleObj1 * doubleObj2 = " + (doubleObj1 * doubleObj2));
        System.out.println();

        System.out.println("Логические операции:");
        System.out.println("boolObj1 && boolObj2 = " + (boolObj1 && boolObj2));
        System.out.println("boolObj1 || boolObj2 = " + (boolObj1 || boolObj2));
        System.out.println();

        System.out.println("Битовые операции:");
        System.out.println("byteObj1 & byteObj2 = " + (byteObj1 & byteObj2));
        System.out.println("shortObj1 << 2 = " + (shortObj1 << 2));
        System.out.println();

        System.out.println("MIN_VALUE и MAX_VALUE для Long: " + Long.MIN_VALUE + " " + Long.MAX_VALUE);
        System.out.println("MIN_VALUE и MAX_VALUE для Double: " + Double.MIN_VALUE + " " + Double.MAX_VALUE);
        System.out.println();

        int primitiveInt = intObj1;
        Integer newIntObj = primitiveInt;

        byte primitiveByte = byteObj1;
        Byte newByteObj = primitiveByte;

        System.out.println("Методы для Integer:");
        System.out.println("Integer.parseInt(\"123\") = " + Integer.parseInt("123"));
        System.out.println("Integer.toHexString(255) = " + Integer.toHexString(255));
        System.out.println("Integer.compare(5, 10) = " + Integer.compare(5, 10));
        System.out.println("Integer.toString(42) = " + Integer.toString(42));
        System.out.println("Integer.bitCount(255) = " + Integer.bitCount(255));
        System.out.println("Double.isNaN(3.14) = " + Double.isNaN(3.14));



        //f

        String randomString = "2345";

//      int firstVariant = new Integer(randomString); Устарело с 9 версии Java
        int secondVariant = Integer.parseInt(randomString);
        System.out.println("Parse value: " + secondVariant);
        int thirdVariant = Integer.valueOf(randomString);
        System.out.println("Value of: " + thirdVariant);
        byte[] byteArray = randomString.getBytes();
        System.out.println("String bytes: " + byteArray);
        String restoredString = new String(byteArray);
        System.out.println("Restored string: " + restoredString);

        String BoolTrue = "true";
        String BoolFalse = "false";

        boolean true_val = Boolean.parseBoolean(BoolTrue);
        System.out.println("First boolean: " + true_val);

        boolean false_val = Boolean.parseBoolean(BoolFalse);
        System.out.println("Second boolean:" + false_val);

        String firstString = "value";
        String secondString = "value";

        String str1 = "Hello, World!";
        String str2 = "Hello, World!";

        boolean isEqual1 = (str1 == str2);
        System.out.println("Using == : " + isEqual1);
        boolean isEqual2 = str1.equals(str2);
        System.out.println("Using equals: " + isEqual2);

        int compareToResult = str1.compareTo(str2);
        System.out.println("Using compareTo: " + compareToResult);

        str1 = null;

        boolean isEqual3 = (str1 == str2);
        System.out.println("Using == (with null): " + isEqual3);

        boolean isEqual4 = str2.equals(str1);
        System.out.println("Using equals (with null): " + isEqual4);

//        int compareToResult2 = str2.compareTo(str1);
//        System.out.println("Using compareTo (with null): " + compareToResult2);   // NullPointerException

        String stringToOperate = "This some text for testing methods";
        String[] spilitArray = stringToOperate.split("\\s");
        System.out.println("Split: " + Arrays.toString(spilitArray));
        System.out.println("Contains(text): " + stringToOperate.contains("text"));
        System.out.println("Contains(function): " + stringToOperate.contains("function"));
        System.out.println("HashCode:" + stringToOperate.hashCode());
        System.out.println("Index of (text): " + stringToOperate.indexOf("text"));
        System.out.println("Length: " + stringToOperate.length());
        System.out.println("Replace text->information : " + stringToOperate.replace("text" , "information"));

        //g

        char[][] c1;
        char[] c2[];
        char c3[][];

        // Empty Array

        int[] emptyArr = new int[0];

        int[] arr = {1 , 2 , 3};

        //System.out.println(arr[5]); ArrayIndexOutBoundsException

        c1 = new char[3][];

        c1[0] = new char[5];
        c1[1] = new char[10];
        c1[2] = new char[15];

        System.out.println("Rows in c1 : " + c1.length);

        for (int i = 0 ; i < c1.length ; i++)
        {
            System.out.println("c1[" + i + "]" + " --> "  + c1[i].length);
        }


        c2 = new char[][]{{'a', 'b'}, {'c', 'd', 'e'}, {'f', 'g', 'h', 'i'}};
        c3 = new char[][]{{'1', '2', '3'}, {'4', '5', '6', '7'}, {'8', '9', '0', 'A', 'B'}};

        boolean ComRez = c2 == c3;

        System.out.println("ComRez: " + ComRez);

        c2 = c3;

        ComRez = c2==c3;
        System.out.println("isEqual:" + ComRez);

        for (char[] item : c2)
        {
            System.out.println(Arrays.toString(item));
        }


        //h

        WrapperString obj = new WrapperString("Testing");

        obj.replace('t' , 'b');

        WrapperString anonim = new WrapperString("Testing")
        {
            @Override
            public void replace(char oldChar , char newChar)
            {
                System.out.println(this.getStr().replace(newChar , oldChar));
            }

            public void delete(char newChar)
            {
                System.out.println("delete");
            };
        };

        anonim.replace('b' , 'g');


















    }
}
