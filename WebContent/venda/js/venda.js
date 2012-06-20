$(document).ready(function(){
	
	calcularValorTotal();
	
	$("#adicionar_produto").click(function(e){
		e.preventDefault();
		var bt_remover = "<a href='#' class='remover_linha remover_produto'></a>";
		$(this).parents("tr:first").clone(true).appendTo($(this).parents("tbody:first"));
		var linhaAdicionada = $(this).parents("tbody:first").children("tr:last");
		linhaAdicionada.find(".adicionar_linha").after(bt_remover).remove();
		resetarCamposProduto.call(linhaAdicionada);
	});
	
	$(document).on("click", ".remover_produto", function(e){
		e.preventDefault();
		if (confirm("Tem certeza que deseja remover o produto?")) {
			$(this).parents("tr:first").remove();
		}
	});
	
	$(document).on("change", ".pro_id", function(){
		if ($(this).val() != "") {
			var val = $(this).children(":selected").data("valor");
			var tr = $(this).parents("tr:first");
			tr.find(".prm_valor").val(val);
			calcularValorTotal();
		}
	});
	
	$(document).on("change", ".prm_quantidade, .prm_valor", calcularValorTotal);
	
});

$.validator.addMethod("produto_repetido", function(value, element, param){
	var count = 0;
	$(element).parents("tbody").children("tr").each(function(){
		if ($(this).find(".produto_repetido").val() == value) {
			count++;
		}
	});
	return count == 1;
}, function(){
	return $("#produto_repetido").val();
});

$.validator.addClassRules("produto_repetido", {
	produto_repetido: true
});

function calcularValorTotal() {
	var valor_total = 0;
	$(".tabela_consulta tbody tr").each(function(){
		var valor = getFloatVal($(this).find(".prm_valor").val());
		var qtd = getFloatVal($(this).find(".prm_quantidade").val());
		valor *= qtd == 0 ? 1 : qtd;
		valor_total += valor;
	});
	$("#valor_total").val(valor_total);
}

function resetarCamposProduto() {
	$(this).find("input, select").val("");
}

function getFloatVal(valor) {
	if (valor != "") {
		return parseFloat(valor);
	}
	return 0;
}