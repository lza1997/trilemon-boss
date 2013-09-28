<#import "../spring-ext.ftl" as ext>

<div class="page-header row" xmlns="http://www.w3.org/1999/html">
    <h3>执行 job</h3>
</div>

<div class="row tb">
    <form name="job-form" action="${requestContext.getContextPath()}/jobs" method="post">
        <input type="hidden" name="action" value="redo">
        <input type="hidden" name="startDate">
        <input type="hidden" name="endDate">
    <@ext.csrf/>

        <div class="col-md-3" id="job-category" hidden="true">
            <select id="job-selectpicker" class="show-tick show-menu-arrow" name="job"
                    data-width="170px" data-show-subtext="true">
                <option value="请选择一个任务">请选择一个任务</option>
                <option data-divider="true"></option>
                <option value="calcAppStat" <#if (job?? && job="calcAppStat")>selected</#if>>calcAppStat</option>
                <option value="calcMarketStat" <#if (job?? && job="calcMarketStat")>selected</#if>>calcMarketStat
                </option>
            </select>
        </div>

        <div class="col-md-4">
            <button type="button" id="job-daterange" class="btn btn-default dropdown-toggle daterange"
                    data-toggle="dropdown">
                <span class="glyphicon glyphicon-calendar"></span>
                &nbsp;<span id="job-daterange-fill-span">开始日期 - 结束日期</span>&nbsp;
                <span class="caret"></span>
            </button>
        </div>

        <div class="col-md-3">
            <button type="submit" class="btn btn-default">执行</button>
        </div>
    </form>
</div>