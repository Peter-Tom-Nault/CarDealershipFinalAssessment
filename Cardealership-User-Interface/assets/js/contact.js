$(document).ready(function () {
 
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
    // check for validation errors; abort function if there are errors
    // var haveValidationErrors = checkAndDisplayValidationErrors(
    //   $("#addForm").find("input")
    // );

    // if (haveValidationErrors) {
    //   return false;
    // }

    // Ajax call to POST data to API service
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/home/contact",

      // format data in JSON
      data: JSON.stringify({
        firstName: "as",
        lastName: "demo",
        message: "demo",
        email: "demo",
        phone: 151550,
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

// clear Contact table prior to loading/updating data
function clearContactTable() {
  $("#contentRows").empty();
}

// open Edit Contact form and load data for selected record
function showEditForm(contactId) {
  $("#errorMessages").empty();

  $.ajax({
    type: "GET",
    url:
      "http://contactlist.us-east-1.elasticbeanstalk.com/contact/" + contactId,
    success: function (data, status) {
      $("#editFirstName").val(data.firstName);
      $("#editLastName").val(data.lastName);
      $("#editCompany").val(data.company);
      $("#editPhone").val(data.phone);
      $("#editEmail").val(data.email);
      $("#editContactId").val(data.contactId);
    },
    error: function () {
      $("#errorMessages").append(
        $("<li>")
          .attr({ class: "list-group-item list-group-item-danger" })
          .text("Error calling web service. Please try again later.")
      );
    },
  });

  // hide the table when the form is opened
  $("#contactTableDiv").hide();
  $("#editFormDiv").show();
}

// when closing the Edit form, empty all fields, hide the form, and show the table
function hideEditForm() {
  $("#errorMessages").empty();

  $("#editFirstName").val("");
  $("#editLastName").val("");
  $("#editCompany").val("");
  $("#editPhone").val("");
  $("#editEmail").val("");

  $("#contactTableDiv").show();
  $("#editFormDiv").hide();
}

// use a PUT request to update existing data
function updateContact(contactId) {
  $("#updateButton").click(function (event) {
    // check for errors and abort if errors are found
    var haveValidationErrors = checkAndDisplayValidationErrors(
      $("#editForm").find("input")
    );

    if (haveValidationErrors) {
      return false;
    }

    $.ajax({
      type: "PUT",
      url:
        "http://contactlist.us-east-1.elasticbeanstalk.com/contact/" +
        $("#editContactId").val(),

      // format the data in JSON
      data: JSON.stringify({
        contactId: $("#editContactId").val(),
        firstName: $("#editFirstName").val(),
        lastName: $("#editLastName").val(),
        company: $("#editCompany").val(),
        phone: $("#editPhone").val(),
        email: $("#editEmail").val(),
      }),
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      dataType: "json",
      success: function () {
        $("#errorMessage").empty();
        hideEditForm();
        loadContacts();
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

// delete record with corresponding contactId value
function deleteContact(contactId) {
  $.ajax({
    type: "DELETE",
    url:
      "http://contactlist.us-east-1.elasticbeanstalk.com/contact/" + contactId,
    success: function () {
      loadContacts();
    },
  });
}

// collect and display data validation error messages
function checkAndDisplayValidationErrors(input) {
  $("#errorMessages").empty();

  var errorMessages = [];

  // generate specific message using form label and browser-generated errors messages
  input.each(function () {
    if (!this.validity.valid) {
      var errorField = $("label[for=" + this.id + "]").text();
      errorMessages.push(errorField + " " + this.validationMessage);
    }
  });

  // display messages in #errorMessages div
  if (errorMessages.length > 0) {
    $.each(errorMessages, function (index, message) {
      $("#errorMessages").append(
        $("<li>")
          .attr({ class: "list-group-item list-group-item-danger" })
          .text(message)
      );
    });
    // return true, indicating that there were errors
    return true;
  } else {
    // return false, indicating that there were no errors
    return false;
  }
}