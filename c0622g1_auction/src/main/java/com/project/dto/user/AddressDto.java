package com.project.dto.user;


public class AddressDto {
    private Integer id;
    private String detailAddress;
    private String town;
    private String district;
    private String city;
    private String  country;


    public AddressDto() {
    }

    public AddressDto(String detailAddress, String town, String district, String city, String country) {
        this.detailAddress = detailAddress;
        this.town = town;
        this.district = district;
        this.city = city;
        this.country = country;
    }

    public AddressDto(String detailAddress, String town, String district, String city) {
        this.detailAddress = detailAddress;
        this.town = town;
        this.district = district;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}