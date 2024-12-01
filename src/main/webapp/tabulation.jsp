<jsp:useBean id="result" scope="request" type="com.example.web3.model.Result"/>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="container">
    <button type="submit" class="button" onclick="GoBack()">Input new values</button>
    <p>Sum : ${result.sum}</p>
    <p>Average : ${result.average}</p>


    <div class="table" >
        <table class="table">
            <thead>
            <tr><th></th><th>Index</th><th>X</th><th>Y</th></tr>
            </thead>
            <tbody>
            <tr><td>Max</td><td>${result.maxI}</td><td>${result.maxX}</td><td>${result.maxY}</td></tr>
            <tr><td>Min</td><td>${result.minI}</td><td>${result.minX}</td><td>${result.minY}</td></tr>
            </tbody>
        </table>
    </div>


    <%
        double[] arrX = result.getXArr();
        double[] arrY = result.getYArr();
    %>
    <table class="table">
        <thead>
        <tr><th>Index</th><th>X</th><th>Y</th></tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < arrX.length; i++) {
        %>
        <tr>
            <td><%= i %></td>
            <td><%= arrX[i] %></td>
            <td><%= arrY[i] %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<script>
    function GoBack() {
        window.location.href = "index.jsp";
    }
</script>
</body>
</html>