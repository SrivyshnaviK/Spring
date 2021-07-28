package com.vyshnavi.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String preFix;
    @Override
    public void initialize(CourseCode courseCode) {
        preFix=courseCode.value();
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        if(string!=null)
            return string.startsWith(preFix);
        else
            return true;
    }
}
