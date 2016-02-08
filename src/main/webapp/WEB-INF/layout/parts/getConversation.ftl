<div>
    <table class="main" id="dataTable" border="1">
        <thead>
        <tr>

            <th>From</th>
            <th>Messege</th>
            <th>Time</th>

        </tr>
        </thead>

        <tbody>

        <#list messeges as messege>

        <tr>
            <td width="100px">From ${messege.sender.firstName}:</td>
            <td width="200px">${messege.content}</td>
            <td>${messege.time}</td>

        <tr>
        </#list>

        </tbody>
    </table>
</div>
