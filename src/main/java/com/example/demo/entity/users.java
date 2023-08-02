package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= " Studetails")

public class users {
	/*columns names here when data is entered they are stored in the below order*/
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private int id;
	@Column(name="Username",nullable = false,length = 40)
	@NotEmpty
	private String name;

	@Email
	private String email;
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Size(min=5)
	private String password;
	/*lambok generates the getter and setter*/
	

}
