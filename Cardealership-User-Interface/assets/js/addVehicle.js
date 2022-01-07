$(document).ready(function() {
    //alert('addVehicle.js found!');
    populateModels();
    populateOptionals();
  });


function populateModels(){
    $('#model').empty();

    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/home/admin/model',
        success: function(modelList){
            $.each(modelList, function(index, model){
                $('#model').append('<option value="'+ model.id+'">' +model.manufacturer.manufacturerName +' '+ model.modelName + ' ' + model.trim +'</option>');
            })

        },
        error: function() {
            
        }
    })
    
}

function populateOptionals(){
    
}