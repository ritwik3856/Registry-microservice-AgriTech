package com.ninjacart.agri.advisory.architecture;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(
        packages = "com.ninjacart.agri.advisory",
        importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchitectureTest {

//  @ArchTest
//  static final ArchRule modulesShouldOnlyBeAccessedThroughTheirAPI =
//      noClasses()
//          .that()
//          .resideOutsideOfPackage("..crop.api..")
//          .should()
//          .accessClassesThat()
//          .resideInAnyPackage("..crop.service..")
//          .as("Modules should only be accessed through their API");

//  @ArchTest
//  static final ArchRule noCyclesBetweenModules =
//      slices()
//          .matching("com.ninjacart.agri.advisory.(*)..")
//          .should()
//          .beFreeOfCycles()
//          .as("Modules should be free of cycles");

  @ArchTest
  static final ArchRule repositoriesShouldNotDependOnServices =
          noClasses()
                  .that()
                  .resideInAPackage("..repository..")
                  .should()
                  .dependOnClassesThat()
                  .resideInAPackage("..service..")
                  .as("Repositories should not depend on services");

  @ArchTest
  static final ArchRule servicesShouldNotDependOnControllers =
          noClasses()
                  .that()
                  .resideInAPackage("..crop.service..")
                  .should()
                  .dependOnClassesThat()
                  .resideInAPackage("..crop.api..")
                  .as("Repositories should not depend on services");

  @ArchTest
  static final ArchRule preferConstructorInjection =
          noFields()
                  .should()
                  .beAnnotatedWith(Autowired.class)
                  .because("Constructor injection is preferred over field injection");

  @ArchTest
  static final ArchRule methods_should_return_response_entity =
          methods()
                  .that()
                  .arePublic()
                  .and()
                  .areDeclaredInClassesThat()
                  .areAnnotatedWith(RestController.class)
                  .should()
                  .haveRawReturnType(ResponseEntity.class)
                  .because("Controller endpoints should return a ResponseEntity object");

  //  @ArchTest
  //  static final ArchRule class_names_should_not_contain_ninjacart =
  //      classes()
  //          .should(
  //              new ArchCondition<JavaClass>("not contain 'ninjacart'") {
  //                @Override
  //                public void check(JavaClass item, ConditionEvents events) {
  //                  String className = item.getName();
  //                  boolean containsNinjacart = className.toLowerCase().contains("ninjacart");
  //                  String message = String.format("Class %s contains 'ninjacart'", className);
  //                  events.add(new SimpleConditionEvent(item, !containsNinjacart, message));
  //                }
  //              })
  //          .because("Class names should not contain 'ninjacart'");

  @ArchTest
  static final ArchRule class_names_should_not_contain_ninjacart =
          classes()
                  .should(
                          new ArchCondition<JavaClass>("not contain 'ninjacart' in the class name") {
                            @Override
                            public void check(JavaClass item, ConditionEvents events) {
                              String simpleClassName = item.getSimpleName();
                              boolean containsNinjacart = simpleClassName.toLowerCase().contains("ninjacart");
                              if (containsNinjacart) {
                                String message =
                                        String.format("Class name %s contains 'ninjacart'", simpleClassName);
                                events.add(SimpleConditionEvent.violated(item, message));
                              }
                            }
                          })
                  .because(
                          "Class names should not contain 'ninjacart', although it's allowed in the package name.");

  @ArchTest
  static final ArchRule fields_should_not_be_public_in_restcontrollers_or_services =
          fields()
                  .that()
                  .areDeclaredInClassesThat()
                  .areAnnotatedWith(RestController.class)
                  .or()
                  .areDeclaredInClassesThat()
                  .areAnnotatedWith(Service.class)
                  .should()
                  .notBePublic()
                  .because(
                          "Public fields are not allowed in classes annotated with @RestController or @Service");

  private static final String CONTROLLER_SUFFIX = "Controller";

  @ArchTest
  static final ArchRule classes_annotated_with_restcontroller_should_be_named_properly =
          classes()
                  .that()
                  .areAnnotatedWith(RestController.class)
                  .should()
                  .haveSimpleNameEndingWith(CONTROLLER_SUFFIX)
                  .because(
                          String.format(
                                  "Classes annotated with @RestController should be named with '%s' suffix",
                                  CONTROLLER_SUFFIX));

  //  private static final String FORBIDDEN_SUFFIX = "Controller";
  //
  //  @ArchTest
  //  static final ArchRule classes_annotated_with_restcontroller_should_not_have_controller_suffix
  // =
  //      classes()
  //          .that()
  //          .areAnnotatedWith(RestController.class)
  //          .should()
  //          .haveSimpleNameNotEndingWith(FORBIDDEN_SUFFIX)
  //          .because(
  //              String.format(
  //                  "Classes annotated with @RestController should not be named with '%s' suffix",
  //                  FORBIDDEN_SUFFIX));

  private static final String SERVICE_SUFFIX = "Service";

  @ArchTest
  static final ArchRule classes_annotated_with_service_should_be_named_properly =
          classes()
                  .that()
                  .areAnnotatedWith(Service.class)
                  .should()
                  .haveSimpleNameEndingWith(SERVICE_SUFFIX)
                  .because(
                          String.format(
                                  "Classes annotated with @Service should be named with '%s' suffix",
                                  SERVICE_SUFFIX));

  //  private static final String FORBIDDEN_SUFFIX = "Service";
  //  @ArchTest
  //  static final ArchRule classes_annotated_with_service_should_not_have_service_suffix
  // = classes()
  //          .that().areAnnotatedWith(Service.class)
  //          .should().haveSimpleNameNotEndingWith(FORBIDDEN_SUFFIX)
  //          .because(String.format("Classes annotated with @Service should not be named
  // with '%s' suffix", FORBIDDEN_SUFFIX));

}