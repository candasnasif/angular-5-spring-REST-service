package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders implements java.io.Serializable

{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderid", nullable = false)
	Integer orderID;
	@Column(name = "number_of_pieces")
	String number_of_pieces;
	@Column(name = "status")
	String status;
	
	@Column(name = "date")
	String date;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "order_products", joinColumns = {
			@JoinColumn(name = "order_id", referencedColumnName = "orderid") }, inverseJoinColumns = {
					@JoinColumn(name = "product_id", referencedColumnName = "id") })
	Product product;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_orders", joinColumns = {
			@JoinColumn(name = "order_id", referencedColumnName = "orderid") }, inverseJoinColumns = {
					@JoinColumn(name = "customer_id", referencedColumnName = "id") })
	Customer customer;
	
	public Orders()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.date = dtf.format(now); //2016/11/16 12:08:43
	}
	
	public Orders( String status,
			String number_of_pieces) {
		super();
		this.status = status;
	
		this.number_of_pieces = number_of_pieces;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.date = dtf.format(now);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getNumber_of_pieces() {
		return number_of_pieces;
	}

	public void setNumber_of_pieces(String number_of_pieces) {
		this.number_of_pieces = number_of_pieces;
	}

}
