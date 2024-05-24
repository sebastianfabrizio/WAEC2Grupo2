$(document).on("click", ".btnnuevo", function () {
    $("#modalespecilidad").modal("show");
    $("#txtidespecilidad").val("0");
    $("#txttitulo").val("");
    $("#txtfuncion").val("");
    $("#txtfechgraduacion").val("dd-MM-yyyy");
    $("#cbomedico").empty();
    cargarComboMedicos(0);
});

