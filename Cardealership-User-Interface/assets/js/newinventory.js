$(document).ready(function() {
  alert('newinventory.js found!');
});

var $results = $('#searchResultULitems');

$('#searchButton1').on('click', function() {
  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/inventory/new',
    data: JSON.stringify({
      yearModelMake: $('#makeModel').val(),
      minPrice: $('#minPrice').val(),
      maxPrice: $('#maxPrice').val(),
      minYear: $('#minYear').val(),
      maxYear: $('#maxYear').val()
    }),
    headers: {'Accept': 'application/json', 'Content-type': 'application/json'},
    'dataType': 'json',
    success: function(results) {
      $.each(results, function(result) {
        $results.append(
            '<li>year: ' + result.year + ', make: ' + result.make +
            ', model: ' + result.model + ', img: ' + result.img +
            ', body style: ' + result.bodyStyle + ', Trans: ' + result.trans +
            ', Color: ' + result.color + ', Interior: ' + result.interior +
            ', Mileage: ' + result.mileage + ', VIN#: ' + result.vin +
            ', Sale Price: ' + result.salePrice + ', MSRP: ' + result.msrp +

            '</li>');
      })
    },
    error: function() {
      $('#errorMessages')
          .append(
              $('<li>')
                  .attr({class: 'list-group-item list-group-item-danger'})
                  .text('Error calling web service. Please try again later.'));
    }
  })
})
