package com.example.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.model.Food;

/*
 * Spring core provides a validator interface that works with spring errors as well as the DataBinder
 */
public class FoodValidator implements Validator {

	@Override //this is method is called first to make sure that the validator will work with the object given
	public boolean supports(Class<?> clazz) {
		return Food.class.equals(clazz);
	}

	@Override //if the object given passes the support method, then the validate method is called
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "foodName", "foodName.empty", "foodName must have a value");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "calories", "field.required", "Calories must have a value");
		Food food = (Food) target;
		if(food.getCalories() < 0) {
			errors.rejectValue("calories", "negative.value", "I wish, but no negative calories");
		}else if(food.getCalories() > 3000) {
			errors.rejectValue("calories", "tooDangMuch", "Thats a bit much, don't ya think?");
		}

	}

}
