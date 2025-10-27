package com.example.kiosk;


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

    public String printChoicMenu() { // 게터에서 변경(맞는 코드는 아닌 거 같음)
        return name + " | " + "W " + price + " | " + info;


    // 게터

    }
}
