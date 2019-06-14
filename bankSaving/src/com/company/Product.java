package com.company;

import java.util.Scanner;

public class Product {

    int money, month;
    float rate;
    float result = 0;

    float calculate(){
        result = (rate * money / 12) * month * (month + 1) / 2;
        return result;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Product p1 = new Product();

        int m, y;
        float r;

        System.out.print("적금상품에 매달 넣을 적금 금액을 입력하세요(만원): ");
        m = s.nextInt();
        p1.money = m;
        System.out.println();

        System.out.print("적금상품의 적금기간을 입력하세요(1년=1, 2년=2, 3년=3): ");
        y = s.nextInt();
        p1.month = y * 12;
        System.out.println();

        System.out.print("적금상품의 이율을 입력하세요: ");
        r = s.nextFloat();
        p1.rate = r;
        System.out.println();

        System.out.println("이 상품으로 만기 시 " + p1.calculate() + "만원입니다.");
    }
}
