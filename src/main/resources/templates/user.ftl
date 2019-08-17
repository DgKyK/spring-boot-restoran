<#import "parts/common.ftl" as c>
    <#include "parts/security.ftl">
<@c.page>
    <div>
        <h2> ${rc.getMessage("message.hello")} ${name} !!!</h2>
    </div>
    <div >
        <Strong>${rc.getMessage("message.choosedishes")}</Strong>
    </div>
    <form action="/user/order" method="post" name="test">
        ///////////////////
        <div class="form-check">

            <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
            <label class="form-check-label" for="defaultCheck1">
                Default checkbox
            </label>
        </div>
        //////////////////////
        <div>

        <select class="custom-select col-sm-5 mt-2" name="chosenDishes">
            <#list dishes as dish>
                <option>
                <div>
                    <b>${dish.id}</b>
                    <strong>|</strong>
                    <span>${dish.name}</span>
                    <strong>|</strong>
                    <i>${dish.cost}$</i>
                </div>
            <#else>
                <strong>${rc.getMessage("message.nodishes")}</strong>
                </option>
            </#list>
        </select>
    </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary mt-2">${rc.getMessage("message.createorder")}</button>
    </form>
</@c.page>