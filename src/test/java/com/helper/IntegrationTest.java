package com.helper;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:db-context.xml", "/SimpleCalculatorApp-servlet-test.xml"})
public class IntegrationTest {

}
