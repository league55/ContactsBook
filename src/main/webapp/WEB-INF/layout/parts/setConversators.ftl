<#import "/spring.ftl" as spring />


<fieldset class="main">
    <legend>Get conversation with</legend>
    <form action="/view/${id}" modelAttribute="senderId" method="get">

        <select name="senderId" size="1">
            <option> select contact</option>
        <#list senders as sender>

            <option value="${sender.id}">${sender.tel}</option>

        </#list>
        </select>
        <input class="codrops-demos" type="submit" value="   Submit   "/></br>
    </form>

</fieldset>




