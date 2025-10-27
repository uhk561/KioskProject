package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main { // 시작지점이 되는 클래스

    public static void main(String[] args) {

        // List를 선언하고 객체생성과 동시에 이름, 가격, 설명 세팅
       List<MenuItem> menuItems = new ArrayList<>();
       menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
       menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
       menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
       menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Scanner 선언
        Scanner sc  = new Scanner(System.in);




       // main 함수에서 MenuItem 클래스를 활용하여 햄버거 메뉴를 출력합니다.
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
                System.out.print(i + 1 + ". ");
                menuItems.get(i).printMenu();
        }
        System.out.println("0. 종료");
        System.out.println("알맞은 번호를 입력하세요.");



        while(true) { // 숫자 입력 검사
            if(!sc.hasNextInt()) {
                sc.next();
                System.out.println("올바른 입력이 아닙니다.");
                continue;
            }
            int answer= sc.nextInt();
            if(answer == 0) {
                System.out.println("종료되었습니다.");
                break;
            } else if (1 <= answer && answer<= menuItems.size()){   // 리스트 사이즈까지 범위 허용 (범위검사
                System.out.println(menuItems.get(answer - 1).printChoicMenu() + "를 선택하셨습니다");
                break;
            } else {
                System.out.println("올바른 입력이 아닙니다.");
            }

        }
        sc.close();
    }
}



