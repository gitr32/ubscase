<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" media="screen" href="bootstrap/css/bootstrap.min.css">
        
        <script src="bootstrap/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="bootstrap/highchart.js"></script>
        <script src="bootstrap/ticker.js"></script>
        <script src="bootstrap/timer.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1">

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
                    <li><a href='#'>Investing</a></li>
                    <li><a href='#'>Funds Transfer</a></li>
                    <li><a href='#'>Transaction History</a></li>
                    <li><a href='Login.jsp'>Logout</a></li>
                </ul>
            </li>

        </ul>
        <br/>
        <table class='table'>
            <tr>
                <th>
                    Trades
                </th>
                <th>
                    Volume
                </th>
                <th>
                    Profit
                </th>
            </tr>
            <tr>
                <td>
                    GOOG
                </td>
                <td>
                    1000000
                </td>
                <td>
                    10000
                </td>
            </tr>
        </table>
        <br/>
        Symbol Name: <input class = 'input-small' type="text" id = "symbolName">
        <button type='button' class ='btn' name="searchGraph">Find</button>
        <div id='chartDemoContainer' style="width: '100%';">
            <script>
                $(document).ready(function () {

                    new Markit.InteractiveChartApi("GOOG", 3650); //5 seconds
                    
                    $('[name="searchGraph"]').click(function () {
                        var symbol = $("#symbolName").val();
                        new Markit.InteractiveChartApi(symbol, 3650);
                    });
                });
            </script>
        </div>

    </body>
</html>
