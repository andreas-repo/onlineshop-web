package org.application.helper;

public class HtmlTemplate {
    public static String beginningHtml() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>" +
                "<link rel=\"stylesheet\" href=\"resources/css/styles.css\">" +
                "</head>" +
                "<body>\n";
    }

    public static String endHtml() {
        return "</body>\n" +
                "</html>";
    }
}
