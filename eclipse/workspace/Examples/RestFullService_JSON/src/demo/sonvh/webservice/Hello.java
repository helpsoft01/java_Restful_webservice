package demo.sonvh.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

	/*
	 * HttpServletRequest: được sử dụng lưu session, tạo security cho user khi
	 * đăng nhập
	 */
	@Context
	private HttpServletRequest httpRequest;

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {

		HttpSession session = httpRequest.getSession();// ContentType();
														// ;//req.getSession(true);
		Object foo = session.getAttribute("foo");
		if (foo != null) {
			System.out.println(foo.toString());
		} else {
			foo = "bar";
			session.setAttribute("foo", "bar");
		}
		return foo.toString();
		// return "Hello Jersey";
	}

	// This method is called if XML is request
	// @GET
	// @Produces(MediaType.TEXT_XML)
	// public String sayXMLHello() {
	// return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	// }
	//
	// // This method is called if HTML is request
	// @GET
	// @Produces(MediaType.TEXT_HTML)
	// public String sayHtmlHello() {
	// return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>"
	// + "Hello Jersey" + "</body></h1>"
	// + "</html> ";
	// }

}