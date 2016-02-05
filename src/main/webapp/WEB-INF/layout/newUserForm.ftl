<form action="/add" modelAttribute="contactForm" method="post">
<#import "spring.ftl" as spring />
<#if spring.status.error>
    <div class="errors">
        There were problems with the data you entered:
        <ul>
            <#list spring.status.errorMessages as error>
                <li>${error}</li>
            </#list>
        </ul>
    </div>
<#else>
    <div class="errors">
        There are no errors.
    </div>
</#if>
    <form action="/add" method="POST">
        <dl>
            <dt>Firstname:</dt>
            <dd><@spring.formInput  "contact.firstName" />
            <dd><@spring.showErrors "<br>" />
            <dt>Lastname:</dt>
            <dd><@spring.formInput "contact.lastName" />
            <dd><@spring.showErrors "<br>" />
            <dt>Phpne:</dt>
            <dd><@spring.formInput "contact.tel" />
            <dd><@spring.showErrors "<br>" />
                <br>
            <dd><input type="submit" value="Create"/>
        </dl>
    </form>
</form>