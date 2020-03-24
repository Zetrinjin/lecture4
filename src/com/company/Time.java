package com.company;

/*Создать класс, описывающий промежуток времени.
Сам промежуток времени должен задаваться тремя свойствами: секундами, минутами и часами.
Создать метод для получения полного количества секунд в объекте
Создать два конструктора: первый принимает общее количество секунд, второй -часы, минуты и секунды по отдельности.
Создать метод для вывода данных.Написать программу для тестирования возможностей класса*/

import java.util.Scanner;

public class Time {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("введите количество секунд: ");
        int sec = sc.nextInt();

       /* if (sec <= 0){
            sec = 0;
        }*/

        TimeInterval secon = new TimeInterval(sec);
        secon.totalIntervalOfSeconds();

        /*System.out.println("введите количество минут: ");
        int min = sc.nextInt();
        System.out.println("введите количество часов: ");
        int hour = sc.nextInt();*/

        TimeInterval time = new TimeInterval();
        time.TimeOutput();

    }

    /*private static void TimeOutput(int secfortrans, int min, int hour) {

        if(secfortrans<=0){

            System.out.println("время: 0" );
        }
        else
         System.out.println("время:" + "часы-" + hour + ",минуты-" +  min + ",секунды-" + secfortrans);
    }*/

    static class TimeInterval {

       static int allseconds;
       static int seconds;
       static int minutes;
       static int hours;

        TimeInterval(int sec){

            allseconds = sec;
        }

       TimeInterval(){

            for(seconds = allseconds; seconds>60; ){
                if(seconds>60){
                    minutes +=1;
                    seconds -= 60;
                }
                if(minutes>60){
                    minutes -=60;
                    hours +=1;
                }
            }
        }

        void totalIntervalOfSeconds(){

            System.out.println("Общее количество секунд: " + allseconds);
        }

       void TimeOutput(){
           if(seconds<=0){

               System.out.println("время: 0" );
           }
           else
               System.out.println("время:" + "часы-" + hours + ",минуты-" +  minutes + ",секунды-" + allseconds);
       }
    }
}
