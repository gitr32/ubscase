<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" media="screen" href="bootstrap/css/bootstrap.min.css">

        <script src="bootstrap/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="bootstrap/highchart.js"></script>
        <script src="bootstrap/ticker.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <body>
        <ul class='nav nav-pills'>
            <li class="dropdown">
                <a class="dropdown-toggle"
                   data-toggle="dropdown"
                   href="#">
                    Home
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href='#'>First Link</a></li>
                    <li><a href='#'>Second Link</a></li>

                </ul>
            </li>
            <li>
                <a href='#'>Investing</a>
            </li>
            <li>
                <a href='#'>Funds Transfer</a>
            </li>
            <li>
                <a href='#'>Bill Payments</a>
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

        <div id='chartDemoContainer' style="width: '100%';">
            <script>
                new Markit.InteractiveChartApi('GOOG', 3650);
            </script>
        </div>

    </body>
</html>
