package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.pojo.Admin;
import com.demo.services.AdminService;

@Controller
public class adminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin")
	public String showAdmin(Model model, @ModelAttribute("resultado") String resultado)
	{
		List<Admin> admins=adminService.finAll();
		
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		model.addAttribute("resultado",resultado);
		model.addAttribute("admins",admins);
		return "admin";
	}
	
	@RequestMapping(value="/admin/save", method=RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Admin adminform, 
			Model model, RedirectAttributes rd )
	{
		if(adminService.SaveOrUpdate(adminform))
		{
			rd.addFlashAttribute("resultado", "Cambios Guardados con Exitos");
		}
		else
		{
			rd.addFlashAttribute("resultado", "Error al realizar los cambios");
		}
		
		
		return "redirect:/admin";
	}
	/*/admin/${admin.idAd}/delete" */
	
	@RequestMapping("/admin/{idAd}/update")
	public String ShowUpdate(Model model, @PathVariable("idAd") int id)
	{
		Admin admin = adminService.FinById(id);
		model.addAttribute("admin",admin);
		return "admin";
	}
	
	@RequestMapping("/admin/{idAd}/delete")
	public String delete(@PathVariable("idAd") int idAd,
			RedirectAttributes ra)
	{
		 if (adminService.delete(idAd))
		 {
			 ra.addFlashAttribute("resultado","Cambio realizado");
		 }
		 else
		 {
			 ra.addFlashAttribute("resultado","Error al eliminar"); 
		 }
		return "redirect:/admin";
	}
	
	
}
