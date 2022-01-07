$(document).ready(function() {
    // alert('addVehicle.js found!');
});
var today = new Date();

$('#saveBtn').on('click', function() {
    newModel = $('#model').val();
    optFeat = $('#optionals').val();
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/home/Sales/Purchase',
        data: JSON.stringify({
            vin: $('#vin').val(),
            date: $('date').val(),
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