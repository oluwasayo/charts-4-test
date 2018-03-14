package com.stuff;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

@VaadinServletConfiguration(productionMode = false, ui = DemoView.class)
@WebServlet("/*")
public class DemoServlet extends VaadinServlet {
}
