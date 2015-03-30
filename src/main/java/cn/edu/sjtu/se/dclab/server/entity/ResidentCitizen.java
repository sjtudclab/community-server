package cn.edu.sjtu.se.dclab.server.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by Huiyi on 2015/3/29.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ResidentCitizen {

    @JsonProperty(value = "id")
    private long id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "identification_type")
    private String identificationType;

    @JsonProperty(value = "identification_value")
    private String identificationValue;

    @JsonProperty(value = "marriage_status")
    private String marriageStatus;

    @JsonProperty(value = "employment_status")
    private String employmentStatus;

    @JsonProperty(value = "residence_category")
    private String residenceCategory;

    @JsonProperty(value = "resident_status")
    private String residentStatus;

    @JsonProperty(value = "education_status")
    private String educationStatus;

    @JsonProperty(value = "politics_status")
    private String politicsStatus;

    @JsonProperty(value = "migration_status")
    private String migrationStatus;

    @JsonProperty(value = "income_status")
    private String incomeStatus;

    @JsonProperty(value = "nation")
    private String nation;

    @JsonProperty(value = "gender")
    private String gender;

    @JsonProperty(value = "age")
    private int age;

    @JsonProperty(value = "status")
    private int status;

    @JsonProperty(value = "phone")
    private String phone;

    @JsonProperty(value = "relationship")
    private String relationship;

    @JsonProperty(value = "user")
    @JsonIdentityReference(alwaysAsId = true)
    private User user;

    @JsonProperty(value = "apartment")
    @JsonIdentityReference(alwaysAsId = true)
    private Apartment apartment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationValue() {
        return identificationValue;
    }

    public void setIdentificationValue(String identificationValue) {
        this.identificationValue = identificationValue;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getResidenceCategory() {
        return residenceCategory;
    }

    public void setResidenceCategory(String residenceCategory) {
        this.residenceCategory = residenceCategory;
    }

    public String getResidentStatus() {
        return residentStatus;
    }

    public void setResidentStatus(String residentStatus) {
        this.residentStatus = residentStatus;
    }

    public String getEducationStatus() {
        return educationStatus;
    }

    public void setEducationStatus(String educationStatus) {
        this.educationStatus = educationStatus;
    }

    public String getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    public String getMigrationStatus() {
        return migrationStatus;
    }

    public void setMigrationStatus(String migrationStatus) {
        this.migrationStatus = migrationStatus;
    }

    public String getIncomeStatus() {
        return incomeStatus;
    }

    public void setIncomeStatus(String incomeStatus) {
        this.incomeStatus = incomeStatus;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
