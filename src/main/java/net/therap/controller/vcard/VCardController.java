package net.therap.controller.vcard;

import net.therap.domain.VCard;
import net.therap.service.vcard.VCardService;
import org.springframework.ui.ModelMap;
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
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardController extends SimpleFormController {
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
/*
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
*/
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        VCard vCard = (VCard) command;

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("vCardId", vCard.getvCardId());

        String isDelete = ServletRequestUtils.getStringParameter(request, "delete", null);
        String isUpdate = ServletRequestUtils.getStringParameter(request, "update", null);
        String isExport = ServletRequestUtils.getStringParameter(request, "export", null);

        if (isUpdate != null) {
            return new ModelAndView(new RedirectView("/gamerschoice/UpdateVCard.htm"), modelMap);
        }

        if (isDelete != null) {
            vCardService.deleteVCard(vCard);
            return new ModelAndView(new RedirectView("/gamerschoice/VCards.htm"));
        }

        if (isExport != null) {
            String exportedVCard = vCardService.exportVCard(vCard.getvCardId());

            response.setContentType("text/text");
            response.setHeader("Content-Disposition", "attachment; filename="+vCard.getName()+".vcf");
            response.getOutputStream().write(exportedVCard.getBytes());
            response.flushBuffer();

        }

        return new ModelAndView("VCard/VCard");

    }

}
