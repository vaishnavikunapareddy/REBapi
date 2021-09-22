package com.cg.rebapi.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.ShopException;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.serviceimpl.ShopServiceImpl;

@RestController
@RequestMapping("/shops")
public class ShopWeb {
	@Autowired
	public ShopServiceImpl shopService;
	
	@GetMapping("/getshops")
	public ResponseEntity<?> getShops(){
		List<Shop> shopList= shopService.listOfShops();
		return new ResponseEntity<>(shopList,HttpStatus.OK);
	}
	
	@PostMapping("/addshop")
	public ResponseEntity<Shop> addShop(@RequestBody Shop shop) {
		Shop shopSaved=shopService.addShop(shop);
		return new ResponseEntity<Shop>(shopSaved, HttpStatus.CREATED);
	}
	@GetMapping("/getshop/{id}")
	public ResponseEntity<?> getShop(@PathVariable("id") long id){
		List<Shop> shopList= shopService.listOfShops();
		return new ResponseEntity<>(shopList,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteshop/{id}")
	public ResponseEntity<?> deleteshop(@PathVariable("id") long bno) throws ShopException{
		Shop shopSaved=shopService.deleteShop(bno);
		return new ResponseEntity<>(shopSaved,HttpStatus.OK);
	}
	
	@GetMapping("/getshopstatus/{status}")
	public ResponseEntity<?> getFlatStatus(@PathVariable("status") String status){
		List<Shop> shopList= shopService.getShopStatus(status);
		return new ResponseEntity<>(shopList,HttpStatus.OK);
	}
	
	
	

}
