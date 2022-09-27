package com.springboot.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;



@Entity
@Setter
@Getter
@Data
public class User {

	@Id
	@Email(message = "Please enter a valid EMail address")
	private String userMailId;

	@NotEmpty(message="Please enter valid Name")
	@Pattern(regexp = "^[a-zA-Z0-9._@]*[^=][^?][^<][^>][^%]$")
	private String userName;

	@NotEmpty(message = "Please enter a valid Password")
	@Pattern(regexp ="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$" )
	private String userPassword;

	@NotEmpty(message = "Please enter a valid CPassword")
	private String userConfirmPassword;

	@NotEmpty(message = "Please enter a valid Mobile No")
	@Pattern(regexp  ="^\\d{10}$")
	private String userMobNo;

	@NotEmpty(message = "Please enter a valid City")
	private String userCity;

	@NotEmpty(message = "Please enter a valid State")
	private String userState;

	@NotEmpty(message = "Please enter a valid District")
	private String userDistrict;

	@NotEmpty(message = "Please enter a valid Contry")
	private String userContry;

	@NotEmpty(message = "Please enter a valid PinCode Number")
	@Pattern(regexp  ="^\\d{6}$")
	private String userPinCodeNo;

	@NotEmpty(message = "Please enter a valid PanCard Number")
	@Pattern(regexp  ="^\\d{10}$")
	private String userPanCardNo;

	@NotEmpty(message = "Please enter a valid Aadhar card Number")
	@Pattern(regexp  ="^\\d{12}$")
	private String userAadharCardNo;

	@NotEmpty 
	private String userType;

	// @NotEmpty
	private String userStatus;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE",
	joinColumns = {
			@JoinColumn(name = "USER_ID")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID")
	}
			)
	private Set<Role> role;

}
