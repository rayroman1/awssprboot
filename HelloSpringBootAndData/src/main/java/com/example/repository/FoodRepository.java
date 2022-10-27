package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Food;

/*
 * Spring data will provide implementation to our repository interface that extends a standardized spring repository interface
 * 
 * CrudRepository --Extended by--> PagingAndSortingRepository --Extended by --> JpaRespository
 * 
 * CrudRepository provides all basic CRUD functionality, the interface will have a .save(), .findOne(), .findAll(), delete(), count().....
 * 	all pre-implmented requiring non-method signitures written by use
 * 
 * PagingAndSortingRepository provides methods that do pagination and sorting, and all the functions from CrudRepository. To do pagination
 * 		we can let the repo create a Pageable Object from the query and that object has properties of page size, current page, page number,
 * 		next page, sort
 * 
 * JpaRepository provides JPA related Methods such as flushing the cache, batch deletes, and batch updates, and many more, plus it will 
 * 		get all the functionality from PagingAndSorting as well as Crud
 * 
 * for more complex queries we will need to write method signitures in a very strict syntax, spring data will the provide implementation
 * 		based on those method names
 * 
 * Documentation for method signature naming convertions is the following:
 * 
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
 */


@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
	//the spring Repo interfaces require values for its generic types, first being the model the repository is resposible for, the next
	//being the data type of the primary key for that model.
	
	public List<Food> findAll();
	public Food findByFoodName(String foodName);
	public List<Food> findByCalories(int cal);
	public Food findByFoodNameAndCalories(String foodName, int cal);
	public Food findByFoodId(int id);
	//if you have a stored function all you would need to do is make a method in this interface of the same name as the function 
	// in the database annotated with @Procedure
	/*
	 * @Procedure
	 * int countTotalFoodEntries();
	 */

}
