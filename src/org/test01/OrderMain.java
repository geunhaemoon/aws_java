package org.test01;

public class OrderMain {
	public static void main(String[] args) {
		Order order = null;
		Order order1 = new Order();
		order1.add(Order.builder().orderId(100).prouctName("Samsung GalaxyBook2 Pro").consmerName("홍길동").price(1450000).stock(2).build());
				
		System.out.println(order1.getOrderId());

		order1.showOrderInfo(.order1);
	}
}
