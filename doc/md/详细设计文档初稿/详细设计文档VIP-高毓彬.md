### 4.1.2 VIP 模块
#### （1）模块描述
VIPbl模块承担的需求参见需求规格说明文档功能需求及相关非功能需求
VIPbl模块的职责及接口参见软件系统体系结构描述文档

#### （2）整体结构
根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性和可修改性，我们会添加接口。在展示层和业务逻辑层之间，我们添加VIPBLService接口。业务逻辑层和数据层之间添加VIPDataService接口。为了隔离业务逻辑职责和逻辑控制职责，我们添加了VIPBLServiceImpl，这样VIPBLServiceImpl会将对新建的业务逻辑处理委托给VIP对象。VIPPO是作为商品和商品分类信息的持久化对象被添加到设计模型中去的。<br/>

![image](http://101.37.19.32:10080/CuteGroup/Cute_Project/blob/master/doc/md/详细设计文档初稿/VIP模块设计.png)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
VIPbl模块的设计如图4.1.2-1 所示

表 4.1.2-1（2） VIPbl模块各个类的职责<br/>

模块 | 职责
---|---
VIPBLServiceImpl | 管理VIPbl各个类的任务
VIP | 完成对客户信息的增删改查任务

#### （3）模块内部类的接口规范
VIPBLServiceImpl 的接口规范如表4.1.2（3）-1所示。<br/>
VIP的接口规范如表4.1.2（3）-2所示。<br/>

表4.1.2（3）-1 VIPBLServiceImpl的接口规范
<table>
<tr>
<td colspan ="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提供的服务（供接口）</td>
</tr>
<tr>
<td rowspan="3">VIPBLServiceImpl.newVIP</td>
<td>语法</td> <td> public String newVIP(String telephone);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择新建客户</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示客户电话和编号</td>
</tr>
<tr>
<td rowspan="3">VIPBLServiceImpl.findVIP</td>
<td>语法</td> <td> public ArrayList<VIPVO> findVIP(String info,String type);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户输入信息模糊查找客户</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示模糊查找后符合要求的客户列表</td>
</tr>
<tr>
<td rowspan="3">VIPBLServiceImpl.deleteVIP</td>
<td>语法</td> <td> public ResultMessage deleteVIP(String id);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择删除客户</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新客户列表</td>
</tr>
<tr>
<td rowspan="3">VIPBLServiceImpl.modifyVIP</td>
<td>语法</td> <td> public ResultMessage modifyVIP(VIPVO vo);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择修改客户信息</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新客户信息</td>
</tr>
<tr>
<td rowspan="3">VIPBLServiceImpl.initAndSaveVIP</td>
<td>语法</td> <td>public ResultMessage initAndSaveVIP(VIPVO vo);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户保存已初始化的客户信息</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新客户信息</td>
</tr>
<tr>
<td rowspan="3">VIPBLServiceImpl.getVIPInfo</td>
<td>语法</td> <td>public ArrayList<VIPVO> getVIPInfo();</td>
</tr>
<tr>
<td>前置条件</td><td>用户选择查看所有客户信息</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示所有客户信息</td>
</tr>
</table>
<table>
<tr>
<td colspan = "2">需要的服务（需接口）</td>
</tr>
<tr>
<td>服务名</td> <td>服务</td>
</tr>
<tr>
<td>VIP.newVIP(String telephone)</td> <td>新建会员</td>
</tr>
<tr>
<td>VIP.findVIP(String info)</td> <td>模糊查找会员</td>
</tr>
<tr>
<td>VIP.deleteVIP(String id)</td> 
<td>删除会员</td>
</tr>
<tr>
<td>VIP.modifyVIP(VIPVO vo)</td> 
<td>修改会员信息</td>
</tr>
<tr>
<td>VIP.initAndSaveVIP(VIPVO vo)</td> 
<td>初始化并保存客户信息</td>
</tr>
<tr>
<td>VIP.getVIPInfo()</td> 
<td>获取所有客户信息</td>
</tr>
</table>

表4.1.2（3）-2 VIP 的接口规范
<table>
<tr>
<td colspan ="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提供的服务（供接口）</td>
</tr>
<tr>
<td rowspan="3">VIP.newGoods</td>
<td>语法</td> <td> public String newVIP(String telephone);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择新建客户</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示客户电话和编号</td>
</tr>
<tr>
<td rowspan="3">VIP.findVIP</td>
<td>语法</td> <td> public ArrayList<VIPVO> findVIP(String info,String type);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户输入信息模糊查找客户</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示模糊查找后符合要求的客户列表</td>
</tr>
<tr>
<td rowspan="3">VIP.deleteVIP</td>
<td>语法</td> <td> public ResultMessage deleteVIP(String id);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择删除客户</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新客户列表</td>
</tr>
<tr>
<td rowspan="3">VIP.modifyVIP</td>
<td>语法</td> <td> public ResultMessage modifyVIP(VIPVO vo);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择修改客户信息</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新客户信息</td>
</tr>
<tr>
<td rowspan="3">VIP.initAndSaveVIP</td>
<td>语法</td> <td>public ResultMessage initAndSaveVIP(VIPVO vo);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户保存已初始化的客户信息</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新客户信息</td>
</tr>
<tr>
<td rowspan="3">VIP.getVIPInfo</td>
<td>语法</td> <td>public ArrayList<VIPVO> getVIPInfo();</td>
</tr>
<tr>
<td>前置条件</td><td>用户选择查看所有客户信息</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示所有客户信息</td>
</tr>
</table>
<table>
<tr>
<td colspan = "2">需要的服务（需接口）</td>
</tr>
<tr>
<td>服务名</td> <td>服务</td>
</tr>
<tr>
<td>VIPDataService.newVIP(String telephone)</td> <td>新建会员</td>
</tr>
<tr>
<td>VIPDataService.findVIP(String info)</td> <td>模糊查找会员</td>
</tr>
<tr>
<td>VIPDataService.deleteVIP(String id)</td> 
<td>删除会员</td>
</tr>
<tr>
<td>VIPDataService.modifyVIP(VIPVO vo)</td> 
<td>修改会员信息</td>
</tr>
<tr>
<td>VIPDataService.initAndSaveVIP(VIPVO vo)</td> 
<td>初始化并保存客户信息</td>
</tr>
<tr>
<td>VIPDataService.getVIPInfo()</td> 
<td>获取所有客户信息</td>
</tr>
</table>

#### (4)业务逻辑层的动态模型
图4.1.2（4）-1表明了进销存系统中，当用户选择初始化并保存客户信息时，客户业务逻辑处理的相关对象之间的协作。<br/>
![image](http://101.37.19.32:10080/CuteGroup/Cute_Project/blob/master/doc/md/详细设计文档初稿/初始化并保存客户信息系统顺序图.png)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.2（4）-1初始化并保存客户信息**<br/>

图4.1.2（4）-2所示的状态图描述VIP对象的生存期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。随着initAndSaveVIP/newVIP/VIP/modifyVIP方法被VIPBLServiceImpl调用，VIP进入handleData状态；之后通过获取VIPPO进入Present状态；通过获取ResultMessage进入Complete状态<br/>
![image](http://101.37.19.32:10080/CuteGroup/Cute_Project/blob/master/doc/md/详细设计文档初稿/VIP对象状态图.png)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.2（4）-2 VIP对象状态图**<br/>

