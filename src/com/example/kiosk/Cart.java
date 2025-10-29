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


    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }


    public  void addCountQuantity(int count) {
        this.quantity += count;
    }

}

