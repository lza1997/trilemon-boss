$(function () {
    $('.trilemon-shelf-plan-setting .new .item-filter-box input:radio').change(function () {
        var changeRadioName = $(this).attr("id");

        $('.trilemon-shelf-plan-setting .new .item-filter-box').each(function () {
            if ($(this).find("input:radio")[0].id === changeRadioName) {
                $(this).removeClass("text-muted");
                $(this).find(".filter").removeAttr("disabled");
                $(this).css("background-color", "#EAEAEA");
            } else {
                $(this).addClass("text-muted");
                $(this).find(".filter").attr("disabled", "disabled");
                $(this).css("background-color", "");
            }
        });
    });

    $('.trilemon-shelf-plan-setting .new .adjust-intervals-box input:radio').change(function () {
        var changeRadioName = $(this).attr("id");

        $('.trilemon-shelf-plan-setting .new .adjust-intervals-box').each(function () {
            if ($(this).find("input:radio")[0].id === changeRadioName) {
                $(this).removeClass("text-muted");
                $(this).find(".filter").removeAttr("disabled");
                $(this).css("background-color", "#EAEAEA");
            } else {
                $(this).addClass("text-muted");
                $(this).find(".filter").attr("disabled", "disabled");
                $(this).css("background-color", "");
            }
        });
    });

    $(".item-big-pic").popover({
        trigger: "hover",
        html:true
    });

    $("[data-toggle=dropdown]").dropdown();
    $("[data-toggle=button]").button();

    $('.dropdown-menu input, .dropdown-menu label,.dropdown-menu a').click(function(e) {
        e.stopPropagation();
    });

    $('#myTab a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })
});
