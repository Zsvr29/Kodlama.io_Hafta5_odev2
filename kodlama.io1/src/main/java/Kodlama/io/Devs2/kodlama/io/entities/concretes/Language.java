package Kodlama.io.Devs2.kodlama.io.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="languages")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Column(name="name")
	private String name;
	
	@OneToMany 
	private List<Technology> technology;
	
	
	
}
