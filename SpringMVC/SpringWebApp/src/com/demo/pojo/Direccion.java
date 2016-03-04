package com.demo.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Direccion {

	private String calle;
	private String cp;

	public Direccion(String calle, String cp) {

		this.calle = calle;
		this.cp = cp;
	}

	@Autowired
	public void setCalle(@Value("Cr 16 N 45F 42")String calle) {
		this.calle = calle;
	}

	@Autowired
	public void setCp(@Value("123")String cp) {
		this.cp = cp;
	}

	public Direccion() {

	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", cp=" + cp + "]";
	}

}
