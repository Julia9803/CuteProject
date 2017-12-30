# 详细设计文档  表单  王瑞华 #
## 初稿 ##
###4.1.4 List模块
####(1)模块描述
listbl模块承担的需求参见需求规格说明文档功能需求及相关非功能需求  
listbl模块的职责及接口参见软件系统体系结构描述文档  

####(2)整体结构
  
根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性和可修改性，我们会添加接口。在展示层和业务逻辑层之间，我们添加ListBLService接口。业务逻辑层和数据层之间添加ListDataService接口。为了隔离业务逻辑职责和逻辑控制职责，我们添加了ListBLServiceImpl，这样ListBLServiceImpl会将对新建的业务逻辑处理委托给accountList,presidentList,saleList,storeList,otherList对象。ListPO是作为表单（目录）类信息的持久化对象被添加到设计模型中去的。<br/>

Listbl 模块的详细设计类图如图4.1.4-1所示  
  
**图4.1.4-1**  
![](https://i.imgur.com/4bCC0hs.png)
  
  
表4.1.4(2)  listbl 模块各个类的职责  
  
|模块|职责|
|-------
|ListblserviceImpl|负责实现Listblservice接口所需要的表单查看、表单审批、表单导出功能，并将具体任务分派给模块内其他各类
|accountList|负责实现财务类单据（付款单，收款单，现金费用单）的查看、审批、导出功能
|presentList|负责实现库存赠送单的查看、审批、导出功能
|salesList|负责实现销售单、进货单、销售退货单、进货退货单的查看、审批、导出功能
|storeList|负责实现库存类单据（报损单、报溢单、报警单）的查看、审批、导出功能
|otherList|负责实现销售明细表、经营情况表的查看、审批、导出功能。
|message|负责实现表单审批后的消息发送功能。

####（3）模块内部类的接口规范  
  
表4.1.4（3）-1a   listblserviceImpl类的供接口  

|服务编号|项目|内容|
|---------
|listblserviceImpl.approve|语法| public ResultMessage approve (ListType type，String id)
|  |前置条件|用户选择审批某个表单
|  |后置条件|系统更新该表单的审批信息
|listblserviceImpl.openList|语法|public List<ListVO> openList(ListType type)  
|  |前置条件|用户选择查看某类表单
|  |后置条件|系统显示该类表单的列表
|listblserviceImpl.opensingleList|语法|public ListVO openSingleList(ListType type)
|  |前置条件|用户选择查看销售明细表或经营情况表
|  |后置条件|系统显示该表单
|listblserviceImpl.toExcelFile|语法|public String (ListType type,String id)
|  |前置条件|用户选择导出表单
|  |后置条件|系统显示导出信息（成功导出的文件地址或导出失败）

表4.1.4（3）-1b   listblserviceImpl类的需接口   
 
|需要的服务名|需要的服务内容
|-------
|accountList.approve|审批财务类单据
|accountList.openList|打开财务类单据列表
|accountList.toEcelFile|导出财务类单据
|storeList.approve|审批库存类单据
|storeList.openList|打开库存类单据列表
|storeList.toEcelFile|导出库存类单据
|salesList.approve|审批销售、进货类单据
|salesList.openList|打开销售、进货单据列表
|salesList.toEcelFile|导出销售、进货类单据
|presentList.approve|审批赠送类单据
|presentList.openList|打开赠送类单据列表
|presentList.toEcelFile|导出赠送类单据
|otherList.openList|打开其他类单据列表
|otherList.toEcelFile|导出其他类单据

**由于对各类经营历程表（包括销售、赠送、库存、账户）的查看、审批、导出的具体操作非常类似，下面我们只选取财务类单据来代表这4类单据的查看、审批、导出流程。**
  
表4.1.4（3）-2a accountList类的供接口   
 
|服务编号|项目|内容|
|---------
|accountList.approve|语法| public ResultMessage approve (ListType type，String id)
|  |前置条件|用户选择审批某个账户类表单
|  |后置条件|系统更新该表单的审批信息
|accountList.openList|语法|public List<ListVO> openList(ListType type)  
|  |前置条件|用户选择查看账户类表单中的某类具体表单
|  |后置条件|系统显示该类表单的列表
|accountList.toExcelFile|语法|public String toExcelFile (ListType type,ListVO vo)
|  |前置条件|用户选择导出表单
|  |后置条件|系统显示导出信息（成功导出的文件地址或导出失败）

  
表4.1.4（3）-2b accountList类的需接口  

|需要的服务名|需要的服务内容|
|------
|account.accountlist.openCommitted|获取已提交的账户类单据数据
|account.accountlist.save|保存更改后的单据信息
|user.message.save|向财务人员发送消息

  
表4.1.4（3）-3a otherList 类的供接口  
  

|服务编号|项目|内容|
|---------
|otherList.openSingleList|语法| public ResultMessage openSingleList (ListType type，String id)
|  |前置条件|用户选择审批某个账户类表单
|  |后置条件|系统更新该表单的审批信息
|otherList.toExcelFile|语法|public String (ListType type,String id)
|  |前置条件|用户选择导出表单
|  |后置条件|系统显示导出信息（成功导出的文件地址或导出失败）
|otherList.modify|语法|public ListRM modify (ListType type , ListVO vo)
|  |前置条件|该单据已经在数据库中被新建并初始化
|  |后置条件|当发生销售等行为，系统自动对数据库中的单据数据进行修改
  
  
表4.1.4（3）-3b otherList 类的需接口
  
|需要的服务名|需要的服务内容|
|----------
|listdataservice.get|获取销售明细表、经营情况表的信息
|listdataservice.save|保存销售明细表、经营情况表的信息  
  
####(4)业务逻辑层的动态模型
  
表单包中查看、审批、导出文件操作中，表示相关对象协作的顺序图由图4.1.4（4）-1表示

图4.1.4（4）-1
![](https://i.imgur.com/o4dG058.png)

表单包中各个表单对象的状态图在图4.1.4（4）-2中给出，在图中，对象被初始化后根据得到的信息和命令进入不同的状态，包括查看状态、审批状态、导出状态，在结束单次操作后对象生命期结束。

图4.1.4（4）-2  
![](https://i.imgur.com/RkujUWw.png)  
  
  
####（5）业务逻辑层的设计原理  
  利用委托式控制风格，每个界面需要访问的业务逻辑由各自的控制器委托给不同领域的对象。并通过向外提供接口避免了循环依赖的问题。其他设计原理从略。