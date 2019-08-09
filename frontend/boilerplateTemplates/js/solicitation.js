$(document).ready(function () {

    console.log('document is ready!');
    
    $('#solicitation-form').click(function(event) {
        console.log('preventing default action of form submition!');
        event.preventDefault();
    })

    $('#button-solicitation').click(function(){
        
        console.log("is this happening? Pls help!");

        $.ajax({
           
            type: 'POST',
            url: 'http://localhost:8080/projectx/api/person/1/solicitation',
            data: JSON.stringify({
                description: $('#input-story').val(),
                type: 'BABYSOLICITATION',              
            }),
            async: true,
            contentType: 'application/json',
            dataType: 'json',
            success: getIdAndGo2,
            error: errorRegist2
        });
    });

    var personLoggedId = localStorage.getItem("personLoggedId");
    console.log(personLoggedId);

    var insertSolicitation = function () {
        /*console.log("Enviar para nova página html");*/


        if (document.getElementById("menuSelect").value === "BABYSOLICITATION") {

            var babyInsertion = `<div class="form-group" id="dropdown-choice">
            <div>
            <label for="formGroup-age">Child age</label>
            <input type="text" class="form-control" id="formGroup-age" placeholder="Child age">
            </div>
            <div class="form-group">
            <label for="formGroup-hours">Hours</label>
            <input type="text" class="form-control" id="formGroup-hours" placeholder="Hours">
            </div>
            <div class="form-group">
            <label for="formGroup-date">Date</label>
            <input type="text" class="form-control" id="formGroup-date" placeholder="Date">
            </div>
            </div>`;

            /*$(babyInsertion).appendTo("#dropdown-choice");*/
            $("#dropdown-choice").replaceWith(babyInsertion);
        }

        if (document.getElementById("menuSelect").value === "Counseling") {

            var counselInsertion = `<div class="form-group" id="dropdown-choice">
            <div>
            <label for="formGroup-age">Date</label>
            <input type="text" class="form-control" id="formGroup-date" placeholder="Date">
            </div>
            </div>`;

            /*$(counselInsertion).appendTo("#dropdown-choice");*/
            $("#dropdown-choice").replaceWith(counselInsertion);
        }

        if (document.getElementById("menuSelect").value === "Book") {

            var bookInsertion = `<div class="form-group" id="dropdown-choice">
            <div>
            <label for="formGroup-book">Book</label>
            <input type="text" class="form-control" id="formGroup-book" placeholder="Book's name">
            </div>
            </div>`;

            /*$(bookInsertion).appendTo("#dropdown-choice");*/
            $("#dropdown-choice").replaceWith(bookInsertion);
        }

        if (document.getElementById("menuSelect").value === "Clothes") {

            var clothesInsertion = `<div class="form-group" id="dropdown-choice">
            <label for="formGroup-clothes">Clothing item</label>
            <input type="text" class="form-control" id="formGroup-clothes" placeholder="Clothing item">
            </div>
            </div>`;

            /*$(clothesInsertion).appendTo("#dropdown-choice");*/
            $("#dropdown-choice").replaceWith(clothesInsertion);
        }

        if (document.getElementById("menuSelect").value === "Education") {

            var educationInsertion = `<div class="form-group" id="dropdown-choice">
            <div>
            <label for="formGroup-course">Course</label>
            <input type="text" class="form-control" id="formGroup-course" placeholder="Course">
            </div>
            <div class="form-group">
            <label for="formGroup-level">Grade</label>
            <input type="text" class="form-control" id="formGroup-level" placeholder="Grade">
            </div>
            <div class="form-group">
            <label for="formGroup-hours">Hours</label>
            <input type="text" class="form-control" id="formGroup-hours" placeholder="Hours">
            </div>
            <div class="form-group">
            <label for="formGroup-date">Date</label>
            <input type="text" class="form-control" id="formGroup-date" placeholder="Date">
            </div>
            </div>`;

            /*$(educationInsertion).appendTo("#dropdown-choice");*/
            $("#dropdown-choice").replaceWith(educationInsertion);
        }

    }

    function getIdAndGo2(){
        alert("nice");


    }

    function errorRegist2(){
        
    }

    var selection = $("#menuSelect");

    selection.change(insertSolicitation);
    var desc = "" + $('#babysitting').val() + $('#input-story').val() + $('#formGroup-age').val() + $('#formGroup-hours').val() + $('#formGroup-date').val();
    
    


});