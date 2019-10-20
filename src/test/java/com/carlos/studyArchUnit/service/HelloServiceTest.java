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
import static org.junit.jupiter.api.Assertions.*;

@RunWith(ArchUnitRunner.class) // Remove this line for JUnit 5!!
@AnalyzeClasses(packages = "com.carlos.studyArchUnit")
class HelloServiceTest {

    @ArchTest
    public static final ArchRule myRule = classes()
            .that().resideInAPackage("..service..")
            .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..");

    @Test
    public void services_should_only_be_accessed_by_Controllers() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.carlos.studyArchUnit");

        myRule.check(importedClasses);
    }
}