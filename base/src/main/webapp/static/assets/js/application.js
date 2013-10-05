$('.pagination .disabled a').on('click', function (e) {
    e.preventDefault();
});

moment.lang('zh-cn');

$('#app-daterange').daterangepicker({
        format: 'YYYY/MM/DD',
        showDropdowns: true,
        startDate: $('form[name="app-form"] input:hidden[name="startDate"]').val(),
        endDate: $('form[name="app-form"] input:hidden[name="endDate"]').val(),
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
        $('#app-daterange-fill-span').html(start.format('YYYY/MM/DD') + ' - ' + end.format('YYYY/MM/DD'));
        $('form[name="app-form"] input:hidden[name="startDate"]').val(start.format('YYYY/MM/DD'));
        $('form[name="app-form"] input:hidden[name="endDate"]').val(end.format('YYYY/MM/DD'));
        $('form[name="app-form"] input:hidden[name="pageNum"]').val(1);
        $("form[name='app-form']").submit();
    });

$('#first-category-selectpicker').selectpicker();
$('#app-category').show();


$('#first-category-selectpicker').bind('change', function () {
    $('form[name="app-form"] input:hidden[name="firstCategorySelected"]').val($(this).val());
    $('form[name="app-form"] input:hidden[name="secondCategorySelected"]').val("全部子类目");
    $('form[name="app-form"] input:hidden[name="pageNum"]').val(1);
    $('form[name="app-form"]').submit();
});

$('#second-category-selectpicker').selectpicker();

$("#second-category-selectpicker").bind('change', function () {
    $('form[name="app-form"] input:hidden[name="secondCategorySelected"]').val($(this).val());
    $('form[name="app-form"] input:hidden[name="pageNum"]').val(1);
    $('form[name="app-form"]').submit();
});

$('.sortable').bind('click', function () {
    var sort = $('form[name="app-form"] input:hidden[name="sort"]').val();
    if (sort === "desc") {
        sort = 'asc';
    } else {
        sort = 'desc';
    }
    $('form[name="app-form"] input:hidden[name="field"]').val($(this).attr('data-app-attr'));
    $('form[name="app-form"] input:hidden[name="sort"]').val(sort);
    $('form[name="app-form"] input:hidden[name="pageNum"]').val(1);
    $('form[name="app-form"]').submit();
});

$('.pagination a').bind('click', function () {
    $('form[name="app-form"] input:hidden[name="pageNum"]').val($(this).attr('data-page-num'));
    $('form[name="app-form"]').submit();
});

//job page
$('#job-daterange').daterangepicker({
        format: 'YYYY/MM/DD',
        showDropdowns: true,
        startDate: moment().subtract('days', 1),
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
        $('#job-daterange-fill-span').html(start.format('YYYY/MM/DD') + ' - ' + end.format('YYYY/MM/DD'));
        $('form[name="job-form"] input:hidden[name="startDate"]').val(start.format('YYYY/MM/DD'));
        $('form[name="job-form"] input:hidden[name="endDate"]').val(end.format('YYYY/MM/DD'));
        $('form[name="job-form"] input:hidden[name="job"]').val(1);
    });

$('#job-selectpicker').selectpicker();
$('#job-category').show();

$('#job-selectpicker').bind('change', function () {
    $('form[name="job-form"] input:hidden[name="job"]').val($(this).val());
});
