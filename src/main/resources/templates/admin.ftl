<#import "parts/common.ftl" as c>
<#import  "parts/login.ftl" as l>
<@c.page>
    <h2>${rc.getMessage("message.helloadmin")}</h2>
    <p>
        <a class="btn btn-primary"
           data-toggle="collapse"
           href="#multiCollapseExample1"
           role="button" aria-expanded="false" aria-controls="multiCollapseExample1">${rc.getMessage("message.userslist")}</a>
    </p>
    <div class="row">
        <div class="col">
            <div class="collapse multi-collapse" id="multiCollapseExample1">
                <div class="list-group col-sm-5">
                    <#list users as user>
                        <a href="/admin/admin/${user.id}" class="list-group-item list-group-item-action">${user.username}</a>
                    </#list>
                </div>
            </div>
        </div>
    </div>
</@c.page>