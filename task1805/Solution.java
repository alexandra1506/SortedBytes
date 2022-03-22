package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        //создаем объект FileInputStream, привязанный к файлу
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream inputStream = new FileInputStream(filename);

        // массив из 256, заполняем его нулями.  когда считываем символ из файла, то инкрементируется соответсвующий элемент
        int []array = new int[256];

        for(int i = 0; i < 256; i++){
            array[i] = 0;
        }

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            array[data]++; //инкрементируется соответсвующий элемент
        }
        inputStream.close(); // закрываем поток

        for (int i = 0; i < 256; i++) {
            if (!(array[i] == 0)) { // если элемент не нулевой, значит печатаем его индекс
                System.out.print(i + " "); //
            }
        }
    }
}
