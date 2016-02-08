<#macro myLayout title="Contacts Book">

<html>
<head>
    <link rel="shortcut icon" href="../favicon.ico">
    <link href='http://fonts.googleapis.com/css?family=Ultra|Orienta' rel='stylesheet' type='text/css'>
    <script src="js/modernizr.custom.63321.js"></script>
    <title>
    ${title}
    </title>
    <style type="text/css"><#include "../css/styles.css"><#include "../css/table.css"></style>
</head>

<body>

<div class="container">
    <!--  <#nested/> -->
    <table>
        <tr><#include "parts/header.ftl"/></tr>

        <tr><#include "parts/composeMessege.ftl"/></tr>
        <tr><#include "parts/footer.ftl"/></tr>


    </table>
</div>
<div class="appendix"/>
    <#include "parts/footer.ftl"/>
</html>
</#macro>