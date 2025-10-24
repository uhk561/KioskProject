package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class MenuItem { //세부 메뉴 속성을 가지는 클래스

    // 속성
    private String name;
    private double price;
    private String info;


    // 생성자
    public MenuItem(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    // 기능
    public void printMenu() { // 메뉴출력
        System.out.println(name + " | " + "W " + price + " | " + info);
    }

    // 게터
    public String getName() {
        return this.name;
    }
}
