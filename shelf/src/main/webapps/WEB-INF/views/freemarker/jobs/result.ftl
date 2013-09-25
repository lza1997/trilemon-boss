<div class="page-header row" xmlns="http://www.w3.org/1999/html">
    <h3>job 执行情况</h3>
</div>
<div class="row">
    <table class="table">
        <thead>
        <tr>
            <th>job</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>状态</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${job}</td>
            <td>${startDate}</td>
            <td>${endDate}</td>
        <#if result.code=="001">
            <td><span class="label label-success">${result.msg}</span></td>
        </#if>
        <#if result.code=="002">
            <td><span class="label label-danger">${result.msg}</span></td>
        </#if>
        <#if result.code=="003">
            <td><span class="label label-default">${result.msg}</span></td>
        </#if>
        </tr>
        </tbody>
    </table>
</div>

