package net.therap.controller.vcard;

import net.therap.command.VCardUploadCmd;
import net.therap.domain.User;
import net.therap.service.vcard.VCardService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/27/12
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class VCardUploadController extends SimpleFormController{

    VCardService vCardService;

    public void setvCardService(VCardService vCardService) {
        this.vCardService = vCardService;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        VCardUploadCmd vCardUploadCmd = new VCardUploadCmd();

        return vCardUploadCmd;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        VCardUploadCmd vCardUploadCmd = (VCardUploadCmd) command;

        if(vCardUploadCmd == null){
            return new ModelAndView(new RedirectView("/gamerschoice/UploadVCard.htm"));
        }

        HttpSession session = (HttpSession) request.getSession();
        User user = (User)session.getAttribute("User");

        vCardService.uploadVCard(vCardUploadCmd.getFile(), user.getUserId());

        return new ModelAndView(new RedirectView("/gamerschoice/VCards.htm"));
    }
}
