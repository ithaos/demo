package haos.demo.statemachine.enums;
/**
* 订单状态
*/
public enum OrderStatus {
    // 待支付，待发货，待收货，已完成
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;
}
 
//package net.biancheng.c.utils;
///**
//* 订单状态改变事件
//*/
//public enum OrderStatusChangeEvent {
//    // 支付，发货，确认收货
//    PAYED, DELIVERY, RECEIVED;
//}