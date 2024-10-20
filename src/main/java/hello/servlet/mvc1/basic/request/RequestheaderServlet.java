package hello.servlet.mvc1.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet",urlPatterns = "/request-header")
public class RequestheaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
        printEtc(req);
    }

    private void printStartLine(HttpServletRequest request){
        System.out.println("---ReQuest-Line - start---");

        System.out.println("request.getMethod()= "+request.getMethod());
        System.out.println("request.getProtocal()="+request.getProtocol());
        System.out.println("request.getScheme() = " + request.getScheme());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURL() = " + request.getRequestURI());

        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSq = " + request.isSecure());

        System.out.println("REQUEST-LINE-end ---");
    }

    private void printHeaders(HttpServletRequest request){
        System.out.println("---Headers- start---");

        Enumeration <String>headerNames=request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName=headerNames.nextElement();
            System.out.println(headerName+":"+request.getHeader(headerName));
        }
        request.getHeaderNames().asIterator()
                        .forEachRemaining(headerName-> System.out.println(headerName+":"+request.getHeader(headerName)));
        System.out.println("Headers end");


        request.getHeaderNames();
    }
    private void printHeaderUtils(HttpServletRequest request){
        System.out.println(" --- Header 편의 조회 start ---" );
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName()="+request.getServerName());
        System.out.println("request.getServerPort()="+request.getServerPort());
        System.out.println("");

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale="+locale));
        System.out.println("request.getLocale()="+request.getLocale());


        System.out.println("[cookie 편의 조회]");
        if(request.getCookies()!=null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }

            System.out.println();
            System.out.println("[content 편의 조회]");
            System.out.println("request.getContentType() = " + request.getContentType());
            System.out.println("request.getContentLength() = " + request.getContentLength());
            System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

            System.out.println("--HEADER 편의 조회 end");


    }

    private void printEtc(HttpServletRequest request){
        System.out.println("[Remote 정보]");//요청온 정보(네트워크)
        System.out.println("request.getRemoteHost = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());
        System.out.println("request.getRemoteUser() = " + request.getRemoteUser());

        System.out.println("[Local 정보]");//내서버 정보
        System.out.println("request.getLocalName = " + request.getLocalName());
        System.out.println("request.getLocalPort = " + request.getLocalPort());
        System.out.println("request.getLocalAddr = " + request.getLocalAddr());
    }
}
