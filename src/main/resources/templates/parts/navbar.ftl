<#include "security.ftl">
<#include "login.ftl">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" <#if isUser || isAdmin>href="#"<#else>href="/"</#if>>FTS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if isActiveAccount>
                <li class="nav-item active">
                    <a class="nav-link" <#if isAdmin>href="/admin/admin" <#elseif isUser>href="/user/user"</#if>>${rc.getMessage("message.home")}<span class="sr-only">(current)</span></a>
                </li>
            </#if>
            <#if isUser>
                <li class="nav-item active">
                    <a class="nav-link" href="/user/myorders">${rc.getMessage("message.myorders")}<span class="sr-only">(current)</span></a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item active">
                    <a class="nav-link" href="/admin/allorders">${rc.getMessage("message.userorders")}<span class="sr-only">(current)</span></a>
                </li>
            </#if>
        </ul>
    </div>
    <div class = "mr-2">
        <select id="locales" class="form-control" style="width: 125px;">
            <option value="">${rc.getMessage("message.language")}</option>
            <option value="US">EN</option>
            <option value="UA">UA</option>
        </select>
    </div>
    <div class = "navbar-text mr-2">${name}</div>
    <#if isUser || isAdmin>
        <@logout />
    </#if>
</nav>