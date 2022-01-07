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

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/home/admin/option',
        success: function(optionalList){
            $.each(optionalList, function(index, optionalFeat){
                $('#optionals').append('<option value="' + optionalFeat.featureId+'">'+optionalFeat.name+'</option>')
            })
        }
    })
    
}

$('#addButton').on('click', function() {
    newModel = $('#model').val();
    optFeat = $('#optionals').val();
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/home/Admin/AddVehicle',
        data: JSON.stringify({
            vin: $('#vin').val(),
            year: $('#year').val(),
            exteriorColor: $('#color'),
            interiorColor: $('#interior'),
            bodyType: $('#bodystyle'),
            transmission: $('#transmission'),
            msrp: $('#msrp'),
            salePrice: $('#salesprice'),
            photo: newModel.id+".jpg",
            mileage: $('#mileage'),
            description: $('#message'),
            purchased: false,
            featured: false,
            model: newModel,
            optional: optFeat
        }),
       headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json'
       },
       success: function(){

       }
    })
})