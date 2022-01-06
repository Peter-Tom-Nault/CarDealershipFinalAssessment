$(document).ready(function() {});

var $results = $('#searchResultULitems');

$(function(){
    $('#searchButton1').click(function (event))
    {
      $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/inventory/',
        success: function(results) {
          $.each(results, function(result) {
            $results.append(
                '<li>year: ' + result.year + ', make: ' + result.make +
                ', model: ' + result.model + ', img: ' + result.img +
                ', body style: ' + result.bodyStyle +
                ', Trans: ' + result.trans + ', Color: ' + result.color +
                ', Interior: ' + result.interior +
                ', Mileage: ' + result.mileage + ', VIN#: ' + result.vin +
                ', Sale Price: ' + result.salePrice + ', MSRP: ' + result.msrp +

                '</li>');
          });
        }
      });
    }
});