package com.YIDA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GoodInit {
    public static HashSet<Goods> hashSet=new HashSet<>();
    public boolean initGoods(Goods goods){
        hashSet.add(goods);
        return true;
    }
    public void init(){
        List<Goods> list=new ArrayList<>();
        int i=0;
        list.add(new Goods("Apple",10.00));
        list.add(new Goods("Banana",9.00));
        list.add(new Goods("Melon",6.00));
        for(Goods goods:list) {
            if (this.initGoods(goods)) {
                i++;
            }
            if(i==list.size()){
                showGoods();
            }
        }
    }
    public void showGoods(){
        int i=1;
        System.out.println("**************商品信息*************");
        System.out.println("商品编号******商品名称******商品价格");
        for(Goods goods:hashSet){
            System.out.println((i++)+"********"+goods.getName()+"********"+goods.getPrice());
        }
    }
}
