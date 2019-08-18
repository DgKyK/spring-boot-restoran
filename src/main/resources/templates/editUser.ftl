<#import "parts/common.ftl" as c>
<#--<#include "parts/security.ftl">-->

<@c.page>
    <div>
        <h2 class="text-center mb-4">${rc.getMessage("message.usereditor")}</h2>
    </div>
    <div class = "mt-2">
        <form action="/admin" method="post">
            <input type="hidden" name="userId" value="${user.id}" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group row">
                <label class ="col-sm-2" for="username">${rc.getMessage("message.login")}</label>
                <div class = "col-sm-5">
                    <input type="text" class="form-control" name="username" value="${user.username}">
                </div>
            </div>
            <div class = "form-group row">
                <label class ="col-sm-2"  for="email">${rc.getMessage("message.email")}</label>
                <div class = "col-sm-5">
                    <input type="text" class="form-control" name="email" value="${user.email}">
                </div>
            </div>
            <#list roles as role>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="role" id="exampleRadios1" value="${role}" <#if user.role == role> checked <#else></#if>>
                    <label class="form-check-label" >
                        ${role}
                    </label>
                </div>
            </#list>
            <button type="submit" class="btn btn-primary">${rc.getMessage("message.edit")}</button>
        </form>
    </div>
</@c.page>