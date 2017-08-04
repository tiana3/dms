/**
 * Created by aa on 2016/11/30 0030.
 */

    function ondoc_ready()
    {
        alert("Hello, my document!");
    }

// $(document).ready(ondoc_ready());
// $(document).ready(function(){alert("Hello, jQuery!");});
// $(function(){alert("Hello, jQuery!");})

function onbody_load()
{
    document.getElementById("p1").innerHTML = "Hello, ID Selector!";
    document.getElementById("p1").style.color = "red";
}

$(function()
{
    $("#p1").html("Hello, ID Selector!");
    $("#p1").css("color", "red");

    $("#btnVisable").click(function()
    {
        $(".vorhClass:hidden").css("display", "block");
    });

    $("#btnHide").click(function()
    {
        $(".vorhClass:visible").css("display", "none");
    })

    $.get("http://localhost:8080/UserManager/Regions", function (data, status)
    {
        if (status == "success")
        {
            var provinces = JSON.parse(data);
            var provinceSelector = document.getElementById("provinces");
            for (var i = 0; i < provinces.length; i++)
            {
                var option = new Option();
                option.value = provinces[i].id;
                option.text = provinces[i].name;
                provinceSelector.add(option);
            }
        }
    })

    $("#btnAjax").click(function()
    {
        alert("Ajax button is clicked!");
    });
    //$("p").css("font-size", "5px");
    //$(".txtClass").css("font-size", "30px");
    //$("#impt").css("color", "red");
    //$("p,.oddli").css("background-color", "#ccc");
    //$("ul .oddli").css("background-color", "#ccc");
    $(".imptClass").css("color", "red");
    //$("#p3 .imptClass").css("color", "blue");
    //$("#li1+li").css("background-color", "#ccc");
    //$("#li1~li").css("background-color", "#ccc");
    //$("[id!='li1'][id!='mainBody']").css("background-color", "blue");
    $("[src$='.gif']").css("border", "solid");
    //$("li:odd").css("background-color", "#ccc");
    $("li:not(:odd)").css("background-color", "#ccc");
    //$("li:first").css("background-color", "#ccc");
    //$("li:eq(3)").css("background-color", "#ccc");
    //$("li:lt(3)").css("background-color", "#ccc");
})

function onbtnAjax_click()
{
    alert("Ajax button is clicked!");
}
