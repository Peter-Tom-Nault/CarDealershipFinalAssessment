$(document).ready(function() {
    //alert('addVehicle.js found!');
    populateModels();
    populateOptionals();
    populateVins();
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

function populateVins(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/home/Admin/Vehicles/0/10000/0/30000000/e',
        success: function(vehList){
            $.each(vehList, function(index, veh){
                $('#vin').append('<option>'+ veh.vin + '</option>')
            })

        }

    })
}

$('#submitButton').on('click', function() {
    var optionalIds = $('#optionals').val();
    var optionalJsons = [];
    $.each(optionalIds, function(index, option){
        var obj = JSON.parse('{"featureId": ' +option + '}');
        optionalJsons.push(obj);

    })
    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/home/admin/editVehicle/VIN',
        data: JSON.stringify({
            vin: $('#vin').val(),
            year: $('#year').val(),
            exteriorColor: $('#color').val(),
            interiorColor: $('#interior').val(),
            bodyType: $('#bodystyle').val(),
            transmission: $('#transmission').val(),
            msrp: $('#msrp').val(),
            salePrice: $('#salesprice').val(),
            photo: $('#model').val().id+".jpg",
            mileage: $('#mileage').val(),
            description: $('#message').val(),
            purchased: false,
            featured: $('.messageCheckbox:checked').val(),
            model: {
                id: $('#model').val()
            },
            optional: optionalJsons
        }),
       headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json'
       },
       success: function(){

       }
    })
})