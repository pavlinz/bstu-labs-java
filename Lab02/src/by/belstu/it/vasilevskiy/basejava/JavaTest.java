package by.belstu.it.vasilevskiy.basejava;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Wrapper;
import java.util.Arrays;

import static java.lang.Math.*;


/**
 * author Vasilevskiy Pavel
 * version 1.0
 */


public class JavaTest {

    static int sint;

    final int firstConst = 10;
    public final int secondConst = 20;
    public static final int thirdConst = 30;

    public static void main(String[] args) throws IOException {

        String strVar = "String";
        int iVar = 5;
        short sVar = 123;
        byte bVar = 100;
        long lVar = 123131312L;
        boolean boolVar = true,
                falseBoolVar = false;
        double dVar = 1231413133;

        // Операции над переменными

        System.out.println(strVar + iVar);
        System.out.println(strVar + dVar);
        // bVar = bVar + (byte)iVar; Ошибка
        // iVar = dVar + lVar; Ошибка
        System.out.println(lVar = (long)iVar + 2147483647); // значение положительное
        System.out.println("Вывод значения неинициализированной статической переменной -> " + sint);
        System.out.println(boolVar && falseBoolVar);
        System.out.println(boolVar ^ falseBoolVar);
        long longVar = 9223372036854775807L;
        long sameVar = 0x7fff_ffff_fffL;
        char cVar = 'a',
             unVar = '\u0061',
             vVar = 97;
        System.out.println(cVar + " " + unVar + " " + vVar);



        System.out.println(3.45 % 2.4);
        System.out.println(1.0 / 0.0); // Infinity
        System.out.println(0.0 / 0.0); // NaN
        System.out.println(log(-345)); // NaN
        System.out.println(Float.intBitsToFloat(0x7F800000)); // Infinity
        System.out.println(Float.intBitsToFloat(0xFF800000)); // -Infinity
        System.out.println(Math.round(PI));
        System.out.println(E);
        System.out.println(Math.min(PI, E));
        System.out.println(Math.random());


        Integer iObj = new Integer(10);
        System.out.println(iObj>>1);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

        Integer inObj  = 20; // упаковка
        int iValue = 0;
        iValue = new Integer(10); // распаковка

        // Работа с методами Integer
        int value;
        System.out.println(value = Integer.parseInt("125"));
        System.out.println(Integer.toHexString(11));
        System.out.println(Integer.bitCount(10));

        // Работа со String-ом

        String str = "1234";
        String emptyStr = "";
        int s34 = Integer.valueOf(str);
        int s35 = Integer.parseInt(str);

        byte[] byteArr = str.getBytes("UTF-8");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bytes.write(byteArr);
        System.out.println("Строка байт на выходе -> " + bytes);

        String trueStr = "True";
        String falseStr = "no";
        boolean firstBool, secondBool;
        firstBool = Boolean.parseBoolean(trueStr);
        secondBool = Boolean.valueOf(falseStr);
        System.out.println("Преобразование с помощью parseBoolean -> " + firstBool);
        System.out.println("Преобразование с помощью valueOf -> " + secondBool);

        String forA = "Pip";
        String forB = "Pip";
        System.out.println("Сравнение == " + (forA == forB));
        System.out.println("equals сравнение " + forA.equals(forB));
        System.out.println("compareTo сравнение " + forA.compareTo(forB));
        forB = null;
        System.out.println("Сравнение == " + (forA == forB));
        System.out.println("equals сравнение " + forA.equals(forB));
        //System.out.println("compareTo сравнение " + forA.compareTo(forB)); Exception

        String someString = "some string some string";
        String[] arrStr = someString.split(" ", 3);
        System.out.println("Split ->" + Arrays.toString(arrStr));
        System.out.println("Строка содержит some -> " + someString.contains("some"));
        System.out.println("Строка содержит somesome -> " + someString.contains("somesome"));
        System.out.println("hashCode строки -> " + someString.hashCode());
        System.out.println("indexOf string -> " + someString.indexOf("tr"));
        System.out.println("length of string -> " + someString.length());
        System.out.println("replace -> " + someString.replace('o', 'a'));

        // многомерные массивы
        char[][] c1;
        char[] c2[];
        char c3[][];

        c1 = new char[3][];
        c1[0] = new char[2];
        c1[1] = new char[3];
        c1[2] = new char[4];

        System.out.println(c1.length + "-> {" + c1[0].length + " " + c1[1].length + " " + c1[2].length + "}");

        c2 = new char[3][];
        c2[0] = new char[2];
        c2[1] = new char[3];
        c2[2] = new char[4];

        c3 = new char[3][];
        c3[0] = new char[2];
        c3[1] = new char[3];
        c3[2] = new char[4];
        System.out.println(c2 == c3);

        double[] aq = {0.01, 0.2, -0.3, 4.5, -6.7};
        for (double x: aq) {
            System.out.println(x + " ");
        }

        // Работа с объектом WrapperString
        WrapperString ws = new WrapperString("Wrapper String");
        ws.replace('a', 'o');
        System.out.println(ws.toString());
    }
}
