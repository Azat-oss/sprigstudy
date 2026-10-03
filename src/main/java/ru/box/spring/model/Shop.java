package ru.box.spring.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;


public class Shop {

    private static int counter = 0;
    private final int id;
    private String name;
    private String phoneNum;
    @Email(message = "Некорректный email")
    private String email;

    @Pattern(regexp = "^(https?://)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/.*)?$",
            message = "Некорректный URL сайта")
    private String webSite;
    private String category;
    private String description;

    public Shop(int id, String name, String phoneNum, String email, String webSite, String category, String description) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.webSite = webSite;
        this.category = category;
        this.description = description;
    }

    public static int getCounter() {
        return counter;}

    public static void setCounter(int counter) {
        Shop.counter = counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", webSite='" + webSite + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
