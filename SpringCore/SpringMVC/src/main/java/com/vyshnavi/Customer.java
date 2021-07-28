package com.vyshnavi;

import com.vyshnavi.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "Field Required")
    @Size(min=5,max = 30, message = "Min Size must be 5")
    private String lastName;
    @Min(value = 1,message = "Value should be greater than or equal to 1")
    @Max(value = 5,message = "Value should be less than or equal to 5")
    private Integer freePasses;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "Value must be 5 characters/digits")
    private String postalCode;
    @CourseCode
    private String courseCode;
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Integer getFreePasses() {
        return freePasses;
    }
    public String getPostalCode() {
        return postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }
}
