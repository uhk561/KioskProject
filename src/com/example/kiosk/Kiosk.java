package com.example.kiosk;

import java.util.List;
import java.util.Scanner;

public class Kiosk { // 프로그램 순서 및 흐름 제어 담당

    // 속성
    private List<MenuItem> menuItems;
    private Scanner sc  = new Scanner(System.in);

    // 생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


    // 기능
    public void start() {


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
