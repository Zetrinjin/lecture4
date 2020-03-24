package com.company;

/*Создать класс, описывающий банкомат.Набор купюр, находящихся в банкомате должен задаваться тремя свойствами
 :количеством купюр номиналом 20, 50 и 100. Сделать методы для добавления денег в банкомат.
 Сделать функцию, снимающую деньги, которая принимает сумму денег,а возвращает булевое значение -успешность
 выполнения операции.При снятии денег функция должна распечатывать каким количеством купюр какого номинала
 выдаётся сумма.Создать конструктор с тремя параметрами -количеством купюр каждого номинала*/

import java.util.Scanner;

public class Atm {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int money20,money50,money100;

        System.out.println("введите количество денег для добавлнения в банкомат");
        System.out.println("введите количество купюр номиналом 20");
        CashMashine money = new CashMashine();
        money20=sc.nextInt();
        money.addMoney20(money20);
        System.out.println("введите количество купюр номиналом 50");
        money50=sc.nextInt();
        money.addMoney50(money50);
        System.out.println("введите количество купюр номиналом 100");
        money100=sc.nextInt();
        money.addMoney100(money100);
        money.allMoney();

        System.out.println("введите количество денег для снятия");
        int moneypeople;
        moneypeople =sc.nextInt();
       if(money.giveMoney(moneypeople)){

           System.out.println("операция успешно выполнена");
       }
       else {
           System.out.println("нет купюр такого номинала");
       }

       CashMashine countmoney = new CashMashine(money.money20,money.money50,money.money100);


    }

    static class CashMashine{

        private int money20;
        private int money50;
        private int money100;
        private int allmoney;
        int peoplemoney;
        int moneycheck;
        int countmoney20;
        int countmoney50;
        int countmoney100;
        boolean fl;

        public CashMashine(){

        }

        public void addMoney20(int money20){
            this.money20 = money20;
        }
        public void addMoney50(int money50){
            this.money50 = money50;
        }
       public void addMoney100(int money100){
            this.money100 = money100;
        }

        public void allMoney()
        {
            this.allmoney = 20*this.money20 + 50*this.money50 + 100*this.money100;
        }

       public boolean giveMoney(int money){
            System.out.println("всего денег:" + this.allmoney);
            this.peoplemoney = money;
            for(moneycheck=this.peoplemoney; ;){

                moneycheck = this.peoplemoney%100;
                moneycheck = moneycheck%50;
                moneycheck = moneycheck%20;
                break;
            }

            if(peoplemoney<allmoney && moneycheck == 0){

                allmoney -= peoplemoney;
                countmoney100 = peoplemoney/100;
                peoplemoney =peoplemoney%100;
                countmoney50 = peoplemoney/50;
                peoplemoney = peoplemoney%50;
                countmoney20 = peoplemoney/20;
                peoplemoney = peoplemoney%20;
                System.out.println("количество снятых денег:купюр по 100-" + countmoney100 + ",купюр по 50-"
                        + countmoney50 + ",купюр по 20-" + countmoney20);

                fl =true;
            }

            return fl;
        }

       public CashMashine(int money20, int money50, int money100){

            this.money20 = money20;
            this.money50 = money50;
            this.money100 = money100;
          /* System.out.println("количество снятых денег:купюр по 100-" + this.money100 + ",купюр по 50-"
                   + this.money50 + ",купюр по 20-" + this.money20);*/
        }

    }
}
