


<#include "commons/top.ftl" encoding="utf-8" parse="true" >
<form id="from1" name="from1" action="login">

    <table align="center" border="0">
        <tr>
            <td colspan="2">
                <#if errer?exists>
                    ${errer}
                    <#else>
                        输入用户名和密码：
                </#if>

                <br />
                &nbsp;
            </td>
        </tr>
        <tr>

            <td>
                用户名：<input type="text" name="username" id="username">
            </td>
        </tr>
        <tr>

            <td>

                &nbsp;密码：<input type="text" name="password" id="password">

            </td>
        </tr>
        <tr>

            <td>
                <input type="image" border="0" src="../images/button_submit.gif" />
            </td>
            <td>
                <a href="catall"><img border="0"
                                                  src="../images/button_register_now.gif" />
                </a>
            </td>
        </tr>

    </table>
</form>
<center>

</center>
<#include "commons/bottom.ftl" encoding="utf-8" parse="true">
