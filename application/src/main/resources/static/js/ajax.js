function submitUserForm() {
    var user = {
        firstName : $("#firstName").val(),
        secondName : $("#secondName").val(),
        email : $("#email").val(),
        gender: $("#gender").val()
    };
    var formData = JSON.stringify(user);
    console.log(formData);
    $.ajax({
        type: "POST",
        url: "/user",
        data: formData,
        success: function(){},
        dataType: "json",
        contentType : "application/json"
    });
}

function submitQuestionForm() {

}