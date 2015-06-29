# community-server
webapp for community

#used framework
spring
spring mvc
mybatis
spring security
################

#server
tomcat
################

#database
mysql

# 诚联安全控件的使用方法

有两个文件夹：无认证版（U盘使用）和有认证版（大读卡器使用）

U盘只能读取身份证。我们用U盘来进行硬件登陆；大读卡器可以读取市民卡余额和信息。

##硬件驱动

只有一份，任意安装一个。

##IE插件安装：

首先安装有认证版的《2_读太仓市民卡、图书馆读者证（S50卡）》文件夹下的插件。使用管理员权限安装。如果要卸载，使用 regsvr32 /u %SystemRoot%\SysWOW64\ktplugin.ocx 命令。

然后安装无认证版的《2_读第二代身份证》文件夹下的插件。此插件和有认证版的插件冲突，不能同时安装。

##使用

只支持IE。使用U盘之后必须重启IE才能使用大读卡器。反之亦然。
