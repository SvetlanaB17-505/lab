package App;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/FilterHello")
public class FilterHello implements Filter {

    private UseSingleton SessionId;

    public void init(FilterConfig filterConfig) {
        SessionId = UseSingleton.getInstance();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("SessionId") && SessionId.containsId(cookie.getValue())){
                    request.getRequestDispatcher("Hello").forward(request, response);
                    //response.sendRedirect("http://localhost:8080/Laba2_war_exploded/Hello");
                }
            }
        } else request.getRequestDispatcher("CountToGetIn").forward(request, response);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}

