package com.demo.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.*;
import com.demo.pojo.Admin;


@Service
public class AdminService {

	@Autowired
	public AdminDao adminDao;
	
	public boolean save(Admin admin)
	{
		
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		
		return adminDao.save(admin);
		
	}
	
	public List<Admin> finAll()
	{
		return adminDao.finAll();
	}
	
	public Admin FinById(int id)
	{
		return adminDao.findById(id);
		
	}

	public boolean SaveOrUpdate(Admin admin) {
		// TODO Auto-generated method stub
		if(admin.getIdAd()==0)
		{
			//Insert
			admin.setFechaCreacion(new Timestamp(new Date().getTime()));
			return adminDao.save(admin);	
			
		}
		else
		{
			//Update
			return adminDao.update(admin);
			
		}
		
	}

	public boolean delete(int idAd) {
		// TODO Auto-generated method stub
		return adminDao.delete(idAd);
	}
}
