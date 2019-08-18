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
        <div>
            <div>
                <h2>Meat</h2>
                <select class="custom-select col-sm-5 mt-2" name="chosenMeat">
                    <#list meat as m>
                        <option>
                        <div>
                            <b>${m.id}</b>
                            <strong>|</strong>
                            <span>${m.name}</span>
                            <strong>|</strong>
                            <i>${m.cost}$</i>
                        </div>
                    <#else>
                        <strong>${rc.getMessage("message.nodishes")}</strong>
                        </option>
                    </#list>
                </select>
            </div>
            <div>
                <h2>Salad</h2>
                <select class="custom-select col-sm-5 mt-2" name="chosenSalad">
                    <#list salad as s>
                        <option>
                        <div>
                            <b>${s.id}</b>
                            <strong>|</strong>
                            <span>${s.name}</span>
                            <strong>|</strong>
                            <i>${s.cost}$</i>
                        </div>
                    <#else>
                        <strong>${rc.getMessage("message.nodishes")}</strong>
                        </option>
                    </#list>
                </select>
            </div>
            <div>
                <h2>Deserts</h2>
                <select class="custom-select col-sm-5 mt-2" name="chosenDesert">
                    <#list deserts as d>
                        <option>
                        <div>
                            <b>${d.id}</b>
                            <strong>|</strong>
                            <span>${d.name}</span>
                            <strong>|</strong>
                            <i>${d.cost}$</i>
                        </div>
                    <#else>
                        <strong>${rc.getMessage("message.nodishes")}</strong>
                        </option>
                    </#list>
                </select>
            </div>
            <div>
                <h2>Drinks</h2>
                <select class="custom-select col-sm-5 mt-2" name="chosenDrinks">
                    <#list drinks as dr>
                        <option>
                        <div>
                            <b>${dr.id}</b>
                            <strong>|</strong>
                            <span>${dr.name}</span>
                            <strong>|</strong>
                            <i>${dr.cost}$</i>
                        </div>
                    <#else>
                        <strong>${rc.getMessage("message.nodishes")}</strong>
                        </option>
                    </#list>
                </select>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary mt-2">${rc.getMessage("message.createorder")}</button>
    </form>
</@c.page>