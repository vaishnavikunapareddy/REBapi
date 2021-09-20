package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.exception.ShopException;
import com.cg.rebapi.model.Shop;


public interface ShopService {

	public List<Shop> listOfShops();

	public Shop addShop(Shop shop);

	public Shop deleteShop(long id) throws ShopException;

	public boolean checkShop(long id);

	public Shop getShop(long id) throws ShopException;
	

}
