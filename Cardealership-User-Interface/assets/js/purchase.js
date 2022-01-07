$(document).ready(function() {
    // alert('addVehicle.js found!');
    populateVehicle();
  });


function populateModels(){
    $('#model').empty();

    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/home/Sales/Purchase',
        success: function(modelList){
            $.each(modelList, function(index, model){
                $('#model').append('<option value="'+ model.id+'">' +model.manufacturer.manufacturerName +' '+ model.modelName + ' ' + model.trim +'</option>');
            })

        },
        error: function() {
            
        }
    })
    
}

function populateVehicle(){

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/home/Sales',
        success: function(optionalList){
            $.each(optionalList, function(index, optionalFeat){
                $('#optionals').append('<option value="' + optionalFeat.featureId+'">'+optionalFeat.name+'</option>')
            })
        }
    })
    
}

$('#saveBtn').on('click', function() {
    newModel = $('#model').val();
    optFeat = $('#optionals').val();
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/home/Sales/Purchase',
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
            optional: optFeat,
            custumerName: $('name').val(),
            phone: $('phone').val(),
            email: $('email').val(),
            streetAddress: $('street1').val() +$('street2').val(),
            city: $('city').val(),
            state: $('state').val(),
            zip: $('zip').val(),
            purchasePrice: $('purchasePrice').val(),
            purchaseType: $('purchaseType').val(),
            salespersonId: $('salesPersonId').val()
        }),
       headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json'
       },
       success: function(){

       }
    })
})