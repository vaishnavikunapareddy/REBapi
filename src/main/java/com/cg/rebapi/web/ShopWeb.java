package com.cg.rebapi.web;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.MethodArgumentsNotValidException;
import com.cg.rebapi.exception.ShopException;
import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.serviceimpl.AddressServiceImpl;
import com.cg.rebapi.serviceimpl.ShopServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("api/shops")
public class ShopWeb {
	@Autowired
	public ShopServiceImpl shopService;
	
	@Autowired
	private AddressServiceImpl addressService;
	
	@GetMapping("")
	public ResponseEntity<?> getShops(){
		List<Shop> shopList= shopService.listOfShops();
		if(shopList==null)
			return new ResponseEntity<>(shopList,HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(shopList,HttpStatus.OK);

	}
	
	@PostMapping("")
	public ResponseEntity<?> addOrUpdateShop(@Valid @RequestBody Shop shop, BindingResult bindingResult) throws MethodArgumentsNotValidException{
//		if(bindingResult.hasErrors()) {
//			throw new MethodArgumentsNotValidException();
//		}
//		if(shop.getShopAddress()==null)
//			return new ResponseEntity<String>("shop should have address, please provide address" , HttpStatus.NOT_ACCEPTABLE);
//		
//		if(addressService.checkAddress(shop.getShopAddress().getId())) {
		        Address address=addressService.addAddress(shop.getShopAddress());
				Shop shopSaved=shopService.addShop(shop);
				return new ResponseEntity<Shop>(shopSaved, HttpStatus.CREATED);
//		}
//		return new ResponseEntity<String>("shop cannot be added, Address id"+shop.getShopAddress().getId()+ " not found" , HttpStatus.NOT_ACCEPTABLE);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getShop(@PathVariable("id") long id) throws ShopException{
		Shop shop= shopService.getShop(id);
		if(shop==null) {
			return new ResponseEntity<>(shop,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(shop,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteShop(@PathVariable("id") long bno) throws ShopException{
		Shop shopSaved=shopService.deleteShop(bno);
		if(shopSaved==null)
			return new ResponseEntity<>(shopSaved,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(shopSaved,HttpStatus.OK);
	}
	
	@GetMapping("/getstatus/{status}")
	public ResponseEntity<?> getShopStatus(@PathVariable("status") String status){
		List<Shop> shopList= shopService.getShopStatus(status);
		if(shopList==null)
			return new ResponseEntity<>(shopList,HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(shopList,HttpStatus.OK);
	}
	
	
	

}