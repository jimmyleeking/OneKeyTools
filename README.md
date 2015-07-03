#OneKeyTool

帮助开发者能够更好地进行开发。

目前完成功能：

1. 一键开启远程adb调试


## 一键开启远程adb调试

针对linux内核层面，执行以下该指令:

<pre>
<code>
//获取root权限
su
//更改adb调试模式为tcp,并指定5555端口
setprop service.adb.tcp.port 5555
//停止adbd服务器
stop adbd
//启动adbd服务器
start adbd
</code>
</pre>


###java层面调用shell

java提供了调用系统层级的命令，通过:
<pre>
<code>
Process su = Runtime.getRuntime().exec("指令参数");
</code>
</pre>