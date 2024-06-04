package com.example.lab_9.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;

@WebServlet(name = "timeServlet", urlPatterns = "/time-servlet")
public class TimeServlet extends HttpServlet {
    public TimeServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Enumeration<String> headers = request.getHeaderNames();

        out.println("<form method='GET'><input type='submit' value=\"Обновить время\"></form>");
        out.println();
        out.println("<h3>" + getCurrentTime() + "</h3>");
        out.println("</br>");
        out.println("<h3>" + "IP: " + getClientIP(request) + "</h3>");
        out.println("<h3>" + "IP version: " + getIpVersion(getClientIP(request)) + "</h3>");
        out.println("<h3> Заголовки:</h3>");

        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            out.print("<h4>" + headerName  + ": " + request.getHeader(headerName) +  "</h4>");
        }


    }

    private String getCurrentTime() {
        Date currentDate = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss");
        return formatForDateNow.format(currentDate);
    }

    private String getIpVersion(String ip) throws UnknownHostException {
        InetAddress address = InetAddress.getByName(ip);
        if (address instanceof Inet6Address) {
            return "ipv6";
        } else if (address instanceof Inet4Address) {
            return "ipv4";
        }
        return "";
    }

    public static String getClientIP(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
}