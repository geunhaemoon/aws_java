package org.test01;

import lombok.Data;

@Data
public class Order {
	private int orderId;
	private String prouctName;
	private String comsmerName;
	private int price;
	private int stock;
	
	public void showOrderInfo(Order order1) {
	
	}
	
	public static OrderBuilder builder() {
		return new OrderBuilder();
	}
	
	public static class OrderBuilder {
		private int orderId;
		private String prouctName;
		private String consmerName;
		private int price;
		private int stock;
		
		public Order build() {
			return new Order();
		}	
			
		public OrderBuilder orderId(int orderId) {
			this.orderId = orderId;
			return this;
		}
		
		public OrderBuilder prouctName(String prouctName) {
			this.prouctName = prouctName;
			return this;
		}
		
		public OrderBuilder consmerName(String consmerName){
			this.consmerName = consmerName;
			return this;
		}
		
		public OrderBuilder price(int price) {
			this.price = price;
			return this;
		}
		
		public OrderBuilder stock(int stock) {
			this.stock = stock;
			return this;
		}
	}

	public void add(Order build) {
	}
}
