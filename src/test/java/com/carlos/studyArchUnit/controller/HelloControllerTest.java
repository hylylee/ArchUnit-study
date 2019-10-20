package com.carlos.studyArchUnit.controller;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    @Test
    void home() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.carlos.studyArchUnit");
        JavaClass clazz = classes.get(HelloController.class);
        System.out.print(clazz.getSimpleName());
    }
}