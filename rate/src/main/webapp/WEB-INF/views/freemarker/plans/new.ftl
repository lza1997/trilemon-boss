<div class="trilemon-shelf-plan-setting">
<div class="new">

<div class="plan-name row">
    <h4>计划名称</h4>

    <div class="dropdown">
        <button data-toggle="dropdown" class="btn btn-default" href="#">周一</button>
        <div class="dropdown-menu" role="menu" aria-labelledby="dLabel">
            <ul id="tab" class="nav nav-tabs">
                <li class="active"><a href="#home" data-toggle="tab">上午</a></li>
                <li><a href="#profile" data-toggle="tab">下午</a></li>
                <li><a href="#profile" data-toggle="tab">晚上</a></li>
                <li><a href="#profile" data-toggle="tab">凌晨</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="home">
                    <ul>
                        <li role="presentation">
                            <div class="adjust-intervals-time pull-left">
                                <label>
                                    <input type="checkbox" name="options" id="option1"> 6点 到 7点
                                </label>
                            </div>
                            <div class="adjust-intervals-num  pull-left">
                                <input type="number" class="form-control" min="1" max="999" value="1">
                            </div>
                            <small class="pull-left">宝贝数量</small>
                            <div class="clearfix"></div>
                        </li>
                        <li role="presentation" class="text-muted">
                            <div class="adjust-intervals-time pull-left">
                                <label>
                                    <input type="checkbox" name="options" id="option1"> 7点 到 8点
                                </label>
                            </div>
                            <div class="adjust-intervals-num  pull-left">
                                <input type="number" class="form-control" min="1" max="999" value="1">
                            </div>
                            <small class="pull-left">宝贝数量</small>
                            <div class="clearfix"></div>
                        </li>
                        <li role="presentation" class="text-muted">
                            <div class="adjust-intervals-time pull-left">
                                <label>
                                    <input type="checkbox" name="options" id="option1"> 8点 到 9点
                                </label>
                            </div>
                            <div class="adjust-intervals-num  pull-left">
                                <input type="number" class="form-control" min="1" max="999" value="1">
                            </div>
                            <small class="pull-left">宝贝数量</small>
                            <div class="clearfix"></div>
                        </li>
                        <li role="presentation" class="text-muted">
                            <div class="adjust-intervals-time pull-left">
                                <label>
                                    <input type="checkbox" name="options" id="option1"> 9点 到 10点
                                </label>
                            </div>
                            <div class="adjust-intervals-num  pull-left">
                                <input type="number" class="form-control" min="1" max="999" value="1">
                            </div>
                            <small class="pull-left">宝贝数量</small>
                            <div class="clearfix"></div>
                        </li>
                        <li role="presentation" class="text-muted">
                            <div class="adjust-intervals-time pull-left">
                                <label>
                                    <input type="checkbox" name="options" id="option1"> 10点 到 11点
                                </label>
                            </div>
                            <div class="adjust-intervals-num  pull-left">
                                <input type="number" class="form-control" min="1" max="999" value="1">
                            </div>
                            <small class="pull-left">宝贝数量</small>
                            <div class="clearfix"></div>
                        </li>
                        <li role="presentation" class="text-muted">
                            <div class="adjust-intervals-time pull-left">
                                <label>
                                    <input type="checkbox" name="options" id="option1"> 11点 到 12点
                                </label>
                            </div>
                            <div class="adjust-intervals-num  pull-left">
                                <input type="number" class="form-control" min="1" max="999" value="1">
                            </div>
                            <small class="pull-left">宝贝数量</small>
                            <div class="clearfix"></div>
                        </li>
                    </ul>
                </div>
                <div class="tab-pane fade" id="profile">
                    <ul>
                        <li role="presentation">
                            <div class="adjust-intervals-time pull-left">
                                <label>
                                    <input type="checkbox" name="options" id="option1"> 18点 到 19点
                                </label>
                            </div>
                            <div class="adjust-intervals-num  pull-left">
                                <input type="number" class="form-control" min="1" max="999" value="1">
                            </div>
                            <div class="clearfix"></div>
                        </li>
                        <li role="presentation">
                            <div class="adjust-intervals-time pull-left">
                                <label>
                                    <input type="checkbox" name="options" id="option1"> 18点 到 19点
                                </label>
                            </div>
                            <div class="adjust-intervals-num  pull-left">
                                <input type="number" class="form-control" min="1" max="999" value="1">
                            </div>
                            <div class="clearfix"></div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <form>
        <div class="col-lg-3">
            <input type="txt" class="form-control plan-name" placeholder="请输入计划名称" name="name"
                   <#if planSetting.name??>value="${planSetting.name}"</#if>>
            <label class="adjust-showcase">
                <input type="checkbox" name="is_adjust_showcase"
                       <#if (planSetting.adjust_showcase?? && planSetting.adjust_showcase)>checked</#if>> 不调整橱窗宝贝
            </label>
        </div>
    </form>
</div>

<div class="row adjust-items">
<h4>1. 挑选宝贝</h4>

<div class="row item-filter-box">
    <div class="radio">
        <label>
            <input name="items" type="radio" id="all">
            所有宝贝
        </label>
        <a type="button" class="btn btn-default btn-xs filter" data-toggle="modal"
           href="#exclude-keyword-filter-modal" disabled="disabled">
            <i class="icon-filter"></i> 筛选</a>
    </div>
    <blockquote class="msg">
        <p>不包括标题含以下关键词的宝贝：<strong>「特价」</strong>、<strong>「包邮」</strong></p>
    </blockquote>
</div>

<div class="modal keyword-filter-modal" id="exclude-keyword-filter-modal" tabindex="-1"
     role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">排除标题含以下关键词的宝贝</h4>
            </div>
            <div class="modal-body">
                <input id="exclude-keyword-filter-modal-input" class="form-control" data-role="tagsinput"/>

                <div class="row tip">
                    <p class="text-muted left-tip pull-left">此关键词共搜索到100个宝贝</p>

                    <p class="text-muted right-tip pull-right">已设定3个关键词，排除了20个宝贝（总共100个宝贝）</p>
                </div>

                <div class="items">
                    <div class="item row">
                        <div class="pic">
                            <a class="item-big-pic" href="#" data-placement="right"
                               data-content="<img src='http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_210x210.jpg'>">
                                <span>
                                    <img src="http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_60x60.jpg">
                                </span>
                            </a>
                        </div>
                        <div class="summary">
                            <div class=title>
                                <a href="#">热卖<span class="match">包邮</span>女包韩版子母包包2013新款</a>
                            </div>
                            <div class="price">
                                <i class="icon-jpy"></i><span> 995.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="item row">
                        <div class="pic">
                            <a class="item-big-pic" href="#" data-placement="right"
                               data-content="<img src='http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_210x210.jpg'>">
                                <span>
                                    <img src="http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_60x60.jpg">
                                </span>
                            </a>
                        </div>
                        <div class="summary">
                            <div class=title>
                                <a>亏本清仓-韩国进口系列，各种款式孤品，都低于<span class="match">特价</span>，9月9日新</a>
                            </div>
                            <div class="price">
                                <i class="icon-jpy"></i><span> 89.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="item row">
                        <div class="pic">
                            <a class="item-big-pic" href="#" data-placement="right"
                               data-content="<img src='http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_210x210.jpg'>">
                                <span>
                                    <img src="http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_60x60.jpg">
                                </span>
                            </a>
                        </div>
                        <div class="summary">
                            <div class=title>
                                <a>亏本清仓-韩国进口系列，各种款式孤品，都低于<span class="match">特价</span>，9月9日新</a>
                            </div>
                            <div class="price">
                                <i class="icon-jpy"></i><span> 89.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="item row">
                        <div class="pic">
                            <a class="item-big-pic" href="#" data-placement="right"
                               data-content="<img src='http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_210x210.jpg'>">
                                <span>
                                    <img src="http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_60x60.jpg">
                                </span>
                            </a>
                        </div>
                        <div class="summary">
                            <div class=title>
                                <a>亏本清仓-韩国进口系列，各种款式孤品，都低于<span class="match">特价</span>，9月9日新</a>
                            </div>
                            <div class="price">
                                <i class="icon-jpy"></i><span> 89.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="item row">
                        <div class="pic">
                            <a class="item-big-pic" href="#" data-placement="right"
                               data-content="<img src='http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_210x210.jpg'>">
                                <span>
                                    <img src="http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_60x60.jpg">
                                </span>
                            </a>
                        </div>
                        <div class="summary">
                            <div class=title>
                                <a>亏本清仓-韩国进口系列，各种款式孤品，都低于<span class="match">特价</span>，9月9日新</a>
                            </div>
                            <div class="price">
                                <i class="icon-jpy"></i><span> 89.00</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <ul class="pagination pagination-sm">
                        <li><a href="#">&laquo;</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>

<div class="row item-filter-box">
    <div class="radio">
        <label>
            <input type="radio" id="cid" name="items">
            店铺宝贝分类
        </label>
        <a type="button" class="btn btn-default btn-xs filter" data-toggle="modal" href="#cid-filter-modal"
           disabled="disabled">
            <i class="icon-filter"></i> 筛选</a>
    </div>
    <blockquote class="msg">
        <p>选择类目：<strong>「跑鞋」</strong>、<strong>「上衣」</strong></p>
    </blockquote>
</div>

<div class="modal" id="cid-filter-modal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">选择店铺类目</h4>
            </div>
            <div class="modal-body">
                <p class="text-muted tip">已选择2个类目，共100个宝贝</p>

                <div class="cids">
                    <div class="cid row">
                        <div class="col-lg-5"><p>店铺自定义类目E（23）</p></div>
                        <button type="button" class="btn btn-xs btn-success">加入</button>
                    </div>
                    <div class="cid row">
                        <div class="col-lg-5"><p>店铺自定义类目A（1）</p></div>
                        <button type="button" class="btn btn-xs btn-default">取消加入</button>
                    </div>
                    <div class="cid row">
                        <div class="col-lg-5"><p>店铺自定义类目B（3）</p></div>
                        <button type="button" class="btn btn-xs btn-success">加入</button>
                    </div>
                    <div class="cid row">
                        <div class="col-lg-5"><p>店铺自定义类目C（12）</p></div>
                        <button type="button" class="btn btn-xs btn-default">取消加入</button>
                    </div>
                    <div class="cid row">
                        <div class="col-lg-5"><p>店铺自定义类目D（100）</p></div>
                        <button type="button" class="btn btn-xs btn-default">取消加入</button>
                    </div>
                </div>
                <div>
                    <ul class="pagination pagination-sm">
                        <li><a href="#">&laquo;</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>

<div class="row item-filter-box">
    <div class="radio">
        <label>
            <input type="radio" id="keyword" name="items">
            宝贝关键词
        </label>
        <a type="button" class="btn btn-default btn-xs filter" data-toggle="modal"
           href="#include-keyword-filter-modal" disabled="disabled">
            <i class="icon-filter"></i> 筛选</a>
    </div>
    <blockquote class="msg">
        <p>标题含以下关键词的宝贝：<strong>「特价」</strong>、<strong>「包邮」</strong></p>
    </blockquote>
</div>
<div class="modal keyword-filter-modal" id="include-keyword-filter-modal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">标题包含以下关键词的宝贝</h4>
            </div>
            <div class="modal-body">
                <input id="include-keyword-filter-modal-input" class="form-control" data-role="tagsinput"/>

                <div class="row tip">
                    <p class="text-muted left-tip pull-left">此关键词共搜索到100个宝贝</p>

                    <p class="text-muted right-tip pull-right">已设定3个关键词， 总共匹配了100个宝贝</p>
                </div>

                <div class="items">
                    <div class="item row">
                        <div class="pic">
                            <a class="item-big-pic" href="#" data-placement="right"
                               data-content="<img src='http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_210x210.jpg'>">
                                <span>
                                    <img src="http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_60x60.jpg">
                                </span>
                            </a>
                        </div>
                        <div class="summary">
                            <div class=title>
                                <a href="#">热卖<span class="match">包邮</span>女包韩版子母包包2013新款</a>
                            </div>
                            <div class="price">
                                <i class="icon-jpy"></i><span> 995.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="item row">
                        <div class="pic">
                            <a class="item-big-pic" href="#" data-placement="right"
                               data-content="<img src='http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_210x210.jpg'>">
                                <span>
                                    <img src="http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_60x60.jpg">
                                </span>
                            </a>
                        </div>
                        <div class="summary">
                            <div class=title>
                                <a>亏本清仓-韩国进口系列，各种款式孤品，都低于<span class="match">特价</span>，9月9日新</a>
                            </div>
                            <div class="price">
                                <i class="icon-jpy"></i><span> 89.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="item row">
                        <div class="pic">
                            <a class="item-big-pic" href="#" data-placement="right"
                               data-content="<img src='http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_210x210.jpg'>">
                                <span>
                                    <img src="http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_60x60.jpg">
                                </span>
                            </a>
                        </div>
                        <div class="summary">
                            <div class=title>
                                <a>亏本清仓-韩国进口系列，各种款式孤品，都低于<span class="match">特价</span>，9月9日新</a>
                            </div>
                            <div class="price">
                                <i class="icon-jpy"></i><span> 89.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="item row">
                        <div class="pic">
                            <a class="item-big-pic" href="#" data-placement="right"
                               data-content="<img src='http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_210x210.jpg'>">
                                <span>
                                    <img src="http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_60x60.jpg">
                                </span>
                            </a>
                        </div>
                        <div class="summary">
                            <div class=title>
                                <a>亏本清仓-韩国进口系列，各种款式孤品，都低于<span class="match">特价</span>，9月9日新</a>
                            </div>
                            <div class="price">
                                <i class="icon-jpy"></i><span> 89.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="item row">
                        <div class="pic">
                            <a class="item-big-pic" href="#" data-placement="right"
                               data-content="<img src='http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_210x210.jpg'>">
                                <span>
                                    <img src="http://img01.taobaocdn.com/bao/uploaded/i4/16518028093447593/T1.c4.Fn0dXXXXXXXX_!!0-item_pic.jpg_60x60.jpg">
                                </span>
                            </a>
                        </div>
                        <div class="summary">
                            <div class=title>
                                <a>亏本清仓-韩国进口系列，各种款式孤品，都低于<span class="match">特价</span>，9月9日新</a>
                            </div>
                            <div class="price">
                                <i class="icon-jpy"></i><span> 89.00</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <ul class="pagination pagination-sm">
                        <li><a href="#">&laquo;</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>
</div>

<div class="row adjust-intervals">
    <h4>2. 选择时间段</h4>

    <div class="row auto-box adjust-intervals-box">
        <div class="radio">
            <label>
                <input name="adjust-intervals" type="radio" id="auto">
                自动选择时间段
            </label>
        </div>
    </div>

    <div class="row manual-box adjust-intervals-box">
        <div class="radio">
            <label>
                <input name="adjust-intervals" type="radio" id="manual">
                手动选择时间段
            </label>
            <a type="button" class="filter btn btn-default btn-xs" data-toggle="modal"
               href="#manual-adjust-intervals-modal" disabled="disabled">
                <i class="icon-filter"></i> 筛选</a>
        </div>
        <blockquote class="msg">
            <p>星期二 10点 - 11点 3个宝贝</p>

            <p>星期二 10点 - 11点 3个宝贝</p>

            <p>星期二 10点 - 11点 3个宝贝</p>

            <p>星期二 10点 - 11点 3个宝贝</p>

            <p>星期二 10点 - 11点 3个宝贝</p>
        </blockquote>
    </div>
    <div class="modal" id="manual-adjust-intervals-modal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">选择上下架时间段</h4>
                </div>
                <div class="modal-body">
                    <ul class="pagination pagination-sm">
                        <li>
                            <p style="float: left">周一</p>
                            <div class="dropdown" style="float: left">
                                <button data-toggle="dropdown" class="btn btn-default" href="#">请选择时间段</button>
                                <div class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                                    <ul id="tab" class="nav nav-tabs">
                                        <li class="active"><a href="#home" data-toggle="tab">上午</a></li>
                                        <li><a href="#profile" data-toggle="tab">下午</a></li>
                                        <li><a href="#profile" data-toggle="tab">晚上</a></li>
                                        <li><a href="#profile" data-toggle="tab">凌晨</a></li>
                                    </ul>
                                    <div id="myTabContent" class="tab-content">
                                        <div class="tab-pane fade in active" id="home">
                                            <ul>
                                                <li role="presentation">
                                                    <div class="adjust-intervals-time pull-left">
                                                        <label>
                                                            <input type="checkbox" name="options" id="option1"> 6点 到 7点
                                                        </label>
                                                    </div>
                                                    <div class="adjust-intervals-num  pull-left">
                                                        <input type="number" class="form-control" min="1" max="999" value="1">
                                                    </div>
                                                    <small class="pull-left">宝贝数量</small>
                                                    <div class="clearfix"></div>
                                                </li>
                                                <li role="presentation" class="text-muted">
                                                    <div class="adjust-intervals-time pull-left">
                                                        <label>
                                                            <input type="checkbox" name="options" id="option1"> 7点 到 8点
                                                        </label>
                                                    </div>
                                                    <div class="adjust-intervals-num  pull-left">
                                                        <input type="number" class="form-control" min="1" max="999" value="1">
                                                    </div>
                                                    <small class="pull-left">宝贝数量</small>
                                                    <div class="clearfix"></div>
                                                </li>
                                                <li role="presentation" class="text-muted">
                                                    <div class="adjust-intervals-time pull-left">
                                                        <label>
                                                            <input type="checkbox" name="options" id="option1"> 8点 到 9点
                                                        </label>
                                                    </div>
                                                    <div class="adjust-intervals-num  pull-left">
                                                        <input type="number" class="form-control" min="1" max="999" value="1">
                                                    </div>
                                                    <small class="pull-left">宝贝数量</small>
                                                    <div class="clearfix"></div>
                                                </li>
                                                <li role="presentation" class="text-muted">
                                                    <div class="adjust-intervals-time pull-left">
                                                        <label>
                                                            <input type="checkbox" name="options" id="option1"> 9点 到 10点
                                                        </label>
                                                    </div>
                                                    <div class="adjust-intervals-num  pull-left">
                                                        <input type="number" class="form-control" min="1" max="999" value="1">
                                                    </div>
                                                    <small class="pull-left">宝贝数量</small>
                                                    <div class="clearfix"></div>
                                                </li>
                                                <li role="presentation" class="text-muted">
                                                    <div class="adjust-intervals-time pull-left">
                                                        <label>
                                                            <input type="checkbox" name="options" id="option1"> 10点 到 11点
                                                        </label>
                                                    </div>
                                                    <div class="adjust-intervals-num  pull-left">
                                                        <input type="number" class="form-control" min="1" max="999" value="1">
                                                    </div>
                                                    <small class="pull-left">宝贝数量</small>
                                                    <div class="clearfix"></div>
                                                </li>
                                                <li role="presentation" class="text-muted">
                                                    <div class="adjust-intervals-time pull-left">
                                                        <label>
                                                            <input type="checkbox" name="options" id="option1"> 11点 到 12点
                                                        </label>
                                                    </div>
                                                    <div class="adjust-intervals-num  pull-left">
                                                        <input type="number" class="form-control" min="1" max="999" value="1">
                                                    </div>
                                                    <small class="pull-left">宝贝数量</small>
                                                    <div class="clearfix"></div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="tab-pane fade" id="profile">
                                            <ul>
                                                <li role="presentation">
                                                    <div class="adjust-intervals-time pull-left">
                                                        <label>
                                                            <input type="checkbox" name="options" id="option1"> 18点 到 19点
                                                        </label>
                                                    </div>
                                                    <div class="adjust-intervals-num  pull-left">
                                                        <input type="number" class="form-control" min="1" max="999" value="1">
                                                    </div>
                                                    <div class="clearfix"></div>
                                                </li>
                                                <li role="presentation">
                                                    <div class="adjust-intervals-time pull-left">
                                                        <label>
                                                            <input type="checkbox" name="options" id="option1"> 18点 到 19点
                                                        </label>
                                                    </div>
                                                    <div class="adjust-intervals-num  pull-left">
                                                        <input type="number" class="form-control" min="1" max="999" value="1">
                                                    </div>
                                                    <div class="clearfix"></div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li><p>周二</p></li>
                        <li><p>周三</p></li>
                        <li><p>周四</p></li>
                        <li><p>周五</p></li>
                        <li><p>周六</p></li>
                        <li><p>周七</p></li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="next-step row">
    <button type="button" class="btn btn-primary next-step-ok">创建计划</button>
    <button type="button" class="btn btn-default">取消</button>
</div>
</div>
</div>
</div>

