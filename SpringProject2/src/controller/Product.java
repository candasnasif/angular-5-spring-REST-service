package controller;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Product implements java.io.Serializable{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id", nullable = false)
private Integer id;
@Column(name = "productName")
private String productName;

@OneToOne(cascade = CascadeType.ALL)
@JoinTable(name = "owner_products", joinColumns = {
		@JoinColumn(name = "product_id", referencedColumnName = "id") }, inverseJoinColumns = {
				@JoinColumn(name = "owner_id", referencedColumnName = "id") })
private Owner owner;

@JsonIgnore
@OneToMany(cascade = CascadeType.ALL)
@JoinTable(name = "order_products", joinColumns = {
		@JoinColumn(name = "product_id", referencedColumnName = "id") }, inverseJoinColumns = {
				@JoinColumn(name = "order_id", referencedColumnName = "orderid") })
private Set<Orders> orders;

public Set<Orders> getOrders() {
	return orders;
}
public void setOrders(Set<Orders> orders) {
	this.orders = orders;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public Product() {
	
}
public Product( String productName) {
	super();
	
	this.productName = productName;
}
public Owner getOwner() {
	return owner;
}
public void setOwner(Owner owner) {
	this.owner = owner;
};

}
