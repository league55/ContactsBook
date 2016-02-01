<html>
<head><title> ${title} </title>
<body>
<h1> ${title} </h1>
<p>
    ${message}
</p>
<h3>Contacts</h3>

<div>
    <table id="dataTable" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>aaaaaaaaaaaaaaaaaaaa</th>
            <th>aaaaaaaaaaaaaaaaaaaa</th>
            <th>aaaaaaaaaaaaaaaaaaaa</th>
            <th>aaaaaaaaaaaaaaaaaaaa</th>
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