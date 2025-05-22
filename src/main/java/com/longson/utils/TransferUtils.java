package com.longson.utils;

import com.alibaba.fastjson.JSONObject;
import com.longson.pojo.Orders;
import com.longson.pojo.SuperMarketWip;
import com.longson.pojo.User;

import java.util.List;

public class TransferUtils {

    public  static  List<Orders> parseJsonToOrders(String json) {
        // 使用Gson, Jackson或其他JSON库来解析JSON
        // 这里只是示意，你需要根据实际情况实现

        List<Orders> ordersList = JSONObject.parseArray(json, Orders.class);
        return ordersList; // 返回一个空的列表或解析后的列表
    }

    public  static  List<SuperMarketWip> parseJsonToSuperMarketWip(String json) {
        // 使用Gson, Jackson或其他JSON库来解析JSON
        // 这里只是示意，你需要根据实际情况实现

        List<SuperMarketWip> wip = JSONObject.parseArray(json, SuperMarketWip.class);

        return wip; // 返回一个空的列表或解析后的列表
    }

    public  static  List<User> parseJsonToUser(String json) {
        // 使用Gson, Jackson或其他JSON库来解析JSON
        // 这里只是示意，你需要根据实际情况实现

        List<User> user = JSONObject.parseArray(json, User.class);

        return user; // 返回一个空的列表或解析后的列表
    }

}
