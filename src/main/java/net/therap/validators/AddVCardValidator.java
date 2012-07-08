package net.therap.validators;

import net.therap.command.VCardCmd;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 7/8/12
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddVCardValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return VCardCmd.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        VCardCmd vCardCmd = (VCardCmd) o;

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
