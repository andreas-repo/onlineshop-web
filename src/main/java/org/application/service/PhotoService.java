package org.application.service;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class PhotoService implements Runnable {
    private AsyncContext ac;

    public PhotoService(AsyncContext ac) {
        this.ac = ac;
    }

    @Override
    public void run() {
        final HttpServletRequest req = (HttpServletRequest) ac.getRequest();
        final HttpServletResponse resp = (HttpServletResponse) ac.getResponse();

        OutputStream os = null;
        InputStream is = null;
        PrintWriter out = null;

        try {
            final Part part = req.getPart("photo");
            os = new FileOutputStream("C:\\Users\\andre\\Development\\jarkata-ee-examples\\onlineshop-web\\src\\main\\webapp\\resources\\tmp\\" + part.getSubmittedFileName());
            is = part.getInputStream();
            out = resp.getWriter();

            byte[] bytes = new byte[1024];
            int i = 0;

            while ((i = is.read()) != -1) {
                os.write(bytes, 0, i);
            }

            os.flush();
            out.write("true");
            ac.complete();
        } catch (Exception ex) {
            assert out != null;
            out.write("false");
            //TODO replace with logging
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
                out.close();
            } catch (Exception e) {
                //TODO replace with logging
                e.printStackTrace();
            }
        }
    }
}
