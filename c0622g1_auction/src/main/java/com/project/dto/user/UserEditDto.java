package com.project.dto.user;

import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.UserType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;

public class UserEditDto implements Validator {
    @NotEmpty(message = "Họ không được để trống")
    private String firstName;
    @NotEmpty(message = "Tên không được để trống")
    private String lastName;
    @NotEmpty(message = "Username không được để trống")
    private String username;
    @NotEmpty(message = "Ngày sinh không được để trống")
    private String birthDay;
    @NotEmpty(message = "CMND không được để trống")
    private String idCard;
    @NotEmpty(message = "Số điện thoại không được để trống")
    private String phone;
    @NotEmpty(message = "Email không được để trống")
    private String email;
    @NotEmpty(message = "Đất nước được để trống")
    private String city;
    @NotEmpty(message = "Quận huyên được để trống")
    private String district;
    @NotEmpty(message = "Phường xã được để trống")
    private String town;
    @NotEmpty(message = "Địa chỉ được để trống")
    private String detailAddress;

    public UserEditDto() {
    }

    public UserEditDto(String firstName, String lastName, String username, String birthDay, String idCard, String phone, String email, String city, String district, String town, String detailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.district = district;
        this.town = town;
        this.detailAddress = detailAddress;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserEditDto userEditDto = (UserEditDto) target;
        if (userEditDto.getFirstName().equals("")) {
            errors.rejectValue("firstName", "firstName", "Họ không được bỏ trống");
        } else {
            if (!userEditDto.getFirstName().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{2,30}$")) {
                errors.rejectValue("firstName", "firstName", "Họ không đúng định dạng !");
            }
        }
        if (userEditDto.getLastName().equals("")) {
            errors.rejectValue("lastName", "lastName", "Tên không được bỏ trống");
        } else {
            if (!userEditDto.getLastName().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{2,30}$")) {
                errors.rejectValue("lastName", "lastName", "Tên không đúng định dạng !");
            }
        }
        if (userEditDto.getEmail().equals("")) {
            errors.rejectValue("email", "email", "Email không được bỏ trông");
        } else {
            if (!userEditDto.getEmail().matches("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
                errors.rejectValue("email", "email", "Email must be valid");
            }
        }
        if (userEditDto.getIdCard().equals("")) {
            errors.rejectValue("idCard", "idCard", "CMND không được bỏ trống");
        } else {
            if (!(userEditDto.getIdCard().matches("\\d{9}") ||
                    userEditDto.getIdCard().matches("\\d{12}"))) {
                errors.rejectValue("idCard", "idCard", "CMND chỉ có 9 số hoặc 12 số");
            }
        }
        if (userEditDto.getPhone().equals("")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại không được để trống");
        } else {
            if (!(userEditDto.getPhone().matches("[0][9][0]\\d{7}") ||
                    userEditDto.getPhone().matches("[0][9][1]\\d{7}") ||
                    userEditDto.getPhone().matches("[(][8][4][)][+][9][0]\\d{7}") ||
                    userEditDto.getPhone().matches("[(][8][4][)][+][9][1]\\d{7}"))) {
                errors.rejectValue("phone", "phone", "Số điện thoại có định dang  (090xxxxxxx) hoặc (091xxxxxxx) hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
            }
        }
        if (userEditDto.getTown().equals("")) {
            errors.rejectValue("town", "town", "Phường xã không được để trống");
        } else {
            if (!(userEditDto.getTown().matches("\"^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,30}$"))) {
                errors.rejectValue("town", "town", "Phường xã nhập từ 5 tới 30 kí tự");
            }
        }
        if (userEditDto.getDistrict().equals("")) {
            errors.rejectValue("district", "district", "Quận huyện không được để trống");
        } else {
            if (!(userEditDto.getDistrict().matches("\"^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,30}$"))) {
                errors.rejectValue("district", "district", "Quận huyện nhập từ 5 tới 30 kí tự");
            }
        }
        if (userEditDto.getCity().equals("")) {
            errors.rejectValue("city", "city", "Tỉnh thành không được để trống");
        } else {
            if (!(userEditDto.getCity().matches("\"^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,30}$"))) {
                errors.rejectValue("city", "city", "Tỉnh thành nhập từ 5 tới 30 kí tự");
            }
        }
        if (userEditDto.getDetailAddress().equals("")) {
            errors.rejectValue("detailAddress", "detailAddress", "Địa chỉ chi tiết không được để trống");
        } else {
            if (!(userEditDto.getDetailAddress().matches("\"^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,30}$"))) {
                errors.rejectValue("detailAddress", "detailAddress", "Tỉnh thành nhập từ 5 tới 30 kí tự");
            }
        }

    }
}
