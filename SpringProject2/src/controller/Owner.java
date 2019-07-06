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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "owners")
public class Owner  implements  java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
	
	public Owner() {
		
	}
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "owner_products", joinColumns = {
			@JoinColumn(name = "owner_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "product_id", referencedColumnName = "id") })
	private Set<Product> products;

	public Owner(String username, String password) {
		this.username = username;
		this.password = password;
	
	}




	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
