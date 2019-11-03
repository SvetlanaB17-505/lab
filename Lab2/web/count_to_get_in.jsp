
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sum</title>
    <style>
        body {
            background-color: antiquewhite;
            text-align: center;
            color: burlywood;
            font-size: 200%;
        }
        h1 {
            color: grey;
            font-size: 350%;
        }
        #no{
            font-size: 100%;
        }
    </style>
</head>

<body>

<br>
<h1>Count the sum</h1>
<b>
    <p> ${num1} + ${num2}</p>
</b>
<p id="no">(Hint  ${sum})</p>
<br>

<form method="post">
    <lable for="answer"> Sum: </lable>
    <label for="answer"></label><input id="answer" type="text" name="answer">
    <input type="submit" name="submit" value="Submit"/>
    <input type="hidden" name="HashSum" value=${HashSum}>
</form>

</body>
</html>
