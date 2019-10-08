package com.wz.springboot.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

public abstract class BeanValidators<T> {

    public  static<T> void validateWithException(Validator validator, T bean) {
        Set<ConstraintViolation<T>> validate = validator.validate(bean);
        Iterator<ConstraintViolation<T>> iterator = validate.iterator();
        while (iterator.hasNext()) {
            ConstraintViolation<T> next = iterator.next();
            if(next != null) {
                throw new RuntimeException(next.getInvalidValue()+"is not empty");
            }
        }
    }
}
