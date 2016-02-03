package com.demo.dao;

import java.util.List;

import com.demo.pojo.Admin;

public interface AdminDao {

	public boolean save(Admin admin);
	public List<Admin> finAll();
	public Admin findById(int id);
	public List<Admin> finByNombre(String nombre);
	public boolean update(Admin admin);
	public boolean delete(int idAd);
	public int[] saveAll(List<Admin> admins);
	
}
