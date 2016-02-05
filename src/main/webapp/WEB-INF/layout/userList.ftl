<div>
    <table class="main" id="dataTable" border="1">
        <thead>
        <tr>

            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone</th>

        </tr>
        </thead>

        <tbody>

        <#list contacts as Contact>

        <tr> <#assign tel="${Contact.tel}"/>


            <td>${Contact.firstName}</td>
            <td>${Contact.lastName}</td>
            <td>${Contact.tel}</td>
            <td><a href="/delete/${Contact.tel}">Delete</a></td>
            <td><a href="/edit/${Contact.tel}">Edit</a></td>
        <tr>
        </#list>

        </tbody>
    </table>
</div>
