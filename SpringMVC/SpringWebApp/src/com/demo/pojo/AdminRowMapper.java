package com.demo.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AdminRowMapper implements RowMapper {
	Admin admin = new Admin();

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		admin.setIdAd(rs.getInt("idAd"));
		admin.setNombre(rs.getString("nombre"));
		admin.setCargo(rs.getString("cargo"));
		admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
		return admin;
	}
	
}
