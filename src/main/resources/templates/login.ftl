<#import "parts/common.ftl" as c>
<#import  "parts/login.ftl" as l>
<@c.page>
    <h3>${rc.getMessage("message.loginpage")}</h3>
    <#if error>
        <div class="alert alert-danger col-sm-3" role="alert">
            ${rc.getMessage("message.invalidpassword")}
        </div>
    </#if>
    <#if logout>
        <div class="alert alert-success col-sm-3" role="alert">
            ${rc.getMessage("message.beenlogedout")}
        </div>
    </#if>
    <div>
        <@l.login "/login"/>
    </div>

</@c.page>