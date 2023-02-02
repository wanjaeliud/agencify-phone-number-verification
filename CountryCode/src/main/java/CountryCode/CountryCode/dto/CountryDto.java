package CountryCode.CountryCode.dto;

public class CountryDto {

    private String country;
    private String phone;
    private String state;

    public CountryDto() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "countryName='" + country + '\'' +
                ", phoneNumber='" + phone + '\'' +
                ", status=" + state +
                '}';
    }
}
