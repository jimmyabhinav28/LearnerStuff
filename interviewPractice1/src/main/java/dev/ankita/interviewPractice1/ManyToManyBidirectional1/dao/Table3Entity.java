package dev.ankita.interviewPractice1.ManyToManyBidirectional1.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	// bidirection one to many, inverse side

//	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "table3")
	Set<Table1Entity> table1Entities;

}
