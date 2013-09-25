<div class="opt-sidebar hidden-print" role="complementary">
    <ul class="nav opt-sidenav">
        <li <#if (nav?? && nav='search')>class="active"</#if>>
            <div id="isv-search-box">
                <input type="text" class="form-control" id="isv-search" placeholder="搜索应用、isv、服务编号">
            </div>
        </li>
        <li <#if (nav?? && nav='apps')>class="active"</#if>>
            <a href="${base}/apps">应用</a>
        </li>
        <li <#if nav='markets'>class="active"</#if>>
            <a href="${base}/markets">市场</a>
        </li>
        <li <#if nav='jobs'>class="active"</#if>>
            <a href="${base}/jobs">定时计划</a>
        </li>
    </ul>
</div>
<script src="${base}/static/typeahead.min.js"></script>
<script src="${base}/static/hogan-2.0.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#isv-search').typeahead({
            remote: '${base}/apps/typehead?query=%QUERY',
            template: ['<h5>{{appName}}</h5>'
            ].join(''),
            valueKey: 'appName',
            limit: 10,
            engine: Hogan
        });

        $('#isv-search').bind('typeahead:selected', function (obj, datum) {
            window.location = '${base}/apps/' + datum.serviceCode
        });
        $('#isv-search').bind('typeahead:autocompleted', function (obj, datum) {
            window.location = '${base}/apps/' + datum.serviceCode
        });

        $('#isv-search').keyup(function (event) {
            if (event.keyCode == 13) {
                window.location = '${base}/apps/search?query=' + $(this).val()
            }
        });
    });
</script>