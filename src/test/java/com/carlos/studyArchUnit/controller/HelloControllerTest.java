package com.carlos.studyArchUnit.controller;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(ArchUnitRunner.class) // Remove this line for JUnit 5!!
@AnalyzeClasses(packages = "com.carlos.studyArchUnit")
public class HelloControllerTest {

    @Test
    void home() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.carlos.studyArchUnit");
        JavaClass clazz = classes.get(HelloController.class);
        System.out.print(clazz.getSimpleName());
    }

    @ArchTest
    private static final ArchRule myRule = classes().that().haveSimpleNameEndingWith("Controller")
            .should().resideInAPackage("com.carlos.studyArchUnit.controller");

    @ArchTest
    public void should_Controller_classes_only_in_controller_package(JavaClasses javaClasses) {
        myRule.check(javaClasses);
    }
}