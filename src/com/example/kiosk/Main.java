package com.example.kiosk;

import java.util.Scanner;

public class Main { // 시작지점이 되는 클래스

    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);


        // 메뉴를 담은 이차원배열
        String[][] Menu = {{"ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"}
                ,{"SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"}
                ,{"Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"}
                ,{"Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"},
        };

        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < Menu.length; i++) {
                System.out.println(i + 1 + ". " + Menu[i][0] + " | " + Menu[i][1] + " | " + Menu[i][2]);
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
            } else if (1 <= answer && answer<= Menu.length){   // 입력값이 1부터 Menu의 인덱스 길이까지만 허용 (범위검사
                System.out.println(Menu[answer - 1][0] + "를 선택하셨습니다");
                break;
            } else {
                System.out.println("올바른 입력이 아닙니다.");
            }

        }
    }
}



