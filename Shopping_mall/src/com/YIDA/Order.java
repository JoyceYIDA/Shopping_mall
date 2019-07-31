package com.YIDA;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import static com.YIDA.Client.order;
import static com.YIDA.GoodInit.hashSet;

public class Order {
    private static Scanner sc=new Scanner(System.in);
    private HashMap<Goods,Integer> orderMap=new HashMap<>();
    //判断商品是否添加成功
    private boolean addBoolean(Goods goods,int count){
        if(goods==null||count==0) {
            System.out.println("商品和数量都不能为空");
            return false;
        }else if(!hashSet.contains(goods)){
            System.out.println("货架上没有该商品，添加购物车失败");
            return false;
        }else{
            orderMap.put(goods,count);
            System.out.println("**********添加商品成功*********");
            return true;
        }
    }

    //判断商品是否能删除
    private boolean deleteBoolean(Goods goods){
        if(orderMap.containsKey(goods)){
            orderMap.remove(goods);
            System.out.println("*********删除商品成功**********");
            return true;
        }else{
            System.out.println("*****没有该商品，删除失败*******");
            return false;
        }
    }

    private boolean loadBoolean(Goods goodsN,Goods goodsO,int count){
        if(orderMap.containsKey(goodsO)){
            orderMap.remove(goodsO);
            if(hashSet.contains(goodsN)) {
                orderMap.put(goodsN, count);
                System.out.println("***********修改成功*************");
                return true;
            }else{
                System.out.println("货架上没有新商品，修改失败");
                return false;
            }
        }
        else {
            System.out.println("*****商品不存在，修改失败********");
            return false;
        }
    }


    public void addGoods(){
        System.out.println("请按照如下形式输入商品信息：");
        System.out.println("商品名称--商品价格--商品数量");
        String str=sc.nextLine();
        if(str.equals("C")){
            order();
        }
        String[] strs=str.split("--");
        Goods goods=new Goods(strs[0],Double.parseDouble(strs[1]));
        addBoolean(goods,Integer.parseInt(strs[2]));
    }
    public void deleteGoods(){
        System.out.println("请按照如下形式输入商品信息：");
        System.out.println("商品名称--商品价格");
        String str=sc.nextLine();
        if(str.equals("C")){
            order();
        }
        String[] strs=str.split("--");
        Goods goods=new Goods(strs[0],Double.parseDouble(strs[1]));
        deleteBoolean(goods);
    }

    public void loadOrder(){
        System.out.println("请按照以下格式输入修改前商品信息");
        System.out.println("商品名称--商品价格--商品数量");
        String str=sc.nextLine();
        if(str.equals("C")){
            order();
        }
        String[] strs=str.split("--");
        Goods goods=new Goods(strs[0],Double.parseDouble(strs[1]));
        System.out.println("请按照如下格式输入修改后商品信息");
        System.out.println("商品名称--商品价格--商品数量");
        String str0=sc.nextLine();
        if(str0.equals("C")){
            order();
        }
        String[] strs0=str0.split("--");
        Goods goods0=new Goods(strs0[0],Double.parseDouble(strs0[1]));
        this.loadBoolean(goods0,goods,Integer.parseInt(strs0[2]));
    }
    public void show(){
        int i=0;
        System.out.println("**************************订单信息************************");
        System.out.println("商品ID********商品名称********商品价格********商品数量*****");
        for(Goods good:orderMap.keySet()){
            System.out.println((i++)+"***********"+good.getName()+"***********"+
            good.getPrice()+"*********"+orderMap.get(good)+"*****");
        }
    }


    public void load(){
        File file=new File("order.txt");
        int count=0;
        double sum=0;
        try {
            Writer writer=new FileWriter(file);
            writer.write("*****************订单信息******************\n");
            writer.write("*****商品名称*****商品价格*****商品数量*****\n");
            for(Goods goods:orderMap.keySet()){
                count=orderMap.get(goods);
                writer.write("*****"+goods.getName()+"*******"+goods.getPrice()+"*******"+count+"*******\n");
                sum=sum+count*goods.getPrice();
            }
            writer.write("************************总价******************\n");
            writer.write("************************"+sum+"元*************\n");
            writer.close();
            System.out.println("下载成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
