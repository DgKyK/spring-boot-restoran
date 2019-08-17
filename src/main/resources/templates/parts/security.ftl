<#assign
sessionExist = Session.SPRING_SECURITY_CONTEXT??
>
<#if sessionExist>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    isUser = user.isUser()
    isActiveAccount = user.isAccountStatus()
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    isUser = false
    isActiveAccount = false
    >
</#if>