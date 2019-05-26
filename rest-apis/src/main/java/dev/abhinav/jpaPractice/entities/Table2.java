package dev.abhinav.jpaPractice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "table2")
@Getter
@Setter
public class Table2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "attribute1")
	String attribute1;
	
	@JsonBackReference
	@OneToOne(mappedBy = "table2", fetch = FetchType.EAGER)
	Table3 table3;

}
