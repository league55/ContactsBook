<#macro myLayout title="Contacts Book">

<html>
<head>
    <link rel="shortcut icon" href="../favicon.ico">
    <link href='http://fonts.googleapis.com/css?family=Ultra|Orienta' rel='stylesheet' type='text/css'>
    <script src="js/modernizr.custom.63321.js"></script>
    <title>
    ${title}
    </title>
    <style type="text/css"><#include "styles.css"><#include "table.css"></style>
</head>

<body>
<div class="container" style="min-height: 100%">
    <!--  <#nested/> -->
    <table>
        <tr><#include "header.ftl"/></tr>
        <tr><#include "userForm.ftl"/></tr>
        <tr><#include "userList.ftl"/></tr>

    </table>
</div>
<div class="appendix"></div>
    <#include "footer.ftl"/>
</body>
</html>
</#macro>