package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;


public class Main { // 시작지점이 되는 클래스

    public static void main(String[] args) {

        // 메뉴카테고리 객체 생성
        List<Menu> categories = new ArrayList<>();
        //List<MenuItem> menuItems = new ArrayList<>();

        // 메뉴  담기
        List<MenuItem> burger = new ArrayList<>();
        burger.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burger.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        categories.add(new Menu("Burgers", burger)); // 버거메뉴 담기

        List<MenuItem> drink = new ArrayList<>();
        drink.add(new MenuItem("coca-cola", 2.5, "콜라는 코카콜라"));
        drink.add(new MenuItem("pepsi-cola", 2.5, "제로콜라도 코카콜라"));
        drink.add(new MenuItem("zero-cocaCola", 2.5, "제로콜라도 코카콜라"));
        drink.add(new MenuItem("zero-pepsiCola", 2.5, "제로콜라도 펩시콜라"));
        categories.add(new Menu("Drinks", drink)); // 음료 담기

        List<MenuItem> sideMenu = new ArrayList<>();
        sideMenu.add(new MenuItem("Fries", 3.0, "햄버거에는 감튀 국룰"));
        sideMenu.add(new MenuItem("CheeseFries", 3.0, "체다치즈 소스를 뿌린 감튀"));
        sideMenu.add(new MenuItem("CheeseSticks", 2.7, "쭉 늘어나는 모짜렐라 치즈"));
        categories.add(new Menu("SideMenu", sideMenu)); // 사이드 담기







        Kiosk kiosk = new Kiosk(categories);
        kiosk.start();


    }
}



