$(document).ready(function () {


    var solsGrid = $('#grid-solicitations');
  
    function successCallback(response) {
        // do something with the data
        for (let index = 0; index < response.length; index++) {
      //var row = '<tr>';
        
      var grid = '<div class="card" style="width: 30rem;">';
      grid+= '<img src="img/decoy.jpeg" class="card-img-top" alt="...">'
      grid+= '<div class="card-body">';
     
      grid += '<h5 class="card-text" id="solicitation-id">'+'Solicitation id: ' +response[index].id+'</h5>';
      grid += '<h5 class="card-text" id="solicitation-text">'+response[index].description+'</h5>';


      grid += '</div>';  
      grid += '<a href="thanks.html" class="btn btn-primary">I want to help!</a>';

      
      grid += '</div>';
      solsGrid.append(grid);
    }
    
    }
    
    
    function errorCallback(request, status, error) {
        // do something with the error
    }
    
    // perform an ajax http get request
    $.ajax({
        url: 'http://localhost:8080/projectx/api/person/listsolicitations',
        async: true,
        success: successCallback,
        error: errorCallback
    });

      });
      function clickfun() {
      alert("OI");
    };