package com.project.dto.user;

import com.project.model.account.Account;
import com.project.model.auction.Auction;
import com.project.model.product.Product;
import com.project.model.users.Address;
import com.project.model.users.UserType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public class UserDto implements Validator {
    private Integer id;
    @NotEmpty(message = "Họ không được để trống")
    private String firstName;
    @NotEmpty(message = "Tên không được để trống")
    private String lastName;
    @NotEmpty(message = "Email không được để trống")
    private String email;
    @NotEmpty(message = "Số điện thoại không được để trống")
    private String phone;
    @NotNull(message = "Điểm cống hiến không được bỏ trống")
    private Double pointDedication;
    @NotEmpty(message = "Ngày sinh không được để trống")
    private String birthDay;
    @NotEmpty(message = "CMND không được để trống")
    private String idCard;
    @NotEmpty(message = "Avatar được để trống")
    private String avatar;
    @NotEmpty(message = "Không được để trống")
    private Boolean deleteStatus;
    @NotEmpty(message = "Địa chỉ được để trống")
    private Address address;
    @NotEmpty(message = "Không được để trống")
    private UserType userType;
    private Set<Auction> auctions;
    @NotEmpty(message = "Không được để trống")
    private Account account;
    private Set<Product> products;
    private List<String> emailList;

    public UserDto() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getPointDedication() {
        return pointDedication;
    }

    public void setPointDedication(Double pointDedication) {
        this.pointDedication = pointDedication;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Set<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(Set<Auction> auctions) {
        this.auctions = auctions;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getFirstName().equals("")) {
            errors.rejectValue("firstName", "firstName", "Họ không được bỏ trống");
        } else {
            if (!userDto.getFirstName().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,30}$")) {
                errors.rejectValue("firstName", "firstName", "Họ không đúng định dạng !");
            }
        }
        if (userDto.getLastName().equals("")) {
            errors.rejectValue("lastName", "lastName", "Tên không được bỏ trống");
        } else {
            if (!userDto.getLastName().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,30}$")) {
                errors.rejectValue("lastName", "lastName", "Tên không đúng định dạng !");
            }
        }
        for (String email : userDto.emailList) {
            if (email.equals(userDto.getEmail())) {
                errors.rejectValue("email", "email", "Email đã tồn tại");
            }
        }
        if (userDto.getEmail().equals("")) {
            errors.rejectValue("email", "email", "Email không được bỏ trông");
        } else {
            if (!userDto.getEmail().matches("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
                errors.rejectValue("email", "email", "Email must be valid");
            }
        }
        if (userDto.getIdCard().equals("")) {
            errors.rejectValue("idCard", "idCard", "CMND không được bỏ trống");
        } else {
            if (!(userDto.getIdCard().matches("\\d{9}") ||
                    userDto.getIdCard().matches("\\d{12}"))) {
                errors.rejectValue("idCard", "idCard", "CMND chỉ có 9 số hoặc 12 số");
            }
        }
    }
}
