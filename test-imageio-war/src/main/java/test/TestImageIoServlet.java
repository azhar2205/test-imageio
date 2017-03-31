package test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestImageIoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		URL url = TestImageIoServlet.class.getClassLoader().getResource("test.tif");
		File file = new File(url.getFile());
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray); // read file into bytes[]
		fis.close();

		BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytesArray));

		response.getWriter().write("<html><body>Image width = " + image.getWidth() + "</body></html>");
	}

}
