package quanlydanhba;

public class DanhBa {
    private String name;
    private String group;
    private String gendor;
    private String birthDay;
    private String phone;
    private String address;
    private String email;

    public DanhBa() {
    }

    public DanhBa(String name, String group, String gendor, String birthDay, String phone, String address, String email) {
        this.name = name;
        this.group = group;
        this.gendor = gendor;
        this.birthDay = birthDay;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGendor() {
        return gendor;
    }

    public void setGendor(String gendor) {
        this.gendor = gendor;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String show(){
        return name+","+group+","+gendor+","+birthDay+","+phone+","+address+","+email;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", gendor='" + gendor + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
