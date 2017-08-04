// JavaScript source code
//document.write('<script src="js/jquery-3.1.1.js" type="text/javascript"></script>')
//$(function () {
//    alert("Hello, jQuery!");
//});
$(function()
{
    $("tr:even").css("background-color", "#cccccc");
    $("tr").click(function()
    {
        alert("tr clicked!");
    })
    $("tr").mouseover(function()
    {
        $(this).css("background-color", "blue");
    })
    $("tr").mouseout(function () {
        $("tr:odd").css("background-color", "white");
        $("tr:even").css("background-color", "#cccccc");
    })
    $("#btnAjax").click(onbtnAjax_click);
})

function onStateChange(data, status) {
    if (status == "success") {
        var users = JSON.parse(data);
        $("#p1").html(users.users[0].signInName + ", " + users.users[0].password);
        $("#p1").css("font-size", "30px");
        $("#p1").css("color", "red");
    }
}

function onbtnAjax_click()
{
    $.get("http://localhost:8080/WebApp/DeptServlet", onStateChange);
}