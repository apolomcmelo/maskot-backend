package br.com.apolomcmelo.maskotbackend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.apolomcmelo.maskotbackend.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BREED")
public class Breed implements Serializable {

	private static final long serialVersionUID = -1055413510525034297L;

	@Id
    @Column(name = "ID_BREED")
	@GeneratedValue
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;

    @Column(name = "SIZE")
	@Enumerated(EnumType.STRING)
	private Size size;
}