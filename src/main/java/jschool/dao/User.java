package jschool.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Proxy;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by anykey on 16.06.16.
 */
@Entity
@Table(name = "USERS")
@Proxy(lazy = false)
public class User extends ResourceSupport implements Serializable {

    // Persistent Fields:
    @Id
    @Column
    private String login;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date birthDay;

    @Column
    private String password;

    @Column
    private String aBout;

    @Column
    private String address;

    public User(@JsonProperty String firstName, @JsonProperty String lastName, @JsonProperty Date birthDay,
                @JsonProperty String login, @JsonProperty String password, @JsonProperty String aBout, @JsonProperty String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.login = login;
        this.password = password;
        this.aBout = aBout;
        this.address = address;
    }

    public User() {
        //nop
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getaBout() {
        return aBout;
    }

    public void setaBout(String aBout) {
        this.aBout = aBout;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }
}
