package service_profile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;


/**
 * This DTO works well with @PatchMapping since @JsonInclude(JsonInclude.Include.NON_NULL)
 * ensures that only non-null fields are serialized and passed in the request.
 * You can handle updates for only the fields provided in the request.
 */

/**Handling of @Nullable:
 The @Nullable annotation typically serves as a hint to developers and tools that the value can be null.
 However, it does not enforce nullability at runtime or during serialization.
 It’s fine to use here for documentation or integration with IDEs and tools like IntelliJ.
 *
 * */

@JsonInclude(JsonInclude.Include.NON_NULL) // Only serialize non-null values
public class UpdateProfileDto {

    @Nullable
    private String firstName;
    @Nullable
    private String lastName;
    @Nullable
    private String address;
    @Nullable
    private Integer phone;
    @Nullable
    private String email;
    @Nullable
    private String image;

    private boolean delete;

    public UpdateProfileDto() {
    }

    public UpdateProfileDto(String firstName, String lastName, String address, Integer phone, String email, String image, boolean delete) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.image = image;
        this.delete = delete;
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

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
