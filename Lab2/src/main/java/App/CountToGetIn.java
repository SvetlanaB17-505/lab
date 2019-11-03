package App;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/Lab2_war_exploded/CountToGetIn"})
public class CountToGetIn extends HttpServlet {
    private Map<Integer, Set<String>> map;
    private UseSingleton session;

    public CountToGetIn() {
    }

    public void init() {
        this.map = new HashMap();
        this.session = UseSingleton.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random(System.currentTimeMillis());
        int num1 = -127 + random.nextInt(475);
        int num2 = -127 + random.nextInt(475);
        int sum = num1 + num2;
        String HashSum = Integer.toString(Integer.toString(sum).hashCode()) + System.currentTimeMillis();
        if (this.map.containsKey(sum)) {
            ((Set)this.map.get(sum)).add(HashSum);
        } else {
            Set<String> set = new HashSet();
            set.add(HashSum);
            this.map.put(sum, set);
        }

        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("sum", sum);
        request.setAttribute("HashSum", HashSum);
        request.getRequestDispatcher("count_to_get_in.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int answer = Integer.parseInt(request.getParameter("answer"));
        String hash = request.getParameter("HashSum");
        if (this.map.containsKey(answer) && ((Set)this.map.get(answer)).contains(hash)) {
            String id = UUID.randomUUID().toString();
            this.session.addId(id);
            Cookie cookie = new Cookie("SessionId", id);
            response.addCookie(cookie);
            response.sendRedirect("http://localhost:8080/Lab2_war_exploded/Hello");
        } else {
            response.sendRedirect("http://localhost:8080/Lab2_war_exploded/CountToGetIn");
        }

    }
}
