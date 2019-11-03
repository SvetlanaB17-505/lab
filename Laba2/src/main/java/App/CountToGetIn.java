package App;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/Laba2_war_exploded/CountToGetIn")
public class CountToGetIn extends HttpServlet {

    private Map<Integer, Set<String>> map;
    private UseSingleton session;

    public void init(){
        map = new HashMap<Integer, Set<String>>();
        session = UseSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Random random = new Random(System.currentTimeMillis());
        int num1 = -127 + random.nextInt(475);
        int num2 = -127 + random.nextInt(475);
        int sum = num1 + num2;
        String HashSum = Integer.toString(Integer.toString(sum).hashCode()) + System.currentTimeMillis();

        if (map.containsKey(sum))
            map.get(sum).add(HashSum);
        else {
            Set<String> set = new HashSet<String>();
            set.add(HashSum);
            map.put(sum, set);
        }

        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("sum", sum);
        request.setAttribute("HashSum", HashSum);
        request.getRequestDispatcher("count_to_get_in.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int answer = Integer.parseInt(request.getParameter("answer"));
        String hash = request.getParameter("HashSum");

        if (map.containsKey(answer) && map.get(answer).contains(hash)){
            String id = UUID.randomUUID().toString();
            session.addId(id);
            Cookie cookie = new Cookie("SessionId", id);
            response.addCookie(cookie);
            //request.getRequestDispatcher("hello_inside.jsp").forward(request, response);
            response.sendRedirect("http://localhost:8080/Laba2_war_exploded/Hello");
        } else {
            response.sendRedirect("http://localhost:8080/Laba2_war_exploded/CountToGetIn");
        }

    }
}