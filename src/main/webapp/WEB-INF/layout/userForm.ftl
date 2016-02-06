
<fieldset class="main">
    <legend>Add Contact</legend>

    <div id="addUser">
        <div style="float: left">
            <form action="/add" modelAttribute="contactForm" method="post">

                Firstname:</br><@spring.formInput 'contact.firstName' 'id="firstName" placeholder="firstName"' /></br>
                Lastname:</br> <@spring.formInput 'contact.lastName' 'id="lastName" placeholder="lastName"' /></br>
                Phone:</br> <@spring.formInput 'contact.tel' 'id="tel" placeholder="tel"' /></br>
                <input class="codrops-demos" type="submit" value="   Save   "/></br>
            </form>
        </div>

        <div style="float: right">
        <#if errors??>
            <#list errors as error>

                <h4 class="main"> ${error.getDefaultMessage()}</h4>
            </#list>
            <p><@spring.showErrors "<br>", "color:red" /></p>
        </#if>
        </div>

    </div>
</fieldset>

