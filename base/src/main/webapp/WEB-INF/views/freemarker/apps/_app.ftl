<div class="page-header row" xmlns="http://www.w3.org/1999/html">
<#if (app??)>
    <h3>${app.appName}
        <small>${serviceCode}</small>
    </h3>
<#else >
    无此应用（${serviceCode}）
</#if>
</div>

<div class="row tb">
    <form name="app-form" hidden="true" action="${requestContext.getContextPath()}/apps/${serviceCode}" method="get">
        <input type="hidden" name="pageNum" value="${isvAppPage.pageNum?c}">
        <input type="hidden" name="startDate" value="${startDate}">
        <input type="hidden" name="endDate" value="${endDate}">
        <input type="hidden" name="field" value="${field}">
        <input type="hidden" name="sort" value="${sort}">
    </form>

    <div class="pull-right">
        <button type="button" class="btn btn-default dropdown-toggle daterange" data-toggle="dropdown">
            <span class="glyphicon glyphicon-calendar"></span>
            &nbsp;<span class="daterange-fill-span">${startDate} - ${endDate}</span>&nbsp;
            <span class="caret"></span>
        </button>
    </div>
</div>

<div class="opt-content row">
    <div class="chart"></div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th class="sortable" id="app-name" data-app-attr="app_name">应用名<#if field='app_name'>&nbsp;
                <#if
                sort='desc'><span
                        class="caret-down"></span><#else><span
                        class="caret-up"></#if><#else><span></span></#if></th>
            <th class="sortable" data-app-attr="valid_rate_num">有效评分<#if field='valid_rate_num'>&nbsp;<#if
            sort='desc'><span
                        class="caret-down"></span><#else><span
                    class="caret-up"></#if><#else></#if></th>
            <th class="sortable" data-app-attr="pay_user_num">付费用户数<#if field='pay_user_num'>&nbsp;<#if
            sort='desc'><span
                        class="caret-down"></span><#else><span
                    class="caret-up"></#if></#if></th>
            <th class="sortable" data-app-attr="free_user_num">免费用户数<#if field='free_user_num'>&nbsp;<#if
            sort='desc'><span
                        class="caret-down"></span><#else><span
                    class="caret-up"></#if></#if></th>
            <th class="sortable" data-app-attr="pv">30天浏览量<#if field='pv'>&nbsp;<#if sort='desc'><span
                    class="caret-down"></span><#else><span
                    class="caret-up"></#if></#if></th>
            <th class="sortable" data-app-attr="order_num">订单数量<#if field='order_num'>&nbsp;<#if sort='desc'><span
                    class="caret-down"></span><#else><span
                    class="caret-up"></#if></#if></th>
            <th class="sortable" data-app-attr="revenue">收入<#if field='revenue'>&nbsp;<#if sort='desc'><span
                    class="caret-down"></span><#else><span
                    class="caret-up"></#if></#if></th>
            <th class="sortable" data-app-attr="crawl_time">抓取时间<#if field='crawl_time'>&nbsp;<#if
            sort='desc'><span
                        class="caret-down"></span><#else><span
                    class="caret-up"></#if></#if></th>
        </tr>
        </thead>
        <tbody>
        <#if isvAppPage.items?has_content>
            <#list isvAppPage.items as item>
            <tr>
                <td><img src="${item.appLogo}_20x20.jpg"/>&nbsp;&nbsp;${item.appName}</td>
                <td>${item.validRateNum}</td>
                <td>${item.payUserNum}</td>
                <td>${item.freeUserNum}</td>
                <td>${item.pv}</td>
                <td>${item.orderNum}</td>
                <td>${item.revenue}</td>
                <td>${item.crawlTime?date}</td>
            </tr>
            </#list>
        <#else>
        <tr>
            <td colspan="8" style="text-align:center;">无数据</td>
        </tr>
        </#if>
        </tbody>
    </table>
    <div class="col-md-offset-2">
        <ul class="pagination">
            <li class="<#if !isvAppPage.hasFirstPage()>disabled</#if>"><a
                    href='javascript:;' data-page-num=1>第一页</a>
            </li>
        <#if isvAppPage.hasPrePage()>
            <li><a href='javascript:;' data-page-num=${(isvAppPage.pageNum-1)?c}>上一页</a></li>
        <#else>
            <li class="disabled">
                <a href='javascript:;' data-page-num=1>上一页</a>
            </li>
        </#if>

        <#if (isvAppPage.pageNum > 1)>
            <#if (isvAppPage.pageNum-3 >= 2)>
                <#assign forwardFirstPage=(isvAppPage.pageNum-3)>
            <#else>
                <#assign forwardFirstPage=1>
            </#if>

            <#list forwardFirstPage..(isvAppPage.pageNum-1) as forwardPageNum>
                <li>
                    <a href='javascript:;' data-page-num=${forwardPageNum?c}>${forwardPageNum?c}</a>
                </li>
            </#list>
        </#if>
            <li class="active"><a href='javascript:;' data-page-num=${isvAppPage.pageNum?c}>${isvAppPage
            .pageNum?c}</a></li>

        <#if (isvAppPage.pageNum < isvAppPage.getPages())>
            <#if (isvAppPage.pageNum+4 <= isvAppPage.getPages())>
                <#assign backwardFirstPage=(isvAppPage.pageNum+4)>
            <#else>
                <#assign backwardFirstPage=isvAppPage.getPages()>
            </#if>

            <#list (isvAppPage.pageNum + 1)..backwardFirstPage as backwardPageNum>
                <li>
                    <a href='javascript:;' data-page-num=${backwardPageNum?c}>${backwardPageNum?c}</a>
                </li>
            </#list>
        </#if>
        <#if isvAppPage.hasNextPage()>
            <li><a href='javascript:;' data-page-num=${(isvAppPage.pageNum+1)?c}>下一页</a></li>
        <#else >
            <li class="disabled"><a href='javascript:;' data-page-num=${(isvAppPage.getPages())?c}>下一页</a></li>
        </#if>
            <li class="<#if !isvAppPage.hasLastPage()>disabled</#if>"><a href='javascript:;'
                                                                         data-page-num=${(isvAppPage.getPages())?c}>末页</a>
            </li>
        </ul>
    </div>
</div>
<script src="${requestContext.getContextPath()}/static/highcharts/highcharts.js"></script>
<script type="text/javascript">
    $(function () {
        $('.chart').highcharts({
            chart: {
                height: 300,
                zoomType: 'x'
            },
            title: {
                text: ''
            },
            xAxis: {
                type: 'datetime',
                categories: <#if xAxisCategories??>[${xAxisCategories}]</#if>,
                labels: {
                    <#if step??>step:${step},</#if>
                    rotation:30
                }
            },
            yAxis: {
                min:0,
                title: {
                text:
                <#if field='valid_rate_num'>'评价数'</#if>
                <#if field='pay_user_num'>'付费用户数'</#if>
                <#if field='free_user_num'>'免费用户数'</#if>
                <#if field='pv'>'pv'</#if>
                <#if field='order_num'>'订单量'</#if>
                <#if (field='revenue' || field='crawl_time' || field='app_name')>'收入'</#if>
                },
                plotLines: [
                    {
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }
                ]
            },
            tooltip: {
            valueSuffix:  <#if field='revenue'>'元'<#else>''</#if>
            },
            legend: {
                enabled:false
            },
        series:
        <#if field='valid_rate_num'>
                [
                    {
                        data:  <#if validRateNumSeries??>[${validRateNumSeries}]</#if>,
                        name: '评价数'
                    }
                ]
        </#if>
        <#if field='pay_user_num'>
                [{
            data:  <#if payUserNumSeries??>[${payUserNumSeries}]</#if>,
            name: '付费用户数'
        }]
        </#if>
        <#if field='free_user_num'>
                [{
            data: <#if freeUserNumSeries??>[${freeUserNumSeries}]</#if>,
            name: '免费用户数'
        }]
        </#if>
        <#if field='pv'>
                [{
            data: <#if pvSeries??>[${pvSeries}]</#if>,
            name: 'pv'
        }]
        </#if>
        <#if field='order_num'>
                [{
            data: <#if orderNumSeries??>[${orderNumSeries}]</#if>,
            name: '订单量'
        }]
        </#if>
        <#if (field='revenue' || field='crawl_time' || field='app_name')>
                [{
            data: <#if revenueSeries??>[${revenueSeries}]</#if>,
            name: '收入'
        }]
        </#if>
        });
    });
</script>