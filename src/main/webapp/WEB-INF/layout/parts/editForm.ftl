<table class="main" id="dataTable" border="1" xmlns="http://www.w3.org/1999/html">
    <thead>
    <tr>

        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone</th>
        <th></th>

    </tr>
    </thead>

    <tbody>


    <tr>
        <td>${theContact.firstName}</td>
        <td>${theContact.lastName}</td>
        <td>${theContact.tel}</td>
        <td><a href="/delete/${theContact.tel}">Delete</a></td>
    <tr>

        <form action="/doEdit/${theContact.tel}" modelAttribute="contact" method="post">
    <tr>
        <td><input type="text" name="firstName"/> <br/></td>
        <td><input type="text" name="lastName"/> <br/></td>
        <td><input type="text" name="tel"/> <br/></td>
        <td><input class="codrops-demos" type="submit" value="   Save   "/></td>
    </tr>
    </tbody>

    </form>


</table>