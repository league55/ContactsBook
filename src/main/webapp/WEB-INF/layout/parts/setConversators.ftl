<#import "/spring.ftl" as spring />


<fieldset class="main">
    <legend>Get conversation with</legend>
    <form action="/view/${tel}" modelAttribute="sender" method="get">

        <select name="sender" size="1">
            <option value="default"> select contact</option>
        <#list sendersTel as tel>
            <option value="${tel}">${tel}</option>
        </#list>
        </select>
        <input class="codrops-demos" type="submit" value="   Submit   "/></br>
    </form>

</fieldset>




