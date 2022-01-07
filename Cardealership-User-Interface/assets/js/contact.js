$(document).ready(function () {
 alert("Hello! I am an alert box!!");
  addContact();
 
});

// load contacts from REST API service to an HTML table
function loadContacts() {
  clearContactTable();
  var contentRows = $("#contentRows");

  // retrieve and display existing data using GET request
  $.ajax({
    type: "GET",
    url: "http://contactlist.us-east-1.elasticbeanstalk.com/contacts",
    success: function (contactArray) {
      $.each(contactArray, function (index, contact) {
        //retrieve and store the values
        var name = contact.firstName + " " + contact.lastName;
        var company = contact.company;
        var contactId = contact.contactId;

        // build a table using the retrieved values
        var row = "<tr>";
        row += "<td>" + name + "</td>";
        row += "<td>" + company + "</td>";
        row +=
          '<td><button type="button" class="btn btn-info" onclick="showEditForm(' +
          contactId +
          ')">Edit</button></td>';
        row +=
          '<td><button type="button" class="btn btn-danger" onclick="deleteContact(' +
          contactId +
          ')">Delete</button></td>';
        row += "</tr>";

        contentRows.append(row);
      });
    },

    // create error function to display API error messages
    error: function () {
      $("#errorMessages").append(
        $("<li>")
          .attr({ class: "list-group-item list-group-item-danger" })
          .text("Error calling web service. Please try again later.")
      );
    },
  });
}

// create function to collect data from #addForm and post it to the API service
function addContact() {
  $("#submitbutton").click(function (event) {
    alert("button clicked");
    // Ajax call to POST data to API service
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/home/Contact",

      // format data in JSON
      data: JSON.stringify({
        firstName: '$("#addFirstName").val()',
        lastName:,' $("#addLastName").val()'
        email: '$("#addCompany").v'al(')',
        message: '$("#addEmail").val()',
        phone: '$("#addPhone").val()',
      }),
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      dataType: "json",
      success: function () {
        $("#errorMessages").empty();
        $("#firstName").val("");
        $("#lastName").val("");
        $("#email").val("");
        $("#subject").val("");
        $("#message").val("");
  
      },
      error: function () {
        $("#errorMessages").append(
          $("<li>")
            .attr({ class: "list-group-item list-group-item-danger" })
            .text("Error calling web service. Please try again later.")
        );
      },
    });
  });
}


