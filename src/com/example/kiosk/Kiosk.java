package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk { // 프로그램 순서 및 흐름 제어 담당


        /* 헷갈려서 적어놓음
        * List<Menu> categories = 카테고리 목록들                      선택한 거 저장 : choiceCategory
        * List<MenuItem> burger,drink, sideMenu = 카테고리별 메뉴      선택한 거 저장 : choiceMenu
        * List<MenuItem> items = 선택한 카테고리의 메뉴들                선택한 거 저장 : choiceItem
        * MenuItme choiceOrder = 선택한 메뉴 딱 하나
        *
        * List<Cart> cartList = 장바구니 객체
        *
        * 와 더 헷갈림
        * */



        // 속성
        private List<Menu> categories;
        private Scanner sc  = new Scanner(System.in);
        MenuItem choiceOrder;
        List<MenuItem> cartList = new ArrayList<MenuItem>();

        // 생성자
        public Kiosk(List<Menu> categories) {
            this.categories = categories;
        }


        // 기능

        // 키오스크 시작
        public void start() {

        while (true) {


        // 카테고리 메뉴 출력 및 입력 부분
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < categories.size(); i++) {
                System.out.println(i + 1 + ". " + categories.get(i).getName());
            }
            System.out.println("0. 종료");
            System.out.println("카테고리를 알맞은 번호로 입력하세요.");


            if(!sc.hasNextInt()) { // 호환성 검사(숫자가 아닐시)
                sc.next();
                System.out.println("올바른 입력이 아닙니다.");
                continue;
            }
                int choiceCategory= sc.nextInt();
            while(true) {
                if(choiceCategory == 0) {
                    System.out.println("종료되었습니다.");
                    break;
                } else if (1 <= choiceCategory && choiceCategory <= categories.size()){   // 리스트 사이즈까지 범위 허용 (범위검사
                    System.out.println(categories.get(choiceCategory - 1).getName() + "를(을) 선택하셨습니다");
                    break;
                } else {// 옵션 외 숫자 입력시
                    System.out.println("올바른 입력이 아닙니다.");
                }
            }

            // 선택한 카테고리의 메뉴 출력 후 입력받은 메뉴 출력 부분
            Menu choiceMenu = categories.get(choiceCategory - 1); // 선택된 카테고리 안의 메뉴들 가져오기
            while (true) {
                System.out.println("[ " + choiceMenu.getName() +  " ]");
                List<MenuItem> items = choiceMenu.getMenuItems();

                for (int i = 0; i < items.size(); i++) {
                    System.out.print(i + 1 + ". ");
                    System.out.println(items.get(i).getPrintMenu());
                }

                System.out.println("0. 뒤로가기");
                System.out.println("메뉴를 알맞은 번호로 입력하세요.");

                if(!sc.hasNextInt()) {
                    sc.next();
                    System.out.println("올바른 입력이 아닙니다.");
                    continue;
                }
                int choiceItem = sc.nextInt();
                if (choiceItem == 0) {
                   break;
                } else if (1 <= choiceItem && choiceItem <= items.size()){   // 리스트 사이즈까지 범위 허용 (범위검사
                    MenuItem choiceOrder= items.get(choiceItem - 1); // 선택한 메뉴 가져오기 ex(A버거

                    System.out.println(choiceOrder.getPrintChoicMenu() + " \n  위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인           2. 취소");
                    if(!sc.hasNextInt()) {
                        sc.next();
                        System.out.println("올바른 입력이 아닙니다.");
                        continue;
                    }
                } else {
                   System.out.println("올바른 입력이 아닙니다.");
                }
                int cartAnswer = sc.nextInt();

                switch (cartAnswer) {
                    case 1:
                    cartList.add(choiceOrder);
                    break;
                    case 2:
                        break;
                }

            }
            break;
        }

        sc.close();
    }
}
