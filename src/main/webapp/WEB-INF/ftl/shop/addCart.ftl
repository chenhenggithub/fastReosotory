<#include "commons/top.ftl" encoding="utf-8" parse="true">
<table border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr>
        <td valign="top" width="20%" align="left">
            <table align="left" bgcolor="#008800" border="0" cellspacing="2"
                   cellpadding="2">
                <tr>
                    <td bgcolor="#FFFF88">
                        <a href="main.xhtml"><b><font color="BLACK" size="2">&lt;&lt; 主菜单</font>
                        </b></a>
                    </td>
                </tr>
            </table>
        </td>
        <td valign="top" align="center">
            <h2 align="center">

            </h2>
            <form name="form1" method="post"
                  action="${ppath}/category/updateCart">

                <table align="center" bgcolor="#008800" border="0" cellspacing="2"
                       cellpadding="5" >
                    <tr bgcolor="#cccccc">
                        <td>
                            产品序号
                        </td>
                        <td>
                            宠物序号
                        </td>
                        <td>
                            是否有库存
                        </td>
                        <td>
                            <b>宠物描述</b>
                        </td>
                        <td >
                            数量
                        </td>
                        <td>
                            宠物单价
                        </td>
                        <td>
                            操作
                        </td>
                        <td>
                            总价
                        </td>
                    </tr>



	            <#assign sum=0/>

				<#list cartlist as cart>
                    <tr bgcolor="#FFFF88">
                        <td>
                            <b>
                                <#assign orderid=cart.orderid/>

                                <a href=""><s:property value="#cart.itemid"/>${cart.item.product.productid}</a>

                            </b>
                        </td>
                        <td>
                            <input type="hidden" name="orderids" value="${cart.orderid}">
						${cart.item.itemid}
                            <input type="hidden" name="itemids" value="${cart.item.itemid}">
                        </td>
                        <td>

                            是
                        </td>
                        <td align="center">

						${cart.item.attr1}
                        </td>
                        <td>

                            <input type="number" name="qtys" value="${cart.quantity}">

                        </td>
                        <td align="right">
						${cart.item.listprice}
                            <br/>
                        </td>
                        <td align="right">
                            <a href="${ppath}/category/deleteCart/orderid/${cart.orderid}/itemid/${cart.item.itemid}"><img border="0"
                                                                                                                           src="${ppath}/images/button_remove.gif" />
                            </a>

                        </td>
                        <td>
							<#assign s=cart.item.listprice*cart.quantity/>
							${s}
							<#assign sum=s+sum/>
                        </td>
                    </tr>


				</#list>
                    <tr bgcolor="#FFFF88">
                        <td colspan="7" align="right">
                            <b>
                            </b>
							总计:${sum}
                        </td>
                        <td>

                            <input border=0 type="image" src="${ppath}/images/button_update_cart.gif" />

                        </td>
                    </tr>
                </table>
                <center>


                </center>
            </form>


            <br />
            <center>
                <a href="${ppath}/category/check/orderid/${orderid}/zqty/${sum}"><img border="0"
                                src="${ppath}/images/button_checkout.gif" />
                </a>
            </center>


        </td>


        <td valign="top" width="20%" align="right">
		<#include "shop/favItem.ftl" encoding="utf-8" parse="true">
        </td>

    </tr>
</table>

<br>
<#include "commons/banner.ftl" encoding="utf-8" parse="true">
<#include "commons/bottom.ftl" encoding="utf-8" parse="true">
