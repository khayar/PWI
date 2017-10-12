package com.pwi.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pwi.entity.*;
import com.pwi.business.PWIBusiness;

@RestController
public class PWIController {

	PWIBusiness pwibusiness = null;

	public PWIController() {
		pwibusiness = new PWIBusiness();
	}

	@RequestMapping("add")
	public ModelAndView addProduct(@ModelAttribute Product product) {
		pwibusiness.addProduct(product);
		return new ModelAndView("redirect:add");
	}

	@RequestMapping("list")
	public ModelAndView getProductList() {
		pwibusiness.listProduct();
		return new ModelAndView("list: prodcutList");
	}

	@RequestMapping("delete")
	public ModelAndView deleteProduct(@RequestParam int id) {
		pwibusiness.deleteProduct(id);
		return new ModelAndView("redirect:list");
	}

	@RequestMapping("edit")
	public ModelAndView editUser(@RequestParam int id, @ModelAttribute Product product) {
		pwibusiness.editProduct(product);
		return new ModelAndView("edit:list");
	}

}
