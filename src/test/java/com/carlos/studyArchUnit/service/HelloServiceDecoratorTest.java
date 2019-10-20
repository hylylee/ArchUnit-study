package com.carlos.studyArchUnit.service;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(ArchUnitRunner.class) // Remove this line for JUnit 5!!
@AnalyzeClasses(packages = "com.carlos.studyArchUnit")
public class HelloServiceDecoratorTest {

    @ArchTest
    public static final ArchRule dependRule = noClasses().that().resideInAPackage("..service..")
            .should().dependOnClassesThat().resideInAPackage("..controller..");

    @ArchTest
    public static final ArchRule haveDependRule = classes().that().resideInAPackage("..service..")
            .should().onlyHaveDependentClassesThat().resideInAnyPackage("..controller..", "..service..");

    @ArchTest
    public void services_should_only_be_accessed_by_Controllers(JavaClasses classes) {
        dependRule.check(classes);
        haveDependRule.check(classes);
    }
}