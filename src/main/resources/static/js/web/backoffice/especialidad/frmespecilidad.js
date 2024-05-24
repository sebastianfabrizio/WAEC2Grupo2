$(document).on("click", ".btnnuevo", function () {
    $("#modalespecilidad").modal("show");
    $("#txtidespecilidad").val("0");
    $("#txttitulo").val("");
    $("#txtfuncion").val("");
    $("#txtfechgraduacion").val("dd-MM-yyyy");
    $("#cbomedico").empty();
    cargarComboMedicos(0);
});

$(document).on("click",".btnguardar", function () {

    $.ajax({
        type: "POST",
        url: "/especialidad/home",
        contentType: "application/json",
        data: JSON.stringify({
            idespecialidad: $("#txtidespecilidad").val(),
            titulo: $("#txttitulo").val(),
            funcion: $("#txtfuncion").val(),
            fechgraduacion: $("#txtfechgraduacion").val(),
            idmedico: $("#cbomedico").val()
        }),
        success : function (resultado) {
            if(resultado.resultado) {
                alert(resultado.mensaje);
                listarMedicos();
            }else {
                alert(resultado.mensaje);
            }
            $("#modalespecilidad").modal("hide");
        }
    });

});

$(document).on("click", ".btnactualizar", function () {

    $.ajax({
        type: "GET",
        url: "/especialidad/especialidad/" + $(this).attr("data-idespecialidad"),
        dataType: "json",
        success: function (resultado) {
            $("#txtidespecilidad").val(resultado.idespecialidad);
            $("#txttitulo").val(resultado.titulo);
            $("#txtfuncion").val(resultado.funcion);
            $("#txtfechgraduacion").val(resultado.fechgraduacion);
            $("#cbomedico").val(resultado.idmedico);
            cargarComboMedicos(resultado.idmedico)
            $("#modalespecilidad").modal("show");
        }
    });

});

function listarMedicos() {
    $.ajax({
        type: "GET",
        url: "/especialidad/list",
        dataType: "json",
        success: function (resultado) {
            $("#tbespecialidad > tbody").html("");
            $.each(resultado, function (index, value) {
                $("#tbespecialidad > tbody").append(
                    `<tr>
                        <td>${value.idespecialidad}</td>
                        <td>${value.titulo}</td>
                        <td>${value.funcion}</td>
                        <td>${value.fechgraduacion}</td>
                        <td>${value.medico.nommedico}</td>
                        <td>
                            <button class="btn btn-info btnactualizar"
                                    data-idespecialidad="${value.idespecialidad}">Actualizar</button>
                        </td>
                    </tr>`
                )
            })
        }
    });
}

function cargarComboMedicos(idmedico) {
    $.ajax({
        type: "GET",
        url: "/especialidad/medico",
        dataType: "json",
        success: function (resultado) {
            $.each(resultado, function (index, value) {
                $("#cbomedico").append(
                    `<option value="${value.idmedico}">${value.nommedico}</option>`
                )
            });
            if(idmedico > 0) {
                $("#cbomedico").val(idmedico);
            }
        }
    });
}