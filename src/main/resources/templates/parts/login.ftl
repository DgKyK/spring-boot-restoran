<#macro login path>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class ="col-sm-2" for="username">${rc.getMessage("message.login")}</label>
            <div class = "col-sm-5">
                <input type="text" class="form-control" name="username" placeholder="${rc.getMessage("message.enterlogin")}">
            </div>
        </div>
        <div class = "form-group row">
            <label class ="col-sm-2"  for="password">${rc.getMessage("message.password")}</label>
            <div class = "col-sm-5">
                <input type="password" class="form-control" name="password" placeholder="${rc.getMessage("message.password")}">
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">${rc.getMessage("message.signin")}</button>
        <a href = "/registration"><ins>${rc.getMessage("message.registration")}</ins></a>
    </form>
</#macro>

<#macro logout >
    <form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary">${rc.getMessage("message.loguot")}</button>
</form>
</#macro>