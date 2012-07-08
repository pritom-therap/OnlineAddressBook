package net.therap.validators;

import net.therap.domain.VCard;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 7/8/12
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateVCardValidator implements Validator {
    
     public boolean supports(Class<?> aClass) {
        return VCard.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.nickName", "Nick Name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "required.fullName", "Full Name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "org", "required.organization", "Organization is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Email address is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.title", "Title is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "photoUrl", "required.photoUrl", "Photo Url is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephoneWork", "required.telWork", "Telephone Work is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephoneHome", "required.telHome", "Telephone Home is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressWork", "required.workAddress", "Work Address is required.");
    }
}
