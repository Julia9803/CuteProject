### 4.1.1 goods 模块
#### （1）模块描述
goodsbl模块承担的需求参见需求规格说明文档功能需求及相关非功能需求
goodsbl模块的职责及接口参见软件系统体系结构描述文档

#### （2）整体结构
根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性和可修改性，我们会添加接口。在展示层和业务逻辑层之间，我们添加GoodsBLService接口。业务逻辑层和数据层之间添加GoodsDataService接口。为了隔离业务逻辑职责和逻辑控制职责，我们添加了GoodsBLServiceImpl，这样GoodsBLServiceImpl会将对新建的业务逻辑处理委托给Goods和GoodsCategory对象。GoodsPO和GoodsCategoryPO是作为商品和商品分类信息的持久化对象被添加到设计模型中去的。<br/>

goodsbl模块的设计如图4.1.1-1 所示

![image](http://a2.qpic.cn/psb?/V11Pcdyy3quqYu/dtn8Q8lHih106FonqqDFhOkYFch2xdcIELlU3ucqEgM!/b/dIUBAAAAAAAA&ek=1&kp=1&pt=0&bo=ywNgAssDYAIDACU!&vuin=2577309506&tm=1509163200&sce=60-1-1&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图 4.1.1（1）-1 goodsbl模块设计模型**<br/>

表 4.1.1-1（2） goodsbl模块各个类的职责<br/>

模块 | 职责
---|---
GoodsBLServiceImpl | 管理goodsbl各个类的任务
Goods | 完成对商品信息的增删改查任务
GoodsCategory | 完成对商品分类信息的增删改查任务

#### （3）模块内部类的接口规范
GoodsBLServiceImpl 的接口规范如表4.1.1（3）-1所示。<br/>
Goods的接口规范如表4.1.1（3）-2所示。<br/>
GoodsCategory的接口规范如表4.1.1（3）-3所示。<br/>

表4.1.1（3）-1 GoodsBLServiceImpl的接口规范
<table>
<tr>
<td colspan ="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提供的服务（供接口）</td>
</tr>
<tr>
<td rowspan="3">GoodsBLServiceImpl.newGoods</td>
<td>语法</td> <td> public String newGoods(String name,String category);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择新建商品</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示商品名称和编号</td>
</tr>
<tr>
<td rowspan="3">GoodsBLServiceImpl.findGoods</td>
<td>语法</td> <td> public List<GoodsVO> findGoods(String info,String type);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户输入信息模糊查找商品</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示模糊查找后符合要求的商品列表</td>
</tr>
<tr>
<td rowspan="3">GoodsBLServiceImpl.deleteGoods</td>
<td>语法</td> <td> public ResultMessage deleteGoods(String id);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择删除商品</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品列表</td>
</tr>
<tr>
<td rowspan="3">GoodsBLServiceImpl.modifyGoods</td>
<td>语法</td> <td> public ResultMessage modifyGoods(GoodsVO vo);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择修改商品信息</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品信息</td>
</tr>
<tr>
<td rowspan="3">GoodsBLServiceImpl.initAndSaveGoods</td>
<td>语法</td> <td>public ResultMessage initAndSaveGoods(GoodsVO vo);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户保存已初始化的商品信息</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品信息</td>
</tr>
<tr>
<td rowspan="3">GoodsBLServiceImpl.newGoodsCategory</td>
<td>语法</td> <td>public ResultMessage newGoodsCategory(String category,String node);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择新建商品分类</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品分类信息</td>
</tr>
<tr>
<td rowspan="3">GoodsBLServiceImpl.deleteGoodsCategory</td>
<td>语法</td> <td>public ResultMessage deleteGoodsCategory(String category);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择删除商品分类</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品分类信息</td>
</tr>
<tr>
<td rowspan="3">GoodsBLServiceImpl.modifyGoodsCategory</td>
<td>语法</td> <td>public ResultMessage modifyGoodsCategory(String category);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择修改商品分类名称</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品分类信息</td>
</tr>
<tr>
<td rowspan="3">GoodsBLServiceImpl.getAllGoodsAndCategory</td>
<td>语法</td> <td>public TreeVO getAllGoodsAndCategory();</td>
</tr>
<tr>
<td>前置条件</td><td>用户选择查看所有分类和所有商品</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示所有分类和所有商品</td>
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
<td>Goods.newGoods(String name,String category)</td> <td>新建商品</td>
</tr>
<tr>
<td>Goods.findGoods(String info,String type)</td> <td>模糊查找商品</td>
</tr>
<tr>
<td>Goods.deleteGoods(String id)</td> 
<td>删除商品</td>
</tr>
<tr>
<td>Goods.modifyGoods(GoodsVO vo)</td> 
<td>修改商品信息</td>
</tr>
<tr>
<td>Goods.initAndSaveGoods(GoodsVO vo)</td> 
<td>初始化并保存商品信息</td>
</tr>
<tr>
<td>GoodsCategory.newGoodsCategory(String category,String node)</td> 
<td>新建商品分类</td>
</tr>
<tr>
<td>GoodsCategory.deleteGoodsCategory(String category)</td> 
<td>删除商品分类</td>
</tr>
<tr>
<td>GoodsCategory.modifyGoodsCategory(String category)</td> 
<td>修改商品分类名</td>
</tr>
<tr>
<td>GoodsCategory.getAllGoodsAndCategory()</td> 
<td>获取所有商品分类和商品</td>
</tr>
</table>

表4.1.1（3）-2 Goods 的接口规范
<table>
<tr>
<td colspan ="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提供的服务（供接口）</td>
</tr>
<tr>
<td rowspan="3">Goods.newGoods</td>
<td>语法</td> <td> public String newGoods(String name,String category);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择新建商品</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示商品名称和编号</td>
</tr>
<tr>
<td rowspan="3">Goods.findGoods</td>
<td>语法</td> <td> public List<GoodsVO> findGoods(String info,String type);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户输入信息模糊查找商品</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示模糊查找后符合要求的商品列表</td>
</tr>
<tr>
<td rowspan="3">Goods.deleteGoods</td>
<td>语法</td> <td> public ResultMessage deleteGoods(String id);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择删除商品</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品列表</td>
</tr>
<tr>
<td rowspan="3">Goods.modifyGoods</td>
<td>语法</td> <td> public ResultMessage modifyGoods(GoodsVO vo);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择修改商品信息</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品信息</td>
</tr>
<tr>
<td rowspan="3">Goods.initAndSaveGoods</td>
<td>语法</td> <td>public ResultMessage initAndSaveGoods(GoodsVO vo);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户保存已初始化的商品信息</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品信息</td>
</tr>
</table>
<table>
<td colspan = "2">需要的服务（需接口）</td>
</tr>
<tr>
<td>服务名</td> <td>服务</td>
</tr>
<tr>
<td>GoodsDataService.newGoods(String name,String category)</td> <td>新建商品</td>
</tr>
<tr>
<td>GoodsDataService.findGoods(String info,String type)</td> <td>模糊查找商品</td>
</tr>
<tr>
<td>GoodsDataService.deleteGoods(String id)</td> 
<td>删除商品</td>
</tr>
<tr>
<td>GoodsDataService.modifyGoods(GoodsVO vo)</td> 
<td>修改商品信息</td>
</tr>
<tr>
<td>GoodsDataService.initAndSaveGoods(GoodsVO vo)</td> 
<td>初始化并保存商品信息</td>
</tr>
</table>

表 4.1.1(3)-3 GoodsCategory 的接口规范
<table>
<tr>
<td colspan ="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提供的服务（供接口）</td>
</tr>
<tr>
<tr>
<td rowspan="3">GoodsCategory.newGoodsCategory</td>
<td>语法</td> <td>public ResultMessage newGoodsCategory(String category,String node);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择新建商品分类</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品分类信息</td>
</tr>
<tr>
<td rowspan="3">GoodsCategory.deleteGoodsCategory</td>
<td>语法</td> <td>public ResultMessage deleteGoodsCategory(String category);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择删除商品分类</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品分类信息</td>
</tr>
<tr>
<td rowspan="3">GoodsCategory.modifyGoodsCategory</td>
<td>语法</td> <td>public ResultMessage modifyGoodsCategory(String category);</td>
</tr>
<tr>
<td>前置条件</td> <td>用户选择修改商品分类名称</td>
</tr>
<tr>
<td>后置条件</td><td>系统更新商品分类信息</td>
</tr>
<tr>
<td rowspan="3">GoodsCategory.getAllGoodsAndCategory</td>
<td>语法</td> <td>public TreeVO getAllGoodsAndCategory();</td>
</tr>
<tr>
<td>前置条件</td><td>用户选择查看所有分类和所有商品</td>
</tr>
<tr>
<td>后置条件</td><td>系统显示所有分类和所有商品</td>
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
<td>GoodsDataService.newGoodsCategory(String category,String node)</td> 
<td>新建商品分类</td>
</tr>
<tr>
<td>GoodsDataService.deleteGoodsCategory(String category)</td> 
<td>删除商品分类</td>
</tr>
<tr>
<td>GoodsDataService.modifyGoodsCategory(String category)</td> 
<td>修改商品分类名</td>
</tr>
<tr>
<td>GoodsDataService.getAllGoodsAndCategory()</td> 
<td>获取所有商品分类和商品</td>
</tr>
</table>

#### (4)业务逻辑层的动态模型
图4.1.1（4）-1表明了进销存系统中，当用户选择新建商品时，商品业务逻辑处理的相关对象之间的协作。<br/>
![image](http://r.photo.store.qq.com/psb?/V11Pcdyy3quqYu/8*AJMTAw7bnEqD5Qerp9VdMIQmOt8TzYicenX6NqcwM!/o/dCsAAAAAAAAA&ek=1&kp=1&pt=0&bo=xgQ9AsYEPQIDACU!&tm=1509174000&sce=0-12-12&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-1增加商品**<br/>

图4.1.1（4）-2表明了进销存系统中，当用户模糊查找商品时，商品业务逻辑处理的相关对象之间的协作。<br/>
![image](http://r.photo.store.qq.com/psb?/V11Pcdyy3quqYu/3FyZqVaYJ9Kf8Z5aI0cq2xDVhlJZpV6kyjnoYZ5KbAs!/o/dOAAAAAAAAAA&ek=1&kp=1&pt=0&bo=NAY9AjQGPQIDACU!&tm=1509177600&sce=0-12-12&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-2模糊查找商品**<br/>

图4.1.1（4）-3表明了进销存系统中，当用户删除商品时，商品业务逻辑处理的相关对象之间的协作。<br/>
![image](http://r.photo.store.qq.com/psb?/V11Pcdyy3quqYu/ZogjAK.Zd2UUUvC6YMdjPln8AdbIQDlqR2Mp2*0x6sE!/o/dIUBAAAAAAAA&ek=1&kp=1&pt=0&bo=xgQ9AsYEPQIDACU!&tm=1509174000&sce=0-12-12&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-3删除商品**<br/>

图4.1.1（4）-4表明了进销存系统中，当用户修改商品信息时，商品业务逻辑处理的相关对象之间的协作。<br/>
![image](http://r.photo.store.qq.com/psb?/V11Pcdyy3quqYu/GXic61CFc1QzL6j32P1AL3lDtRFYp27vcFB9judJr88!/o/dOIAAAAAAAAA&ek=1&kp=1&pt=0&bo=xgQ9AsYEPQIDACU!&tm=1509174000&sce=0-12-12&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-4修改商品信息**<br/>

图4.1.1（4）-5表明了进销存系统中，当用户初始化并保存商品信息时，商品业务逻辑处理的相关对象之间的协作。<br/>
![image](http://r.photo.store.qq.com/psb?/V11Pcdyy3quqYu/rRzSFAxtXIZ4ZKgpDm5lSRw9cLP.pmaFvDZSR2QPNZc!/o/dHYBAAAAAAAA&ek=1&kp=1&pt=0&bo=YQUzAmEFMwIDACU!&tm=1509177600&sce=0-12-12&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-5初始化商品信息并保存**<br/>

图4.1.1（4）-6表明了进销存系统中，当用户新建商品分类时，商品业务逻辑处理的相关对象之间的协作。<br/>
![image](http://r.photo.store.qq.com/psb?/V11Pcdyy3quqYu/PB5rx4mnS6zfRvvPzEibJme0YH.VnoXgGlrkzlcZmfw!/o/dG4AAAAAAAAA&ek=1&kp=1&pt=0&bo=VgVAAlYFQAIDACU!&tm=1509174000&sce=0-12-12&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-6新建商品分类**<br/>

图4.1.1（4）-7表明了进销存系统中，当用户删除商品分类时，商品业务逻辑处理的相关对象之间的协作。<br/>
![image](http://r.photo.store.qq.com/psb?/V11Pcdyy3quqYu/6N3LwISBXu8CE5foDwAGATw*zEsFa2XA1XvBeHDltOc!/o/dI4BAAAAAAAA&ek=1&kp=1&pt=0&bo=VgVAAlYFQAIDACU!&tm=1509174000&sce=0-12-12&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-7删除商品分类**<br/>

图4.1.1（4）-8表明了进销存系统中，当用户修改商品分类名称时，商品业务逻辑处理的相关对象之间的协作。<br/>
![image](http://r.photo.store.qq.com/psb?/V11Pcdyy3quqYu/STrfVJl2ZahLmt.sIFFOl9iQkRIHI9BfpC1TwPTHcvQ!/o/dI4BAAAAAAAA&ek=1&kp=1&pt=0&bo=VgVAAlYFQAIDACU!&tm=1509174000&sce=0-12-12&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-8修改商品分类**<br/>

图4.1.1（4）-9表明了进销存系统中，当用户查看所有分类和商品时，商品业务逻辑处理的相关对象之间的协作。<br/>
![image](http://r.photo.store.qq.com/psb?/V11Pcdyy3quqYu/hYhKMRA6d*GcwMUF9s3MU8SIYZfIbJMRZeFB23YLWLM!/o/dD0BAAAAAAAA&ek=1&kp=1&pt=0&bo=XgU4Al4FOAIDACU!&tm=1509177600&sce=0-12-12&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-9查看所有分类和商品**<br/>

图4.1.1（4）-10所示的状态图描述Goods对象的生存期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。随着initAndSaveGoods/newGoods/findGoods/deleteGoods/modifyGoods方法被GoodsBLServiceImpl调用，Goods进入handleData状态；之后通过获取GoodsPO进入Present状态；通过获取ResultMessage进入Complete状态<br/>
![image](http://r.photo.store.qq.com/psb?/V11Pcdyy3quqYu/uCfsiuuXXNOjAFOHv9t9EcCtfdjKDxQHZPPd*qaamyg!/o/dD0BAAAAAAAA&ek=1&kp=1&pt=0&bo=6AI.AegCPgEDACU!&tm=1509181200&sce=0-12-12&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-10 Goods对象状态图**<br/>

图4.1.1（4）-11所示的状态图描述GoodsCategory对象的生存期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。随着newGoodsCategory/deleteGoodsCategory/modifyGoodsCategory/getAllGoodsAndCategory方法被GoodsBLServiceImpl调用，GoodsCategory进入handleData状态；之后通过获取GoodsPO进入Present状态；通过获取ResultMessage进入Complete状态<br/>
![image](http://r.photo.store.qq.com/psb?/V11Pcdyy3quqYu/7D5ojck8BL.retoezdZR8PAxjPs4TF4zCyyk3xly*7M!/o/dOAAAAAAAAAA&ek=1&kp=1&pt=0&bo=6AI.AegCPgEDACU!&tm=1509181200&sce=0-12-12&rf=viewer_311)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**图4.1.1（4）-11 GoodsCategory对象状态图**<br/>
