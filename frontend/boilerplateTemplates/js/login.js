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
})
