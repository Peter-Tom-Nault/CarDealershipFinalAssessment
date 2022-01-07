$(document).ready(function() {
    // alert('addVehicle.js found!');
    populateVins();
    populateSalespeople();
});
var today = new Date();

function populateVins(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/home/Sales/Index/0/10000/0/30000000',
        success: function(vehList){
            $.each(vehList, function(index, veh){
                $('#vin').append('<option>'+ veh.vin + '</option>')
            })

        }

    })
}

function populateSalespeople(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/home/admin/users',
        success: function(salesPersonList){
            $.each(salesPersonList, function(index, sp){
                $('#salesPersonId').append('<option value= "' + sp.userId + '">' + sp.userName +'</option>')
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
            vehicle: {
                vin: $('#vin').val()
            },
            date: $('#date').val(),
            custumerName: $('#name').val(),
            phone: $('#phone').val(),
            email: $('#email').val(),
            streetAddress: $('#street1').val() +$('#street2').val(),
            city: $('#city').val(),
            state: $('#state').val(),
            zip: $('#zip').val(),
            purchasePrice: $('#purchasePrice').val(),
            purchaseType: $('#purchaseType').val(),
            salespersonId: $('#salesPersonId').val()
        }),
       headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json'
       },
       success: function(){

       }
    })
})