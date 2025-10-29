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
        List<Cart> cartList = new ArrayList<>();

        // 생성자
        public Kiosk(List<Menu> categories) {
            this.categories = categories;
        }


        // 기능

        // 키오스크 시작
        public void start() {

        while (true) {


        // 카테고리 메뉴 출력 및 입력 부분(메인메뉴)
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < categories.size(); i++) {
                System.out.println(i + 1 + ". " + categories.get(i).getName());
            }
            if (!cartList.isEmpty()) { // 장바구니가 비어있지 않다면
                System.out.println(" [ ORDER MENU ] ");
                System.out.println("4. Orders");
                System.out.println("5. Cancel");
            }
            System.out.println("0. 종료");
            System.out.println("카테고리를 알맞은 번호로 입력하세요.");


            if(!sc.hasNextInt()) { // 호환성 검사(숫자가 아닐시)
                sc.next();
                System.out.println("올바른 입력이 아닙니다.");
            }
                int choiceCategory= sc.nextInt();
                if(choiceCategory == 0) {
                    System.out.println("종료되었습니다.");
                    break;
                } else if (1 <= choiceCategory && choiceCategory <= categories.size()){   // 리스트 사이즈까지 범위 허용 (범위검사
                    System.out.println(categories.get(choiceCategory - 1).getName() + "를(을) 선택하셨습니다");
                } else if(choiceCategory == 5) { // 주문 취소시 장바구니 비움
                    cartList.clear();
                    System.out.println("진행중인 주문을 취소합니다");
                    continue;
                } else if(choiceCategory == 4) {
                    System.out.println(" [ Orders ] ");
                    double total = 0;
                    double itemTotal = 0;
                    for (int i = 0; i < cartList.size(); i++) {
                        System.out.print(cartList.get(i).getMenuItem().getName() + " | ");
                        System.out.print("W " + cartList.get(i).getMenuItem().getPrice() + " | ");
                        System.out.print(cartList.get(i).getMenuItem().getInfo());
                        System.out.println("    담은 수량 : " + cartList.get(i).getQuantity());
                        itemTotal += cartList.get(i).getMenuItem().getPrice() * cartList.get(i).getQuantity();
                    }
                    System.out.println(" [ Total ] ");
                    System.out.println(String.format("W " + "%.1f",itemTotal)); // 소수점 1자리 뒤부턴 자르기

                    System.out.println("1. 주문하기  "+ "2. 메뉴판으로 돌아가기");
                    if(!sc.hasNextInt()) {
                        sc.next();
                        System.out.println("올바른 입력이 아닙니다.");
                    }
                    int orderAnswer = sc.nextInt();
                    if(orderAnswer == 1) {
                        System.out.println(String.format("주문이 완료되었습니다. 금액은 W " + "%.1f",itemTotal) + " 입니다");
                        cartList.clear(); // 주문완료되었으니 다시 비움
                        continue;
                    } else if(orderAnswer == 2) {
                        continue;
                    }
                } else {// 옵션 외 숫자 입력시
                    sc.next();
                    System.out.println("올바른 입력이 아닙니다.");
                    continue;
                }
            Menu choiceMenu = categories.get(choiceCategory - 1); // 선택된 카테고리 안의 메뉴들 가져오기

            // 선택한 카테고리의 메뉴 출력 후 입력받은 메뉴 출력 부분
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
                    choiceOrder= items.get(choiceItem - 1); // 선택한 메뉴 가져오기 ex(A버거

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
                boolean isCart = false;
                if (cartAnswer == 1) {
                    for (int i = 0; i < cartList.size(); i++) {
                        if(cartList.get(i).getMenuItem().equals(choiceOrder)) { // 선택한 메뉴가 이미 장바구니에 존재한다면
                            cartList.get(i).addCountQuantity(1); // 수량만 변경함
                            System.out.println("수량이 추가되었습니다.");
                            isCart = true;
                            break;
                        }
                    }
                    if (!isCart) {
                        cartList.add(new Cart(choiceOrder, 1));
                        System.out.println(choiceOrder.getName() + "을(를) 장바구니에 추가되었습니다.");
                    }
                } else if (cartAnswer == 2) {
                    System.out.println("취소되었습니다.");
                } else {
                    System.out.println("올바른 입력이 아닙니다.");
                }
                break;

            }
        }
        sc.close();

    }
}
