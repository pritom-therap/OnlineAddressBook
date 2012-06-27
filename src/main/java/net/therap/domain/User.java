package net.therap.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * user: pritom
 * Date: 5/30/12
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "P_USER")
public class User {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private long version;
    private List<VCard> vCards;

    @OneToMany(mappedBy = "user")
    public List<VCard> getvCards() {
        return vCards;
    }

    public void setvCards(List<VCard> vCards) {
        this.vCards = vCards;
    }

    @Id
    @SequenceGenerator(name = "P_USER_SEQ", sequenceName = "P_USER_SEQ")
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "P_USER_SEQ")
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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