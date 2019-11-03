package App;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter({"/FilterHello"})
public class FilterHello implements Filter {
    private UseSingleton SessionId;

    public FilterHello() {
    }

    public void init(FilterConfig filterConfig) {
        this.SessionId = UseSingleton.getInstance();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Cookie[] var7 = cookies;
            int var8 = cookies.length;

            for(int var9 = 0; var9 < var8; ++var9) {
                Cookie cookie = var7[var9];
                if (cookie.getName().equals("SessionId") && this.SessionId.containsId(cookie.getValue())) {
                    request.getRequestDispatcher("Hello").forward(request, response);
                }
            }
        } else {
            request.getRequestDispatcher("CountToGetIn").forward(request, response);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
