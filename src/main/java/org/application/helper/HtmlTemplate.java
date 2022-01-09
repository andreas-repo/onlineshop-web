package org.application.helper;

public class HtmlTemplate {
    public static String beginningHtml() {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<link rel=\"stylesheet\" href=\"resources/css/styles.css\">" +
                "</head>" +
                "<body>";
    }

    public static String endHtml() {
        return "</body>" +
                "</html>";
    }
}
