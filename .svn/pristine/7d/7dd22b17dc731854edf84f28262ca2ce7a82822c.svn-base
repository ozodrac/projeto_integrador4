var caminho = "/ProjetoIntegrador4/";

$.fn.extend({
	aplicarData: function(){
		this.find("input.data").datepicker({'changeMonth': true, 'changeYear': true, 'yearRange' : '1920:+10'}).mask("99/99/9999");
		return this;
	},
	aplicarTelefone: function(){
		this.find("input.telefone").mask("(99) 9999-9999");
		return this;
	}
});

$(document).ready(function() {
	$(".panel-msgs a").click(function(e) {
		e.preventDefault();
		$(this).parent().fadeOut("slow", function() {
			$(this).remove();
		});
	});
	
	$(".marcar_todos").click(function(){
		if($(this).is(":checked")){
			$(".tabela_consulta").find("input:checkbox[name='"+ $(this).attr("id") +"']").prop("checked", true);
		}else{
			$(".tabela_consulta").find("input:checkbox[name='"+ $(this).attr("id") +"']").prop("checked", false);
		}
	});
	
	$("#formulario").validate({
		errorLabelContainer: $("#validate-error"),
		onkeyup: false,
		invalidHandler: function(form, validator) {
			var errors = validator.numberOfInvalids();
			if (errors) {
				//tabs
				var invalidPanels = $(validator.invalidElements()).closest(".ui-tabs-panel", form);
				if (invalidPanels.size() > 0) {
					$.each($.unique(invalidPanels.get()), function() {
						$(this).siblings(".ui-tabs-nav").find("a[href='#" + this.id + "']").parent().addClass("ui-state-error");
					});
				}
			}
		},
		showErrors: function(errorMap, errorList) {
			$.each(errorList, function(index, value) {
				if($(value.element).prev().is("label")){
					value.message = $(value.element).prev().text().replace(" *", "") + ": " + value.message;
				}
			});
			this.defaultShowErrors();
		},
		unhighlight: function(element, errorClass, validClass) {
			$(element).removeClass(errorClass);
			$(element.form).find("label[for=" + element.id + "]").removeClass(errorClass);
			var $panel = $(element).closest(".ui-tabs-panel", element.form);
			if ($panel.size() > 0) {
				if ($panel.find("." + errorClass).size() == 0) {
					$panel.siblings(".ui-tabs-nav").find("a[href='#" + $panel[0].id + "']").parent().removeClass("ui-state-error");
				}
			}
		}
	});
	
	//Acao padrao do botao cancelar
	$(".bt-cancelar").click(function(){
		var modulo = $(this).parents("#toolbar").children("h1").children("a").attr("href");
		window.location = modulo;
	});

	//Menu
	if ($('ul#nav').size() > 0) {
		$('ul#nav').navMenu();
	}
	
	$("#formulario").aplicarData().aplicarTelefone();
});