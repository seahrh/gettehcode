package gettehcode;

import com.google.appengine.api.utils.SystemProperty;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloAppEngine", value = "/hello")
public class HelloAppEngine extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String version = SystemProperty.version.get();
        String env = SystemProperty.environment.get();
        String jspecVersion = System.getProperty("java.specification.version");
        response.setContentType("text/plain");
        response.getWriter().println("Hello App Engine - Standard using "
                + version + " Java " + jspecVersion + " env:" + env);
    }

    public static String getInfo() {
        StringBuilder sb = new StringBuilder();
        Properties props = System.getProperties();
        TreeMap<String, String> map = new TreeMap<>();
        props.forEach((key, val) -> map.put((String) key, (String) val));
        String k, v;
        for (Entry<String, String> p : map.entrySet()) {
            k = p.getKey();
            v = p.getValue();
            sb.append(k);
            sb.append("=");
            sb.append(v);
            sb.append("\n");
        }
        return sb.toString();
    }

}
