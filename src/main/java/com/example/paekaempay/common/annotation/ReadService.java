package com.example.paekaempay.common.annotation;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Transactional(readOnly = true)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ReadService {
}
