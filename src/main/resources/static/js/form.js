$().ready(function () {
  $("#form").validate({
    errorClass: "errors",
    rules: {
      nom: "required",
      prenom: "required",
      email: {
        required: true,
        email: true,
      },
      numero: {
        required: true,
        minlength: 8,
        maxlength: 8,
        number: true,
      },
      produit: {
        required: true,
      },
    },
  });
});
