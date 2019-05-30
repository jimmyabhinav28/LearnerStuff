package dev.abhinav.jpaPractice3.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

	//bidirection one to many, inverse side
	@OneToMany(mappedBy = "table3",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	Set<Table2Entity> table2Entities;

}
