<!DOCTYPE html>
<html xmlns:v="urn:schemas-microsoft-com:vml" lang="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0; maximum-scale=1.0;">
    <title>Welcome Email</title>
    <style type="text/css">
        body {
            width: 100%;
            background-color: #ffffff;
            margin: 0;
            padding: 0;
            font-family: 'Oxygen', sans-serif;
            -webkit-font-smoothing: antialiased;
        }
        table {
            font-size: 14px;
            border: 0;
            margin: auto;
        }
        h1, p {
            margin: 0;
            padding: 0;
        }
        .container {
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
            background: #003b65;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .header {
            background-color: #003b65;
            padding: 20px;
            text-align: center;
        }
        .header img {
            width: 120px;
        }
        .content {
            padding: 20px;
            color: #ffffff;
            line-height: 1.6;
        }
        .content a {
            color: #ffffff;
            text-decoration: underline;
            font-weight: bold;
        }
        .footer {
            text-align: center;
            padding: 20px;
            font-size: 12px;
            color: #aaaaaa;
            background-color: #003b65;
            color: #ffffff;
        }
    </style>
</head>

<body>
<table class="container">
    <tr>
        <td class="header">
            <img src="https://api.smtprelay.co/userfile/2c21cc40-8793-4223-832f-dc0033a7111a/logo_fbn_dark.png" alt="FirstBank Logo">
        </td>
    </tr>
    <tr>
        <td class="content">
            <p>Dear <strong>${firstName} ${lastName}</strong>,</p><br>
            <p>${details}</p><br>


        </td>
    </tr>
    <tr>
        <td class="footer">
            Samuel Asabia House, Marina Lagos Nigeria.<br>
            www.firstbanknigeria.com<br>
            Powered by FirstBank of Nigeria Limited.
        </td>
    </tr>
</table>
</body>
</html>