package net.therap.command;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/27/12
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class VCardUploadCmd {

    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
