<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <li><a href='MainView.jsp'>Investing</a></li>
                    <li><a href='FundsTransfer.jsp'>Funds Transfer</a></li>
                    <li><a href='Transaction.jsp'>Transaction History</a></li>
                    <li><a href='Login.jsp'>Logout</a></li>
                </ul>
            </li>

        </ul>
        <h5>My Balance: 10000</h5>
        <table class='table'>
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
            </tr>
            <tr>
                <td>
                    GOOG
                </td>
                <td>
                    1000000
                </td>
                <td>
                    570.00
                </td>
                <td>
                    10000
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
                        if(symbol != "") {
                            $('[name="stocksymbol"]').val(symbol);
                            new Markit.InteractiveChartApi(symbol, 3650);
                        }
                        
                    });
                });
            </script>
        </div>

    </body>
</html>
