package net.therap.controller.vcard;

import net.therap.domain.User;
import net.therap.domain.VCard;
import net.therap.service.user.UserService;
import net.therap.service.vcard.VCardService;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/26/12
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewVCardsController implements Controller{

    VCardService vCardService;
    UserService userService;

    public void setvCardService(VCardService vCardService) {
        this.vCardService = vCardService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");

        user = userService.getUserById(user.getUserId());

        List<VCard> vCardList = vCardService.getVCardList(user.getUserId());

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute("vCardList", vCardList);

        return new ModelAndView("VCard/VCards", modelMap);


    }
}
