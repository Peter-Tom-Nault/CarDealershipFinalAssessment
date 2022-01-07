$(document).ready(function() {
    populateSpecials();
    populateFeatured();
   });


function populateSpecials(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/home/Specials',
        'dataType': 'json',
        success: function(SpecialOffers){
            //make them scroll through jumbotron? idk how to do that, might just display them all? I'm not good at HTML - PT

        }
    })

}

function populateFeatured(){
    $('#featured').empty();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/home/index',
        'dataType': 'json',
        success: function(featuredVehicles){

            $.each(featuredVehicles, function(index, featVeah){
                model = featVeah.model;
                
                var htmlToAdd = '<div class="col-lg-4 py-3">'+
                '<div class="card-blog">'+
                  '<div class="header">'+
                    '<div class="post-thumb">'+
                      '<img src="../../assets/img/vehicles/'+model.id+'.png" alt="vehicles img">'+
                    '</div>'+
                  '</div>'+
                  '<div class="body">'+
                    '<h5 class="post-title"><a href="blog-details.html">'+ model.manufacturer.manufacturerName +' '+ model.modelName + ' ' + model.trim +'</a></h5>'+
                    '<div class="post-date">MSRP <a href="#">'+ featVeah.msrp+'</a></div>'+
                  '</div>'+
                '</div>'+
              '</div>';
                $('#featured').append(htmlToAdd);
            })
            
        

        }
    })
}