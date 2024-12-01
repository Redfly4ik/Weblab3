package com.example.web3;

import com.example.web3.logic.CalcFunction;
import com.example.web3.model.Result;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "calculate", value = "/calculate")
public class CalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");

        double start = Double.parseDouble(request.getParameter("start"));
        double end = Double.parseDouble(request.getParameter("end"));
        double step = Double.parseDouble(request.getParameter("step"));
        Result result = getResult(start, end, step);

        request.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/tabulation.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Result getResult(double start, double end, double step) {
        CalcFunction calcFunction = new CalcFunction(start, end, step);

        int maxI = calcFunction.getIndexOfMax();
        int minI = calcFunction.getIndexOfMin();
        double maxX = calcFunction.getX(maxI);
        double maxY = calcFunction.getY(maxI);
        double minX = calcFunction.getX(minI);
        double minY = calcFunction.getY(minI);
        double[] xArr = calcFunction.getXArr();
        double[] yArr = calcFunction.getYArr();
        double sum = calcFunction.getSum();
        double average = calcFunction.getAverage();

        return new Result(maxI, minI, maxX, maxY, minX, minY, sum, average, xArr, yArr);
    }

    private void GoBack(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

