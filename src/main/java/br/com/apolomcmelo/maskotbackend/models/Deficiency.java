package br.com.apolomcmelo.maskotbackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEFICIENCY")
public class Deficiency {
	
	@Id
    @Column(name = "ID_DEFICIENCY")
    @GeneratedValue
	private Long id;
	
	@Column(name = "DESCRIPTION")
	private String description;
}