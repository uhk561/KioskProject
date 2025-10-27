package com.example.kiosk;

import java.util.List;

public class Menu {// MenuItem클래스를 관리하는 클래스

    // 속성
    private String name; // 카테고리 이름 ex) burger , drink
    private List<MenuItem> menuItems; // 카테고리 안에 들어있는 메뉴리스트 ex) A버거, B버거 등등

    // 생성자
    public Menu(String name, List<MenuItem> menuItems) {
        this.name = name;
        this.menuItems = menuItems;
    }

    // 기능
    public void printcategories() { // 카테고리출력
        System.out.println(name);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getName() {
        return name;
    }

}
