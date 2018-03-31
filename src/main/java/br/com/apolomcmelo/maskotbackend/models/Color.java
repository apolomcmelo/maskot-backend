package br.com.apolomcmelo.maskotbackend.models;

import java.io.Serializable;

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
@Table(name = "COLOR")
public class Color implements Serializable {

	private static final long serialVersionUID = 680407127801772412L;

	@Id
    @Column(name = "ID_COLOR")
    @GeneratedValue
	private Long id;
	
	@Column(name = "DESCRIPTION")
	private String description;
}