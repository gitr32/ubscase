<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" media="screen" href="bootstrap/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="bootstrap/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="bootstrap/highchart.js"></script>
        <script src="bootstrap/ticker.js"></script>
        <script src="bootstrap/timer.js"></script>
    </head>
    <body>
        <ul class='nav nav-pills'>
            <li class="dropdown">
                <a class="dropdown-toggle"
                   data-toggle="dropdown"
                   href="#">
                    Menu
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href='Account.jsp'>Accounts</a></li>
                    <li><a href='MainView.jsp'>Investing</a></li>
                    <li><a href='FundsTransfer.jsp'>Funds Transfer</a></li>
                    <li><a href='Transaction.jsp'>Transaction History</a></li>
                    <li><a href='Login.jsp'>Logout</a></li>
                </ul>
            </li>

        </ul>
        <h5>
            <%
                session = request.getSession();
                String balance = (String)session.getAttribute("balance");
                String account = (String) session.getAttribute("account");
                double dblBalance = Double.parseDouble(balance);
                DecimalFormat df = new DecimalFormat("###,###.00");
                out.println(df.format(dblBalance));
            %></h5>
        <table class='table table-hover'>
            <tr>
                <th>
                    Trades
                </th>
                <th>
                    Volume
                </th>
                <th>
                    Price
                </th>
                <th>
                    Profit
                </th>
                <th>

                </th>
            </tr>
            <tr>
                <td>
                    GOOG
                </td>
                <td>
                    1000
                </td>
                <td>
                    558.30 
                </td>
                <td>
                    0.0
                </td>
                <td>
                    <a href='#'>Close</a>
                </td>
            </tr>
        </table>
        <br/>
        <form action="BuyStock.jsp" method="POST">
            <table>
                <tr>
                    <td>
                        Symbol Name: <input class = 'input-small' type="text" id = "symbolName">
                    </td>

                    <td style='vertical-align: top'>
                        <button type='button' class ='btn' name="searchGraph">Find</button>
                    </td>
                    <td>
                        <input type='hidden' name='stockSymbol' value='GOOG'>
                    </td>
                    <td  style='vertical-align: top'>
                        <input type='submit' class='btn' value='Buy Stock'>
                    </td>
                </tr>
            </table>
        </form>
        <div id='chartDemoContainer' style="width: '100%';">
            <script>
                $(document).ready(function () {

                    new Markit.InteractiveChartApi("GOOG", 3650); //5 seconds

                    $('[name="searchGraph"]').click(function () {
                        var symbol = $("#symbolName").val();
                        if (symbol != "") {
                            $('[name="stocksymbol"]').val(symbol);
                            new Markit.InteractiveChartApi(symbol, 3650);
                        }

                    });
                });
            </script>
        </div>

    </body>
</html>
