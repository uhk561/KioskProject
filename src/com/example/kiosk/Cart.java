package com.example.kiosk;

public class Cart {

    // 속성
    private int quantity;
    private MenuItem menuItem;



    // 생성자
    public Cart (MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

}
