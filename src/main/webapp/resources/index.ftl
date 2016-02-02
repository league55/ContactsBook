<html>
<head><title> ${title} </title>
<body>
<h1> ${title} </h1>
<p>
    ${message}
</p>
<h3>Contacts</h3>

<fieldset>
    <legend>Add Contact</legend>
    <form action="/add" modelAttribute="contactForm" method="post">
        Firstname: <input type="text" name="firstName" /> <br/>
        Lastname: <input type="text" name="lastName" />   <br/>
        Phone: <input type="text" name="tel" /> <br/>
        <input type="submit" value="   Save   " />
    </form>
</fieldset>



<!--    <form:form method="post" modelAttribute="contactForm" action="/add">
        Firstname: <form:input path="firstName" type="text" /> <br/>
        Lastname: <form:input path="lastName"   type="text" /> <br/>
        Phone:    <form:input path="tel"   type="text" /> <br/>

        <input type="submit" value="   Save   " />
    </form:form>
-->


<div>
    <table id="dataTable" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>     ID   </th>
            <th>First Name</th>
            <th>Last  Name</th>
            <th>   Phone  </th>
        </tr>
        <thead>
        <tbody>

<#list contacts as Contact>

    <tr>
                <td>${Contact.contact_id}</td>
                <td>${Contact.firstName}</td>
                <td>${Contact.lastName}</td>
                <td>${Contact.tel}</td>
            <tr>
</#list>
       
        </tbody>
    </table>
</div>

</body>
</html>