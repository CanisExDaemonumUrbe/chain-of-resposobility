public class Request {
    private Integer age;
    private String device;
    private String educationLevel;
    private Boolean isTrial;

    public Request(Integer age, String gender, String educationLevel, Boolean isTrial) {
        this.age = age;
        this.device = gender;
        this.educationLevel = educationLevel;
        this.isTrial = isTrial;
    }

    public Integer getAge() {
        return age;
    }
    public String getDevice() {
        return device;
    }
    public String getEducationLevel() {
        return educationLevel;
    }
    public Boolean getIsTrial() {
        return isTrial;
    }
}
