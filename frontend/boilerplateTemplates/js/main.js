$(document).ready(function () {

    var start = function () {
        console.log("Enviar para nova página html");
        window.location = "/Users/codecadet/Workspace/Hackathon/frontend/boilerplateTemplates/choicePage.html"
    }

    var nextButton = $("#enterButton");

    nextButton.click(start);

})