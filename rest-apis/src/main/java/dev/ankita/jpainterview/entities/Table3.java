package dev.ankita.jpainterview.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "table3")
public class Table3 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	Long id;
	
	@JsonProperty(value = "attribute1")
	@Column(name = "attribute1")
	String attribute1;
	
	@JsonProperty("table1")
	@JsonBackReference
	@OneToMany(mappedBy = "table3",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Table1> table1;

}
