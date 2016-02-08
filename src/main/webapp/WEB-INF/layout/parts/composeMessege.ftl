<fieldset class="main">
    <legend>Compose messege</legend>


    <form action="/messegeSent" modelAttribute="messege" method="post">
        <input type="hidden" name="recieverId" value="${theContact.id}"/>
        <input type="hidden" name="time" value="${.now}"/>

        <select name="senderId" size="1">
            <option value="default"> select contact</option>
        <#list senders as sender>
            <option value="${sender.id}">${sender.tel}</option>
        </#list>
        </select>
        <p><textarea name="content" rows="7" cols="33"></textarea></p>
        <input class="codrops-demos" type="submit" value="   Send   "/></br>
    </form>
    </div>


</fieldset>

