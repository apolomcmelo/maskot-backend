package br.com.apolomcmelo.maskotbackend.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.com.apolomcmelo.maskotbackend.enums.Species;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PET")
public class Pet implements Serializable {
	private static final long serialVersionUID = 4026952761084116893L;

	@Id
	@Column(name = "ID_PET")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PROFILE_PICTURE")
	private String profilePicture; // Endereço da imagem
	
	@Column(name = "PICTURE")
	@ElementCollection(fetch = FetchType.LAZY)
	private List<String> pictures; // Endereço das imagens
	
	@Column(name = "SPECIES")
	@Enumerated(EnumType.STRING)
	private Species species;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_BREED")
	private Breed breed;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_COLOR")
	private Color color;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Deficiency> deficiencies;
	
	@Column(name = "NEUTERED_STATUS")
	private Boolean neutered;
	
	@Column(name = "AGE")
	private Integer age;
	
	@Column(name = "LAST_LOCATION")
	private String lastLocation;
	
	@Column(name = "LAST_TIME_SEEN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastTimeSeen;
	
	@Column(name = "WITH_OWNER")
	private Boolean withOwner;
	
	@Transient
	public boolean hasId() {
		return this.id != null && this.id > 0x0L;
	}
	
}