<#import "parts/common.ftl" as c>
    <#include "parts/security.ftl">
<@c.page>
    <div class = "mt-10">
        <h2 class="text-center">${rc.getMessage("message.welcome")}</h2>
    </div>
    <h3 class="text-center">${rc.getMessage("message.continue")}</h3>
    <h3 class="text-center"><a href="${springMacroRequestContext.getContextPath()}/login">${rc.getMessage("message.signin")}</a> ${rc.getMessage("message.or")} <a href="${springMacroRequestContext.getContextPath()}/registration">${rc.getMessage("message.register")}</a></h3>

</@c.page>