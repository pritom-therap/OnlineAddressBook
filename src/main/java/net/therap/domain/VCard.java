package net.therap.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: pritom
 * Date: 6/26/12
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "P_VCARD")
public class VCard {
    private int vCardId;
    private String name;
    private String fullName;
    private String org;
    private String title;
    private String photoUrl;
    private String telephoneWork;
    private String telephoneHome;
    private String addressWork;
    private String email;
    private Date rev;
    private User user;
    private long version;


    @Id
    @SequenceGenerator(name = "P_VCARD_SEQ", sequenceName = "P_VCARD_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "P_VCARD_SEQ")
    @Column(name = "vCard_ID")
    public int getvCardId() {
        return vCardId;
    }

    public void setvCardId(int vCardId) {
        this.vCardId = vCardId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "FULL_NAME")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Column(name = "ORG")
    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "PHOTO_URL")
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Column(name = "TEL_WORK")
    public String getTelephoneWork() {
        return telephoneWork;
    }

    public void setTelephoneWork(String telephoneWork) {
        this.telephoneWork = telephoneWork;
    }

    @Column(name = "TEL_HOME")
    public String getTelephoneHome() {
        return telephoneHome;
    }

    public void setTelephoneHome(String telephoneHome) {
        this.telephoneHome = telephoneHome;
    }


    @Column(name = "Address_WORK")
    public String getAddressWork() {
        return addressWork;
    }

    public void setAddressWork(String addressWork) {
        this.addressWork = addressWork;
    }


    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REV")
    public Date getRev() {
        return rev;
    }

    public void setRev(Date rev) {
        this.rev = rev;
    }

    @Version
    @Column(name = "VERSION")
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
