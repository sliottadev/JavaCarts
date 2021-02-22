package com.SLiottaDev.Controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SLiottaDev.DTOs.UserLoginDTO;
import com.SLiottaDev.Models.Product;
import com.SLiottaDev.Models.User;
import com.SLiottaDev.Services.IProductService;
import com.SLiottaDev.Services.IUserService;

@Controller
public class HomeController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IProductService productService;
	//Comentario prueba
	@GetMapping(value = "/home")
	public String Home (Locale locate, Model model) {
		if (model.getAttribute("msj") == null) {
			model.addAttribute("msj","");
		}
		model.addAttribute("UserLoginDTO", new UserLoginDTO());
		return "home";
	}
	
	@PostMapping(value = "/home")
	public String UserLogIn (@ModelAttribute UserLoginDTO usrLoginDTO, Model model) {
		Long id = userService.UserLogin(usrLoginDTO);
		if (id != null) {
			User usr = userService.GetUserById(id);
			model.addAttribute("User", usr);
			return Dashboard(null, model);
		} else {
			model.addAttribute("msj","ErrorLogIn");
			return Home(null, model);
		}
	}
	
	@GetMapping(value = "/userRegister")
	public String UserRegister (Locale locate, Model model) {
		model.addAttribute("User", new User());
		System.out.println("ABRE VISTA REGISTER");
		return "userRegister";
	}

	@PostMapping(value = "/userRegister" )
	public String UserRegisterSubmit(@ModelAttribute User user, Model model) {
		userService.Add(user);
		return Home(null, model);
	}
	
	@GetMapping(value = "/dashboard")
	public String Dashboard (Locale locale, Model model) {
		return "dashboard";
	}
	
	@GetMapping(value = "/help")
	public String Help (Locale locale, Model model) {
		return "help";
	}

	@GetMapping(value = "/products")
	public String Products (Locale locale, Model model) {
		List<Product> prds = productService.getProducts();
		model.addAttribute("prds", prds);
		return "products";
	}

	@GetMapping(value = "/ProductRegister")
	public String ProductRegister (Locale locale, Model model) {
		model.addAttribute("Product", new Product());
		return "ProductRegister";
	}
	
	@PostMapping(value = "/ProductRegister" )
	public String ProductRegisterSubmit(@ModelAttribute Product prd, Model model) {
		productService.Add(prd);
		return ProductRegister(null, model);
	}
	
	
}
