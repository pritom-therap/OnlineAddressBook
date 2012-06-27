package net.therap.service.vcard;

import net.therap.command.VCardCmd;
import net.therap.domain.VCard;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/26/12
 * Time: 2:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VCardService {

    public void saveVCard(VCardCmd vCardCmd, int userId);

    public List<VCard> getVCardList(int userId);

    public List<VCard> searchVCard(String searchString, int userId);

    public VCard getVCardById(int vCardId);

    public void updateVCard(VCard vCard);

    public void deleteVCard(VCard vCard);

    public String exportVCard(int vCardId);

    public void uploadVCard(MultipartFile multipartFile, int userId) throws IOException;
}
