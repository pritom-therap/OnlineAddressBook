package net.therap.controller.vcard;

import net.therap.command.VCardCmd;
import net.therap.domain.User;
import net.therap.service.vcard.VCardService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/26/12
 * Time: 2:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardAdditionController extends SimpleFormController {

    private VCardService vCardService;

    public void setvCardService(VCardService vCardService) {
        this.vCardService = vCardService;
    }

    protected Object formBackingObject(HttpServlet request) {
        VCardCmd vCardCmd = new VCardCmd();
        return vCardCmd;
    }


    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        VCardCmd vCardCmd = (VCardCmd)command;

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");

        vCardService.saveVCard(vCardCmd,user.getUserId());

        return new ModelAndView("VCard/Success");
    }
}
