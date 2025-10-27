package com.example.kiosk;

import java.util.List;
import java.util.Scanner;

public class Kiosk { // 프로그램 순서 및 흐름 제어 담당

        // 속성
        private List<Menu> categories;
        private Scanner sc  = new Scanner(System.in);

        // 생성자
        public Kiosk(List<Menu> categories) {
            this.categories = categories;
        }


        // 기능
        public void start() {

        while (true) {


        // main 함수에서 MenuItem 클래스를 활용하여 햄버거 메뉴를 출력합니다.
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < categories.size(); i++) {
                System.out.println(i + 1 + ". " + categories.get(i).getName());
            }
            System.out.println("0. 종료");
            System.out.println("카테고리를 알맞은 번호로 입력하세요.");


            if(!sc.hasNextInt()) {
                sc.next();
                System.out.println("올바른 입력이 아닙니다.");
                continue;
            }
            int choiceMenu= sc.nextInt();
            if(choiceMenu == 0) {
                System.out.println("종료되었습니다.");
                break;
            } else if (1 <= choiceMenu && choiceMenu <= categories.size()){   // 리스트 사이즈까지 범위 허용 (범위검사
                System.out.println(categories.get(choiceMenu - 1).getName() + "를(을) 선택하셨습니다");
            } else {
                System.out.println("올바른 입력이 아닙니다.");
            }

            Menu choiceItems = categories.get(choiceMenu - 1);
            List<MenuItem> items = choiceItems.getMenuItems();
            for (int i = 0; i < items.size(); i++) {
                System.out.println(i + 1 + ". ");
                items.get(i).printMenu();
            }

            System.out.println("0. 뒤로가기");
            if(!sc.hasNextInt()) {
                sc.next();
                System.out.println("올바른 입력이 아닙니다.");
                continue;
            }



        }

        sc.close();
    }
}
