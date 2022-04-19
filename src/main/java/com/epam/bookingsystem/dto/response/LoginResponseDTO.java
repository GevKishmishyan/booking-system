package com.epam.bookingsystem.dto.response;

import com.epam.bookingsystem.dto.UserDTO;

import java.util.Objects;

public class LoginResponseDTO {

	private String jwtAccess;
	private String type = "Bearer";
	private String jwtRefresh;
	private UserDTO userDTO;

	public LoginResponseDTO(String jwtAccess, String jwtRefresh, UserDTO userDTO) {
		this.jwtAccess = jwtAccess;
		this.jwtRefresh = jwtRefresh;
		this.userDTO = userDTO;
	}

	public LoginResponseDTO() {
	}

	public String getJwtAccess() {
		return jwtAccess;
	}

	public void setJwtAccess(String jwtAccess) {
		this.jwtAccess = jwtAccess;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJwtRefresh() {
		return jwtRefresh;
	}

	public void setJwtRefresh(String jwtRefresh) {
		this.jwtRefresh = jwtRefresh;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	@Override
	public String toString() {
		return "LoginResponseDTO{" +
				"jwtAccess='" + jwtAccess + '\'' +
				", type='" + type + '\'' +
				", jwtRefresh='" + jwtRefresh + '\'' +
				", userDTO=" + userDTO +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LoginResponseDTO that = (LoginResponseDTO) o;
		return Objects.equals(jwtAccess, that.jwtAccess) && Objects.equals(type, that.type) && Objects.equals(jwtRefresh, that.jwtRefresh) && Objects.equals(userDTO, that.userDTO);
	}

	@Override
	public int hashCode() {
		return Objects.hash(jwtAccess, type, jwtRefresh, userDTO);
	}
}
