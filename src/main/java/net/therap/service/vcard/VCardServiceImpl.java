package net.therap.service.vcard;

import net.therap.command.VCardCmd;
import net.therap.dao.UserDao;
import net.therap.dao.VCardDao;
import net.therap.domain.User;
import net.therap.domain.VCard;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/26/12
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardServiceImpl implements VCardService {
    protected final Logger logger = Logger.getLogger(this.getClass());

    private VCardDao vCardDao;
    private UserDao userDao;
    private VCardExport vCardExport;

    public void setvCardExport(VCardExport vCardExport) {
        this.vCardExport = vCardExport;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setvCardDao(VCardDao vCardDao) {
        this.vCardDao = vCardDao;
    }

    public void saveVCard(VCardCmd vCardCmd, int userId) {
        VCard vCard = new VCard();

        vCard.setName(vCardCmd.getName());
        vCard.setFullName(vCardCmd.getFullName());
        vCard.setOrg(vCardCmd.getOrg());
        vCard.setTitle(vCardCmd.getTitle());
        vCard.setPhotoUrl(vCardCmd.getPhotoUrl());
        vCard.setTelephoneHome(vCardCmd.getTelephoneHome());
        vCard.setTelephoneWork(vCardCmd.getTelephoneWork());
        vCard.setAddressWork(vCardCmd.getAddressWork());
        vCard.setEmail(vCardCmd.getEmail());
        vCard.setRev(new Date());

        User user = userDao.getUserbyId(userId);
        vCard.setUser(user);
        vCardDao.saveVCard(vCard);
    }

    public List<VCard> getVCardList(int userId) {

        User user = userDao.getUserbyId(userId);

        return user.getvCards();
    }

    public List<VCard> searchVCard(String searchString, int userId) {
        return vCardDao.searchVCard(searchString, userId);
    }


    public VCard getVCardById(int vCardId) {
        return vCardDao.getVCardById(vCardId);

    }

    public void updateVCard(VCard vCard) {
        vCard.setRev(new Date());
        vCardDao.updateVCard(vCard);
    }

    public void deleteVCard(VCard vCard) {
        vCardDao.deleteVCard(vCard);
    }

    public String exportVCard(int vCardId) {
        VCard vCard = vCardDao.getVCardById(vCardId);
        return vCardExport.exportVCard(vCard);
    }

    public void uploadVCard(MultipartFile multipartFile,int userId) throws IOException {

        byte[] importedVCardBytes = new byte[(int) multipartFile.getSize()];
        importedVCardBytes = multipartFile.getBytes();
        String importedVCard = new String(importedVCardBytes);

        User user = userDao.getUserbyId(userId);

        VCard vCard = vCardExport.importVCard(importedVCard);

        logger.info("Fullname" + vCard.getFullName());
        vCard.setUser(user);

        vCardDao.saveVCard(vCard);
    }
}
