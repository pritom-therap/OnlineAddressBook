package net.therap.controller.vcard;

import net.therap.domain.VCard;
import net.therap.service.vcard.VCardService;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/26/12
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardUpdateController extends SimpleFormController {

    VCardService vCardService;

    public void setvCardService(VCardService vCardService) {
        this.vCardService = vCardService;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        int vCardId = ServletRequestUtils.getIntParameter(request, "vCardId", -1);
        VCard vCard = vCardService.getVCardById(vCardId);
        return vCard;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        VCard vCard =(VCard) command;
        vCardService.updateVCard(vCard);

        return new ModelAndView(new RedirectView("/gamerschoice/VCards.htm"));
    }
}
