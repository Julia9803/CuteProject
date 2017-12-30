### 4.1.2 sale 模块
#### （1）模块描述
salebl模块承担的需求参见需求规格说明文档功能需求及相关非功能需求</br>
salebl模块的职责及接口参见软件系统体系结构描述文档

#### （2）整体结构
根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性和可修改性，我们会添加接口。在展示层和业务逻辑层之间，我们添加SaleBLService接口。业务逻辑层和数据层之间添加SaleDataService接口。为了隔离业务逻辑职责和逻辑控制职责，我们添加了SaleBLServiceImpl，这样SaleBLServiceImpl会将对销售类单据的业务逻辑处理委托给Sale对象。SaleListPO,SaleBackListItem,StockListPO,StockLostListPO是作为销售类单据的持久化对象,SaleListPO,SaleBackListItem,StockListPO,StockLostListPO是作为销售类单据中商品的持久化对象被添加到设计模型中去的。<br/>

salebl模块的设计如图4.1.2-1 所示

![image](http://101.37.19.32:10080/CuteGroup/Cute_Project/raw/master/doc/img/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E7%9B%B8%E5%85%B3/salebl%E6%A8%A1%E5%9D%97%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%9E%8B.png)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图 4.1.2（1）-1 salebl模块设计模型**<br/>

表 4.1.2-1（2） salebl模块各个类的职责<br/>

模块 | 职责
---|---
SaleBLServiceImpl | 管理salebl各个类的任务
Sale | 单据的领域模型对象，拥有一次销售类任务所持有的各项信息，可以帮助完成销售类界面所需要的服务
SaleItem | 单据中的商品的领域模型对象，拥有单据的商品信息，可以帮助完成生成单据所需要的服务
Bill| 单据账单的领域模型对象，帮忙完成生成单据时的计算原价、获取促销策略、计算总价所需要的服务

#### （3）模块内部类的接口规范
SaleBLServiceImpl 的接口规范如表4.1.2（3）-1所示。<br/>
Sale的接口规范如表4.1.2（3）-2所示。<br/>
SaleItem的接口规范如表4.1.2（3）-3所示。<br/>
Bill的接口规范如表4.1.2（3）-4所示。<br/>

表4.1.2（3）-1 SaleBLServiceImpl的接口规范
<table>
<tr>
<td colspan ="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提供的服务（供接口）</td>
</tr>
<tr>
<td rowspan="3">SaleBLServiceImpl.newList</td>
<td>语法</td> <td> public String newList(ListType type);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择新建单据</td>
</tr>
<tr>
<td>后置条件</td><td>调用Sale领域对象的newList方法</td>
</tr>
<tr>
<td rowspan="3">SaleBLServiceImpl.openDraft</td>
<td>语法</td> <td> public List<ListVO> openDraft(ListType type);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户输入单据类型</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示符合要求的草稿单列表</td>
</tr>
<tr>
<td rowspan="3">SaleBLServiceImpl.save</td>
<td>语法</td> <td> public ResultMessage save(ListType type,ListVO vo);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择保存单据</td>
</tr>
<tr>
<td>后置条件</td><td>调用Sale领域对象的save方法</td>
</tr>
<tr>
<td rowspan="3">SaleBLServiceImpl.openSpecialDraft</td>
<td>语法</td> <td> public ListVO openSpecialDraft(String id);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择打开某个草稿单</td>
</tr>
<tr>
<td>后置条件</td><td>调用Sale领域对象的openSpecialDraft方法</td>
</tr>
<tr>
<td rowspan="3">SaleBLServiceImpl.delete</td>
<td>语法</td> <td>public ResultMessage delete(ListType type,String id);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择删除某个单据</td>
</tr>
<tr>
<td>后置条件</td><td>调用Sale领域对象的delete方法</td>
</tr>
<tr>

<td rowspan="3">SaleBLServiceImpl.commit</td>
<td>语法</td> <td>public ResultMessage commit(ListType type,String id);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择提交某单据</td>
</tr>
<tr>
<td>后置条件</td><td>调用Sale领域对象的commit方法</td>
</tr>
<tr>
<td rowspan="3">SaleBLServiceImpl.openConmitted</td>
<td>语法</td> <td>public List<ListVO> openCommitted(ListType type);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择打开已提交单列表</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示已提交单列表</td>
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
<td>Sale.newList(ListType type)</td> <td>新建单据</td>
</tr>
<tr>
<td>Sale.openSpecialDraft(String id)</td> <td>返回单一表单</td>
</tr>
<tr>
<td>Sale.save(ListType type, ListVO vo)</td> 
<td>保存单据</td>
</tr>
<tr>
<td>Sale.delete(ListType type, String id)</td> 
<td>删除单据</td>
</tr>
<tr>
<td>Sale.commit(ListType type, ListVO vo)</td> 
<td>提交单据</td>
<tr>
<td>SaleDataService.openDraft(ListType type)</td> 
<td>打开草稿单列表</td>
</tr>
<tr>
<td>SaleDataService.openCommitted(ListType type)</td> 
<td>打开已提交单列表</td>

</tr>
</tr>
</table>

表4.1.2（3）-2 Sale 的接口规范
<table>
<tr>
<td colspan ="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提供的服务（供接口）</td>
</tr>
<tr>
<td rowspan="3">Sale.newList</td>
<td>语法</td> <td> public String newList(ListType type);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择新建单据</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示编号</td>
</tr>
<tr>
<td rowspan="3">Sale.openSpecialDraft</td>
<td>语法</td> <td> public ListVO openSpecialDraft(String id);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择打开草稿单</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示草稿单</td>
</tr>
<tr>
<td rowspan="3">Sale.save</td>
<td>语法</td> <td> public ResultMessage save(ListType type, ListVO vo);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择保存单据</td>
</tr>
<tr>
<td>后置条件</td><td>持久化更新Sale和SaleItem</td>
</tr>
<tr>
<td rowspan="3">Sale.delete</td>
<td>语法</td> <td> public ResultMessage delete(ListTpe type, String id);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择删除单据</td>
</tr>
<tr>
<td>后置条件</td><td>持久化更新Sale和SaleItem</td>
</tr>
<tr>
<td rowspan="3">Sale.commit</td>
<td>语法</td> <td> public ResultMessage commit(ListTpe type, String id);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择提交单据</td>
</tr>
<tr>
<td>后置条件</td><td>持久化更新Sale和SaleItem</td>
</tr>
<tr>
<td rowspan="3">Sale.modifyGoodsQuantity</td>
<td>语法</td> <td> public ResultMessage modifyGoodsQuantity(String goodsid, int quantity);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户修改商品数量</td>
</tr>
<tr>
<td>后置条件</td><td>调用SaleItem领域对象的modifyQuantity方法</td>
</tr>
<tr>
<td rowspan="3">Sale.getBill</td>
<td>语法</td> <td> public Bill getBill(DateUtil date, List<SaleItem>, String memberId, int sum);</td>
</tr>
<tr>
<td>前置条件</td> <td>已创建一个Bill领域对象</td>
</tr>
<tr>
<td>后置条件</td><td>返回Bill成员变量</td>
</tr>
</table>
<table>
<td colspan = "2">需要的服务（需接口）</td>
</tr>
<tr>
<td>服务名</td> <td>服务</td>
</tr>
<tr>
<td>SaleItem.modifyQuantity</td> 
<td>更改商品数量</td>
</tr>
<tr>
<td>Bill.refresh</td> 
<td>更新获得账单</td>
</tr>
<tr>
<td>SaleDataService.newList(ListType type)</td> <td>新建表单</td>
</tr>
<tr>
<td>SaleDataService.openSpecialDraft(String id)</td> <td>打开草稿单</td>
</tr>
<tr>
<td>SaleDataService.save(ListType type, ListVO vo)</td> 
<td>保存草稿单</td>
</tr>
<tr>
<td>SaleDataService.delete(ListType type)</td> 
<td>修改商品信息</td>
</tr>
<tr>
<td>SaleDataService.commit(ListType type, ListVO vo)</td> 
<td>提交单据</td>
</tr>
</table>

表 4.1.2(3)-3 SaleItem 的接口规范
<table>
<tr>
<td colspan ="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提供的服务（供接口）</td>
</tr>
<tr>
<tr>
<td rowspan="3">SaleItem.modifyQuantity</td>
<td>语法</td> <td>public ResultMessage modifyQuantity(String goodsid, int quantity);</td>
</tr>
<tr>
<td>前置条件</td> <td>商品存在</td>
</tr>
<tr>
<td>后置条件</td><td>改变数量</td>
</tr>
<tr>
<td rowspan="3">SaleItem.getTotal</td>
<td>语法</td> <td>public ResultMessage getTotal();</td>
</tr>
<tr>
<td>前置条件</td> <td>商品存在且数量存在</td>
</tr>
<tr>
<td>后置条件</td><td>返回小计</td>
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
<td>GoodsInfo.getGoods</td> 
<td>获得商品信息</td>
</tr>
</table>
表 4.1.2(3)-4 Bill 的接口规范
<table>
<tr>
<td colspan ="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提供的服务（供接口）</td>
</tr>
<tr>
<tr>
<td rowspan="3">Bill.refresh</td>
<td>语法</td> <td>public Bill refresh(DateUtil date, List<SaleItem>, String memberId, int sum);</td>
</tr>
<tr>
<td>前置条件</td> <td>单据中存在会员，商品名，商品数量等信息</td>
</tr>
<tr>
<td>后置条件</td><td>返回原价、使用的促销策略和总价</td>
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
<td>SaleItem.getTotal</td> 
<td>获得表单商品的价格小计</td>
</tr>
</tr>
<tr>
<td>PresentBLInfo.getPresent</td> 
<td>获得促销策略</td>
</tr>
</table>
#### (4)业务逻辑层的动态模型

图4.1.1（4）-1表明了进销存系统中，当用户删除单据时，销售业务逻辑处理的相关对象之间的协作。其他同理。<br/>
![image](http://101.37.19.32:10080/CuteGroup/Cute_Project/raw/master/doc/img/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E7%9B%B8%E5%85%B3/%E5%88%A0%E9%99%A4%E9%94%80%E5%94%AE%E7%B1%BB%E5%8D%95%E6%8D%AE.png)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-1删除单据**<br/>
![image](http://101.37.19.32:10080/CuteGroup/Cute_Project/raw/master/doc/img/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E7%9B%B8%E5%85%B3/Sale%E5%AF%B9%E8%B1%A1%E7%8A%B6%E6%80%81%E5%9B%BE.png)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.2（4）-2 Sale对象状态图**<br/>