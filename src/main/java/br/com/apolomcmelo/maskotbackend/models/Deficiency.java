package br.com.apolomcmelo.maskotbackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEFICIENCY")
public class Deficiency {
	
	@Id
    @Column(name = "ID_DEFICIENCY")
	private Long id;
	
	@Column(name = "DESCRIPTION")
	private String description;
}