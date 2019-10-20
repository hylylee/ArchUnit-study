package com.carlos.studyArchUnit.dao;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.junit.Assert.*;

@RunWith(ArchUnitRunner.class) // Remove this line for JUnit 5!!
@AnalyzeClasses(packages = "com.carlos.studyArchUnit")
public class TestDaoTest {

    @ArchTest
    private static ArchRule myRule = classes().that().implement(TestDao.class)
            .should().haveSimpleNameEndingWith("Impl");

    @ArchTest
    private static ArchRule myRule2 = classes().that().implement(".*Dao")
            .should().haveSimpleNameEndingWith("Impl");
    
    @ArchTest
    public void should_name_with_Impl_when_implements_Dao(JavaClasses javaClasses) {
        myRule.check(javaClasses);
        myRule2.check(javaClasses);
    }

}