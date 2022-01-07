$(document).ready(function() {
 // alert('newinventory.js found!');
});

var $results = $('#searchResultULitems');

$('#searchButton1').on('click', function() {
  yearMakeModel= $('#makeModel').val(),
      minPrice= $('#minprice').val(),
      maxPrice= $('#maxprice').val(),
      minYear= $('#minYr').val(),
      maxYear= $('#maxYr').val()

  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/home/inventory/new/' + minYear.toString() + '/' + maxYear.toString() + '/' + minPrice.toString() + '/' + maxPrice.toString() + '/' + + yearMakeModel,
    //data: JSON.stringify({
     // yearModelMake: $('#makeModel').val(),
     // minPrice: $('#minprice').val(),
    //  maxPrice: $('#maxprice').val(),
     // minYear: $('#minYr').val(),
     // maxYear: $('#maxYr').val()
    //}),
    //headers: {'Accept': 'application/json', 'Content-type': 'application/json'},
    'dataType': 'json',
    success: function(results) {
      $.each(results, function(result) {
        /*$results.append(
            '<li>year: ' + result.year + ', make: ' + result.make +
            ', model: ' + result.model + ', img: ' + result.img +
            ', body style: ' + result.bodyStyle + ', Trans: ' + result.trans +
            ', Color: ' + result.color + ', Interior: ' + result.interior +
            ', Mileage: ' + result.mileage + ', VIN#: ' + result.vin +
            ', Sale Price: ' + result.salePrice + ', MSRP: ' + result.msrp +

            '</li>');*/
            //need to append each result to list
      })
      //display list that is to hold results
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
