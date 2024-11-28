package service_profile.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "t_profile")
public class ProfileEntity {

    @Id
    @GeneratedValue
    @Column(name = "profile_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private Integer phone;

    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "image")
    private String image;

    /**
     * Direct Initialization: The field delete is initialized to false in the declaration itself.
     * This ensures that the default value is applied when the entity is created.
     * <p>
     * nullable = false:
     * Adding nullable = false ensures that the column cannot be null in the database. The database will store false as the default value.
     */
    @Column(name = "is_deleted", nullable = false)
    private boolean delete = false;

    public ProfileEntity() {
    }

    public ProfileEntity(Integer id, String firstName, String lastName, String address, Integer phone, String email, String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }

    public ProfileEntity(Integer id, String firstName, String lastName, String address, Integer phone, String email, String image, boolean delete) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.image = image;
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}