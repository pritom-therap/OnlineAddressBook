package net.therap.validators;

import net.therap.command.VCardUploadCmd;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/28/12
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class UploadValidator implements Validator {

    public boolean supports(Class<?> aClass) {
         return VCardUploadCmd.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        VCardUploadCmd vCardUploadCmd = (VCardUploadCmd) o;

        if(vCardUploadCmd.getFile() == null || vCardUploadCmd.getFile().getSize() == 0){
              errors.rejectValue("file","required.file");
        }
    }
}
