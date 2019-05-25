package dev.abhinav.jpaPractice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="table1")
public class Table1Entity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;

@Column(name = "attribute1")
String attribute1;

}
