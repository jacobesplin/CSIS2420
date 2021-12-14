package com.finalProject;

public class OrdersForm {
	public int customerId;
	public String orderDate;
	public String shipmentStatus = "14";
	public OrdersForm(int customerId,String orderDate) {
		this.customerId = customerId;
		this.orderDate = orderDate;
	}

}
