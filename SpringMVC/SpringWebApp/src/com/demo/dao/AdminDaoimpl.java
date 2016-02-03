package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.pojo.Admin;
import com.demo.pojo.AdminRowMapper;

@Component("adminDao")
public class AdminDaoimpl implements AdminDao {

	private NamedParameterJdbcTemplate JdbcTemplate; 
	
	@Autowired
	private void setDataSource(DataSource datasource)
	{
		 this.JdbcTemplate = new NamedParameterJdbcTemplate(datasource);
	}
	@Override
	public boolean save(Admin admin) {
		// TODO Auto-generated method stub
		/*
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("nombre", admin.getNombre());
		paramMap.addValue("cargo", admin.getCargo());
		paramMap.addValue("fechaCreacion", admin.getFechaCreacion());
		*/
		
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		
		return JdbcTemplate.update("INSERT INTO springdb.ADMIN(nombre, cargo, fechacreacion) VALUES (:nombre, :cargo, :fechaCreacion)", paramMap)==1;
	}
	@Override
	public List<Admin> finAll() {
		// TODO Auto-generated method stub
		return JdbcTemplate.query("Select * from springdb.admin", new RowMapper<Admin>(){

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Admin admin = new Admin();
				admin.setIdAd(rs.getInt("idAd"));
				admin.setNombre(rs.getString("nombre"));
				admin.setCargo(rs.getString("cargo"));
				admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
				return admin;
			}
			
		});
	}
	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		return (Admin) JdbcTemplate.queryForObject("SELECT * FROM SPRINGDB.ADMIN WHERE IDAD = :idAd ", 
				new MapSqlParameterSource("idAd", id ), new AdminRowMapper());
	}
	@Override
	public List<Admin> finByNombre(String nombre) {
		// TODO Auto-generated method stub
		return JdbcTemplate.query("SELECT * FROM SPRINGDB.ADMIN WHERE NOMBRE like :nombre", 
				new MapSqlParameterSource("nombre", "%" + nombre +"%" ), new AdminRowMapper());
	}
	@Override
	public boolean update(Admin admin) {
		// TODO Auto-generated method stub
		return JdbcTemplate.update("UPDATE SPRINGDB.ADMIN SET CARGO=:cargo, NOMBRE=:nombre, FECHACREACION=:fechaCreacion WHERE IDAD=:idAd", new BeanPropertySqlParameterSource(admin))==1;
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return JdbcTemplate.update("DELETE FROM SPRINGDB.ADMIN WHERE IDAD=:idAd", new MapSqlParameterSource("idAd", id))==1;
	}
	
	@Transactional
	@Override
	public int[] saveAll(List<Admin> admins) {
		// TODO Auto-generated method stub
		SqlParameterSource[] batchValues = SqlParameterSourceUtils.createBatch(admins.toArray());
		return JdbcTemplate.batchUpdate("INSERT INTO springdb.ADMIN(idAd, nombre, cargo, fechacreacion) VALUES (:idAd, :nombre, :cargo, :fechaCreacion)", batchValues);
	}
	
	

}
