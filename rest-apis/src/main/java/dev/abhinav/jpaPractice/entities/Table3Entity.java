package dev.abhinav.jpaPractice.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "table3")
public class Table3Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "attribute1")
	String attribute1;

	//unidirectional one to one
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "table1_id",referencedColumnName = "id")
	Table1Entity table1Entity;
	
	//bidirectional one to one mapping
//	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@OneToOne(fetch = FetchType.EAGER)
//	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "table2_id",referencedColumnName = "id")
	Table2Entity table2Entity;

}
