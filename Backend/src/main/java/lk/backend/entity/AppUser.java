package lk.backend.entity;

import lk.backend.util.IDCreator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AppUser implements IDCreator {

    @Id
    private String id;
    @Transient
    private String idFormatted;
    private String name;
    private String email;
    private String password;
    private String userType;
    private String contactNumber;

    public AppUser(AppUser appUser) {
        this.id = appUser.id;
        this.name = appUser.name;
        this.email = appUser.email;
        this.password = appUser.password;
        this.userType = appUser.userType;
        this.contactNumber = appUser.contactNumber;
    }

    public String getFormattedId() {
        return "U" + id;
    }
}