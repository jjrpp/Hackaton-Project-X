$(document).ready(function () {

    var insert = function () {

        if(document.getElementById("loginSelect").value === "Login") {

            var idInsertion = `<div class="form-group" id="dropdown-choice">
            <div>
            <label for="formGroup-age">Id</label>
            <input type="text" class="form-control" id="formGroup-id" placeholder="Id">
            </div>
            </div>`;

            /*$(babyInsertion).appendTo("#dropdown-choice");*/
            $("#dropdown-choice").replaceWith(idInsertion);
        }

        if (document.getElementById("loginSelect").value === "Register") {

            var registerInsertion = `<div class="form-group" id="dropdown-choice">
            <div>
            <label for="formGroup-firstName">First Name</label>
            <input type="text" class="form-control" id="formGroup-firstName" placeholder="First Name">
            </div>
            <div>
            <label for="formGroup-lastName">Last Name</label>
            <input type="text" class="form-control" id="formGroup-lastName" placeholder="Last Name">
            </div>
            <div>
            <label for="formGroup-email">Email</label>
            <input type="text" class="form-control" id="formGroup-email" placeholder="Email">
            </div>
            <div>
            <label for="formGroup-phone">Phone Number</label>
            <input type="text" class="form-control" id="formGroup-phone" placeholder="Phone Number">
            </div>
            </div>`;

            /*$(counselInsertion).appendTo("#dropdown-choice");*/
            $("#dropdown-choice").replaceWith(registerInsertion);
           
        }

    }

    var selection = $("#loginSelect");

    selection.change(insert);

    $('#loginButton').click(function(){
        doLogin($('#formGroup-id').val());
    });

    function doLogin(id) {

        personLoggedInId = id;
        console.log(personLoggedInId);
        localStorage.setItem("personLoggedId", personLoggedInId);
        /*window.location.href("/Users/codecadet/Workspace/Hackathon/frontend/boilerplateTemplates/solicitation.html");*/
    };

    $('#registerButton').click(function(){
        doRegister();
    });

    function doRegister () {
        regist();

    }

    function getLastId (response) {

        var index = response.length-1;
        var personLoggedId = Object.values(response[index])[0];
        localStorage.setItem("personLoggedId", personLoggedId);
    }

    function getIdAndGo (response){

        $.ajax({
            url: 'http://localhost:8080/projectx/api/person',
            type: 'GET',
            async: true,
            success: getLastId,
            error: errorGetList
        })

    }

    function errorRegist () {

    }

    function regist () {
        $.ajax({
            url: 'http://localhost:8080/projectx/api/person',
            type: 'POST',
            data: JSON.stringify({
                firstName: $('#formGroup-firstname').val(),
                lastName: $('#formGroup-lastname').val(),
                email: $('#formGroup-email').val(),
                phone: $('#formGroup-phone').val()
            }),
            async: true,
            contentType: 'application/json',
            success: getIdAndGo,
            error: errorRegist
        })
        ;
    }
    

    
})
