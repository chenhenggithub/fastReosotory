

<#include "commons/top.ftl" encoding="utf-8" parse="true">


<table align="left" bgcolor="#008800" border="0" cellspacing="2"
       cellpadding="2">
    <tr>
        <td bgcolor="#FFFF88">
            <a href="main.xhtml"><b><font color="BLACK" size="2">&lt;&lt; 主菜单</font>
            </b></a>
        </td>
    </tr>
</table>

<p>
<center>
    <h2>

    </h2>
</center>
<table align="center" bgcolor="#008800" border="0" cellspacing="2"
       cellpadding="3">
    <tr bgcolor="#CCCCCC">
        <td>
            产品编号
        </td>
        <td>
			产品名称
        </td>
        <td>
            产品描述
        </td>
    </tr>

<#list plist as p>
    <tr bgcolor="#FFFF88">

        <td>
            <b><a href="${ppath}/category/item/productid/${p.productid}">
			${p.productid}
            </a>
            </b>
        </td>
        <td>
			${p.name}
        </td>
		<td>
			${p.descn}
		</td>
    </tr>
</#list>





    <tr>
        <td bgcolor="#FFFFFF" colspan="2">


        </td>
    </tr>
</table>
<#include "commons/bottom.ftl" encoding="utf-8" parse="true">
