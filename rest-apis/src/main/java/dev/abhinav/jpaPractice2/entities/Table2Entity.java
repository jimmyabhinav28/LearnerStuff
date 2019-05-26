package dev.abhinav.jpaPractice2.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "table2")
public class Table2Entity {
	@Id
	Long id;

	@Column(name = "attribute1")
	String attribute1;

	//bidirectional one to one
	
	
	//bidirectional one to one mapping
	@OneToOne(fetch = FetchType.EAGER)
	@MapsId
	Table3Entity table3;

}
