<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Order #</th>
                        <th scope="col">User ID</th>
                        <th scope="col">Dishes</th>
                        <th scope="col">Status</th>
                        <th scope="col">Cost</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list allOrders as ao>
                        <tr>
                            <th scope="row">${ao.id}</th>
                            <td>${ao.user_id}</td>
                            <td>
                                <#list ao.dishes as d>
                                    ${d.name}<br>
                                </#list>
                            </td>
                            <td>${ao.status}</td>
                            <td>${ao.sumOfOrder}</td>
                            <td>
                                <#if ao.status = "NotApproved">
                                <form action="/admin/approveorder" method="post">
                                    <input type="hidden" name="orderId" value="${ao.id}" />
                                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                    <button type="submit" class="btn btn-success">Approve</button>
                                </form>
                                </#if>
                                <form action="/admin/deleteorder" method="post">
                                    <input type="hidden" name="orderId" value="${ao.id}" />
                                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                    <button type="submit" class="btn btn-danger">Decline</button>
                                </form>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@c.page>