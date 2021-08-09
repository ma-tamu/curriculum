package jp.co.sample;

import jp.co.sample.servlet.HelloWorldServlet;
import org.apache.catalina.Context;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;

public class Main {

    public static void main(String[] args) throws Exception {
        final var tomcat = new Tomcat();
        tomcat.setPort(8080);

        final var base = new File("src/main/resources/static");
        final var context = tomcat.addContext("/app", base.getAbsolutePath());

        Tomcat.addServlet(context, "default", new DefaultServlet()).addMapping("/");

        Tomcat.addServlet(context, "hello", new HelloWorldServlet()).addMapping("/hello");

        tomcat.start();
        Desktop.getDesktop().browse(new URI("http://localhost:8080/app/hello"));
        tomcat.getServer().await();
    }
}
