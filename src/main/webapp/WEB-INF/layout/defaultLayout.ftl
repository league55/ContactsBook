<#macro myLayout title="Contacts Book">
    <#import "/spring.ftl" as spring />

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


<form class="form-horizontal" method="POST" action="/test">

    <div class="container" style="min-height: 100%">
        <#nested/>

      <#include "header.ftl"/>
    <#include "userForm.ftl"/>
     <#include "userList.ftl"/>


</div>
<div class="appendix"></div>
    <#include "footer.ftl"/>
</body>
</html>
</#macro>