package com.cg.rebapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.EmptyFieldException;
import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.exception.ShopException;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.repository.AddressRepository;
import com.cg.rebapi.repository.ShopRepository;
import com.cg.rebapi.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	ShopRepository shopRepository;
	@Autowired
	AddressRepository addressRepository;
	@Override
	public List<Shop> listOfShops(){
		List<Shop> shops=shopRepository.findAll();
		if(shops.isEmpty())
			//throw new EmptyListException();
			return null;
		return shops;
		
	}
	@Override
	public Shop addShop(Shop shop) {
//		if(shop.getShopName().isEmpty())
//			throw new EmptyFieldException("601", "Input feilds are empty");
		Shop s= shopRepository.save(shop);
		return s;
	}
	

	@Override
	public Shop deleteShop(long id) throws ShopException  {
		if(shopRepository.existsById(id)) {
		Shop s=shopRepository.findById(id).get();
		addressRepository.deleteById(s.getShopAddress().getId());
		shopRepository.deleteById(id);
		return s;
		}
		//throw new ShopException("Shop with id "+id + " is not there to delete");
		return null;
	}
	@Override
	public boolean checkShop(long id) {
		if(shopRepository.existsById(id))
			return true;
		return false;
		
	}

	@Override
	public Shop getShop(long id) throws ShopException{
		
		if(shopRepository.existsById(id)) {
			Shop s=shopRepository.findById(id).get();
			return s;
		}
		//throw new ShopException("Shop with id "+id+" is not there to get");
		return null;
	}
	
	@Override
	public List<Shop> getShopStatus(String status){
		List<Shop> shopList=shopRepository.getShopStatus(status);
		if(shopList.isEmpty())
			//throw new EmptyListException();
			return null;
		return shopList;
	}

}
