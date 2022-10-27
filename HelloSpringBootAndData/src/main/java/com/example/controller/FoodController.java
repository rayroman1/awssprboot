package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Food;
import com.example.service.FoodService;

@RestController
@RequestMapping(value="/")//foods
@CrossOrigin(origins="*")//CORS - cross origin resource sharing, it is a mechinism that can restrict access for resource from external server
//requests(aka requests outside of the servers domain) if you set the origin to *, it will allow any domain to request the server
public class FoodController {

	private FoodService fServ;
	
	public FoodController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public FoodController(FoodService fServ) {
		super();
		this.fServ = fServ;
	}
	
	@GetMapping("/initial")
	public ResponseEntity<List<Food>> insertInitialValues(){
		List<Food> fList = new ArrayList<Food>(Arrays.asList(new Food("Ramen", 1000), new Food("Pizza", 2500), new Food("Tomato Soup", 300),
				new Food("Sandwich", 400)));
		for(Food food: fList) {
			fServ.insertFood(food);
		}
		
		return new ResponseEntity<List<Food>>(fServ.getAllFood(), HttpStatus.CREATED);
		
	}
	
	@GetMapping()
	public ResponseEntity<List<Food>> getAllFood(){
		return new ResponseEntity<List<Food>>(fServ.getAllFood(), HttpStatus.OK);
	}
	
	@GetMapping("/{foodname}")
	public ResponseEntity<Food> getFoodName(@PathVariable("foodname") String name){
		Food food = fServ.getFoodByName(name);
		if(food==null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Food>(food, HttpStatus.OK);
	}
	
	@DeleteMapping("/{foodname}")
	public ResponseEntity<String> deleteFood(@PathVariable("foodname") String name){
		Food food = fServ.getFoodByName(name);
		if(food==null) {
			return new ResponseEntity<String>("No Food Of that Name", HttpStatus.NOT_FOUND);
		}
		
		fServ.deleteFood(food);
		return new ResponseEntity<String>("Food Was Deleted", HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping()
	public ResponseEntity<Object> insertFood(@RequestBody Food food){
		System.out.println(food);
		if(fServ.getFoodByName(food.getFoodName())!= null) {
			return new ResponseEntity<>("Food Of that name already exists", HttpStatus.FORBIDDEN);
		}
		fServ.insertFood(food);
		return new ResponseEntity<>(fServ.getFoodByName(food.getFoodName()), HttpStatus.CREATED);
	}
	
	
	
}
