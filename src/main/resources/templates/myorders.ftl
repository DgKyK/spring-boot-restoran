<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Dishes</th>
                        <th scope="col">Status</th>
                        <th scope="col">Cost</th>
                        <th scope="col">Payment</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list approvedOrders as ao>
                    <tr>
                        <th scope="row">${ao.id}</th>
                        <td>
                            <#list ao.dishes as d>
                                ${d.name}<br>
                            </#list>
                        </td>
                        <td>${ao.status}</td>
                        <td>${ao.sumOfOrder}</td>
                        <td>
                            <form action="/user/myorders" method="post">
                            <input type="hidden" name="orderId" value="${ao.id}" />
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <button type="submit" class="btn btn-success">Pay</button>
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