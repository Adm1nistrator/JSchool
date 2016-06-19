package jschool;

        import com.fasterxml.jackson.annotation.JsonProperty;
        import org.springframework.hateoas.ResourceSupport;

        import javax.persistence.*;
        import java.io.Serializable;
        import java.sql.Date;

/**
 * Created by anykey on 16.06.16.
 */
@Entity
@Table(name = "users")
public class User extends ResourceSupport implements Serializable {

    // Persistent Fields:
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "name")
    private String lastName;
    @Column
    private Date birthDay;
    @Id
    @Column(name = "login")
    private String login;
    @Column
    private String password;
    @Column
    private String aBout;
    @Column
    private String adress;

    public User(@JsonProperty("user") String firstName, String lastName, Date birthDay,
                String login, String password, String aBout, String adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.login = login;
        this.password = password;
        this.aBout = aBout;
        this.adress = adress;
    }

    public User() {
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
