<div>
<#if messeges??>

    <table class="main" id="dataTable" border="1">
        <thead>
        <tr>

            <th>From</th>
            <th>Messege</th>
            <th>Time</th>

        </tr>
        </thead>

        <tbody>

            <#assign name=names/>
        <#list messeges as messege>


        <tr>
            <td width="100px">From ${names[0]}  ${name[0]} :</td>
            <td width="200px">${messege.content}</td>
            <td>${messege.time}</td>

        <tr>
        </#list>

        </tbody>
    </table>

</#if>
</div>