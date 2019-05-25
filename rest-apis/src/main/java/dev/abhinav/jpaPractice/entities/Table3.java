package dev.abhinav.jpaPractice.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "table3")
@Getter
@Setter
public class Table3 {
	
	@Id
	@Column(name = "id")
	Long id;
	
	@Column(name = "attribute1")
	String attribute1;
	
	@JoinColumn(name = "table1_id", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Table1 table1;
	
	
	@JoinColumn(name = "table2_id", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Table2 table2;

}
