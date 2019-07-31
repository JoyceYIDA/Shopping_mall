package com.YIDA;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static final String userName="YIDA";
    private static final String password="7777";
    private static Order order=new Order();
    private static GoodInit goodInit=new GoodInit();
    private static Scanner scanner=new Scanner(System.in);

    public static void first() {
        Menu.firstInMenu();
        String firstStr=null;
        do{
            firstStr=scanner.nextLine();
            if(firstStr.equals("U")){
                System.out.println("请输入您的用户名：");
                String userNameSc=scanner.nextLine();
                System.out.println("请输入您的密码：");
                String passwordSc=scanner.nextLine();
                if(userNameSc.equals(userName)&&passwordSc.equals(password)){
                    order();
                    break;
                }
                System.out.println("用户名或密码不正确，请您重新输入");
            }else if(firstStr.equals("A")){
                Menu.about();
            }
        }while(!firstStr.equals("E"));
    }
    public static void order(){
        String userStr=null;
        Menu.useMenu();
        do{
            userStr=scanner.nextLine();
            switch (userStr){
                case "S":
                    order.show();
                    break;
                case "D":
                    order.deleteGoods();
                case "B":
                    order.load();
                    break;
                case "A":
                    order.addGoods();
                    break;
                case "F":
                    order.loadOrder();
                    break;
                case "C":
                    order();
                    break;
                default:
                    break;
            }
        }while (!userStr.equals("E"));
    }

    public static void main(String[] args) {
        goodInit.init();
        while(true){
            first();
        }
    }
}
