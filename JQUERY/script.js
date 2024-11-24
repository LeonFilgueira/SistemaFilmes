$(document).ready(function () {
    $('#formCriarFilme').submit(function (event) {
        event.preventDefault();
        let id = $('#id').val();
        let titulo = $('#titulo').val();
        let genero = $('#genero').val();
        let sinopse = $('#sinopse').val();
        let ano = $('#ano').val();


        let filme = {
            id: id,
            titulo: titulo,
            genero: genero,
            sinopse: sinopse,
            ano: ano
        };

        criarFilme(filme);
    });
    function criarFilme(filme) {
        $.ajax({
            url: 'http://localhost:8080/filme/adicionar',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(filme),
            success: function (data) {
                alert('Filme criado com sucesso.');
            },
            error: function () {
                alert('Não foi possível criar os dados da API');
            }
        });
    };


    function deletarFilme(id) {
        $.ajax({
            url: 'http://localhost:8080/filme/deletar/' + id,
            method: 'DELETE',
            success: function (data) {
                alert('Filme deletado com sucesso.');
                carregarFilmes();
            },
            error: function () {
                alert('Não foi possível deletar os dados.');
            }
        });
        //alert("To aqui!!"+ id); 
    }

    carregarFilmes();

    function carregarFilmes() {
        $.ajax({
            url: 'http://localhost:8080/filme/listar',
            method: 'GET',
            success: function (data) {
                $('#tabelaFilmes tbody').empty();
                
                for (let i = 0; i < data.length; i++) {
                    let filme = data[i];

                    let botaoDeletar = $('<button>')
                    .text('Excluir')
                    .click(function () {
                        deletarFilme($(this).parent().parent().attr('data-id'));
                        carregarFilmes();
                    });


                    let id = $('<td>').text(filme.id);
                    let titulo = $('<td>').text(filme.titulo);
                    let sinopse = $('<td>').text(filme.sinopse);
                    let genero = $('<td>').text(filme.genero);
                    let ano = $('<td>').text(filme.ano);
                    let botoesOperacoes =$('<td>').append(botaoDeletar)

                    let tr = $('<tr>')
                        .attr('data-id', filme.id)
                        .append(id)
                        .append(titulo)
                        .append(sinopse)
                        .append(genero)
                        .append(ano)
                        .append(botoesOperacoes);

                    $('#tabelaFilmes tbody').append(tr);
                    $('#id').val('');
                    $('#titulo').val('');
	                $('#genero').val('');
                    $('#sinopse').val('');
                    $('#ano').val('');

                    
                }
            },
            error: function () {
                alert('Não foi possível carregar os dados da API');
            }
        });
    }

})

