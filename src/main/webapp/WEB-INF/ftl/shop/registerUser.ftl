<#assign spring=JspTaglibs["http://www.springframework.org/tags"]/>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<#include "commons/top.ftl" encoding="utf-8" parse="true">

<br/>

<@form.form id="form2" name="form2" action="register" commandName="account">
	<TABLE cellpadding=10 cellspacing=0 align=center border=1 width="400"
		bgcolor=#dddddd>
		<TR>
			<TD>
				<FONT color=darkgreen>
					<H3>
						基本信息
					</H3>
				</FONT>
				<TABLE border=0  bgcolor=#FFFF88  width="100%">
					<TR bgcolor=#FFFF88>
						<TD>
						 	用户名：<input  type="text" name="username" id="username"/>
							<@form.errors path="username"/>
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>

						<TD>

							密&nbsp;码：<@form.input  path="password" id="password"/>
							<@form.errors path="password"/>
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>

                        <TD>
                            校密码：<@form.input  path="repassword" id="repassword"/>
							<@form.errors path="repassword"/>
                        </TD>
					</TR>
				</TABLE>





				<FONT color=darkgreen>
					<H3>
						详细信息
					</H3>
				</FONT>

				<TABLE bgcolor="#FFFF88" border=0
					bgcolor=#FFFF88 width="100%">
					<TR bgcolor=#FFFF88>

						<TD>
							 邮&nbsp;&nbsp;箱：<@form.input path="email" id="email"/>
							<@form.errors path="email"/>
						</TD>
					</TR>

					<TR bgcolor=#FFFF88>

						<TD>
							 真实姓名：<@form.input path="xm" id="xm"/>
							<@form.errors path="xm"/>
						</TD>
					</TR>

					<TR bgcolor=#FFFF88>

						<TD>

							地&nbsp;&nbsp;址：<@form.input path="address" id="address"/>
							<@form.errors path="address"/>
						</TD>
					</TR>


				</TABLE>


				<FONT color=darkgreen>
					<H3>
						个人设置
					</H3>
				</FONT>

				<TABLE bgcolor="#FFFF88" border=0 cellpadding=3 cellspacing=1 width="100%">
					<TR bgcolor=#FFFF88>

						<TD>
							语言：
							<select id="langpref" name="profile.langpref">
								<option id="eng" name="eng" value="English">
									英语
								</option>
								<option id="cha" name="cha" value="Chianese">
									汉语
								</option>
							</select>
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>

						<TD>
							喜爱宠物：
							<select id="catid" name="profile.catid">
								<#list catlist as a>
								<option value="${a.catid}">

									${a.name}
								</option>
								</#list>
							</select>
						</TD>
					</TR>

				</TABLE>
	</TABLE>

	<BR>
	<CENTER>
		<input border=0 type="image" src=".${ppath}/images/button_submit.gif" />
	</CENTER>
</@form.form>
<#include "commons/bottom.ftl" encoding="utf-8" parse="true">
