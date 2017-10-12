package com.pwi.business;

import java.util.List;

import com.pwi.entity.Product;
import com.pwi.data.DataDao;
import com.pwi.data.DataDaoImpl;;

public class PWIBusiness {

	DataDao daoImp = null;

	public PWIBusiness() {
		daoImp = new DataDaoImpl();
	}

	public Integer addProduct(Product product) {
		// add bussiness logic here.
		return daoImp.add(product);
	}

	public List<Product> listProduct() {
		// add bussiness logic here.
		return daoImp.getList();
	}

	public Integer editProduct(Product product) {
		// add bussiness logic here.
		return daoImp.update(product);
	}

	public Integer deleteProduct(Integer productId) {
		// add bussiness logic here.
		return daoImp.delete(productId);
	}

}
