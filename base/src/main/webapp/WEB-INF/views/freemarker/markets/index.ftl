<div class="page-header row" xmlns="http://www.w3.org/1999/html">
    <h3>市场</h3>
</div>

<div class="pull-right">
    <button id="market-daterange" type="button" class="pull-left btn btn-default dropdown-toggle daterange"
            data-toggle="dropdown">
        <span class="glyphicon glyphicon-calendar"></span>
        &nbsp;<span id="market-daterange-fill-span">${startDate} - ${endDate}</span>&nbsp;
        <span class="caret"></span>
    </button>
</div>

<div id="isv-chart" class="page-header" xmlns="http://www.w3.org/1999/html">
    <h4>ISV和服务数量</h4>
</div>
<div id="numChart" style="height: 250px"></div>

<div class="page-header " xmlns="http://www.w3.org/1999/html">
    <h4>订单量</h4>
</div>
<div id="orderNumChart" style="height: 250px"></div>

<div class="page-header" xmlns="http://www.w3.org/1999/html">
    <h4>收入</h4>
</div>
<div id="revenueChart" style="height: 250px"></div>

<script type="text/javascript">
    $(function () {
        $('#market-daterange').daterangepicker({
                    format: 'YYYY/MM/DD',
                    showDropdowns: true,
                    startDate: moment().subtract('days', 7),
                    endDate: moment().subtract('days', 1),
                    opens: "left",
                    ranges: {
                        '昨天': [moment().subtract('days', 1), moment().subtract('days', 1)],
                        '过去7天': [moment().subtract('days', 7), moment().subtract('days', 1)],
                        '过去30天': [moment().subtract('days', 30), moment().subtract('days', 1)],
                        '上周': [moment().subtract('week', 1).startOf('week'), moment().subtract('week', 1).endOf('week')],
                        '上月': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
                    },
                    locale: {
                        applyLabel: '确认',
                        cancelLabel: '取消',
                        fromLabel: '开始',
                        toLabel: '结束',
                        weekLabel: 'W',
                        customRangeLabel: '自定义',
                        daysOfWeek: moment()._lang._weekdaysMin.slice(),
                        monthNames: moment()._lang._monthsShort.slice(),
                        firstDay: 1
                    }
                },
                function (start, end) {
                    $('#market-daterange-fill-span').html(start.format('YYYY/MM/DD') + ' - ' + end.format
                            ('YYYY/MM/DD'));
                    loadMarketChart("${requestContext.getContextPath()}", moment(start).format("YYYYMMDD"),
                            moment(end).format("YYYYMMDD"));
                });
        var numChart = Morris.Line({
            element: 'numChart',
            xkey: 'period',
            ykeys: ['isvNum', 'fuwuNum', 'appNum'],
            lineColors: ['#058DC7', '#ED7E17', '#50B432', '#AF49C5', '#EDEF00', '#8080FF', '#A0A424'],
            labels: ['isv数量', '服务数量', '服务数量（除去非在线App业务））'],
            lineWidth: 2,
            xLabels: 'day'
        });

        var orderNumChart = Morris.Line({
            element: 'orderNumChart',
            xkey: 'period',
            ykeys: ['orderNum', 'orderNumExcludeTaobao'],
            lineColors: ['#058DC7', '#ED7E17', '#50B432', '#AF49C5', '#EDEF00', '#8080FF', '#A0A424'],
            labels: ['订单量', '订单量（排除淘宝服务）'],
            lineWidth: 2,
            xLabels: 'day'
        });

        var revenueChart = Morris.Line({
            element: 'revenueChart',
            xkey: 'period',
            ykeys: ['revenue', 'revenueExcludeTaobao'],
            lineColors: ['#058DC7', '#ED7E17', '#50B432', '#AF49C5', '#EDEF00', '#8080FF', '#A0A424'],
            labels: ['收入', '收入（排除淘宝服务）'],
            lineWidth: 2,
            xLabels: 'day'
        });

        function loadMarketChart(contextPath, startDate, endDate) {
            $.getJSON(contextPath + "/markets/num", {
                startDate: startDate,
                endDate: endDate
            }).done(function (data) {
                        numChart.setData(data);
                    }).fail(function () {
                        alert("获取数据失败");
                    });

            $.getJSON(contextPath + "/markets/orderNum", {
                startDate: startDate,
                endDate: endDate
            }).done(function (data) {
                        orderNumChart.setData(data);
                    }).fail(function () {
                        alert("获取数据失败");
                    });
            $.getJSON(contextPath + "/markets/revenue", {
                startDate: startDate,
                endDate: endDate
            }).done(function (data) {
                        revenueChart.setData(data);
                    }).fail(function () {
                        alert("获取数据失败");
                    });
        }

        loadMarketChart("${requestContext.getContextPath()}", moment("${startDate}", "YYYY/MM/DD").format("YYYYMMDD"),
                moment("${endDate}", "YYYY/MM/DD").format("YYYYMMDD"));
    });
</script>
<script src="${requestContext.getContextPath()}/static/morris/morris.min.js"></script>
<script src="${requestContext.getContextPath()}/static/raphael-min.js"></script>