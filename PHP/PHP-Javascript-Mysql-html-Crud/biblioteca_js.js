function toJSON(string) {
    try {
        return JSON.parse(string);
    } catch (e) {
        return null;
    }
};

function retornaListaFunc(array) {
    let stringRetorno = '<div id="form">';

    for (var i in array) {
        stringRetorno += `
            <br><br>
            Nome:  ${array[i].nome}<br>
            Matrícula:  ${array[i].matricula}<br>
            Função: ${array[i].funcao}<br>
            <br>
            <div class="flex-container" style="justify-content: flex-start">
            <form method="post" action="../excluir/excluir.php">
            <input type="hidden" name="matricula" id="${'matricula' + array[i].matricula}" value="${array[i].matricula}">
            <input type="button" name="excluir" id="excluir" value="Excluir" onClick="excluirFunc(${array[i].matricula});">
            </form>
            <form method="GET" action="../listar/listar.php">
            <input type="hidden" name="matricula" id="${'matricula' + array[i].matricula}" value="${array[i].matricula}">
            <input type="button" name="alterar" id="alterar" value="Alterar" onClick="geraFormAlteracao(${array[i].matricula});">
            </form>
            </div>
        `;
    }

    stringRetorno += "</div>"

    return stringRetorno;
}

function incluirFunc() {
    const funcionario = {
        "nome": document.getElementById("nome").value,
        "matricula": document.getElementById("matricula").value,
        "funcao": document.getElementById("funcao").value,
        "senha": document.getElementById("senha").value
    };

    const stringFunc = JSON.stringify(funcionario);

    const xmlhttp = new XMLHttpRequest();

    xmlhttp.onload = function() {
        document.getElementById("form").style.display = "none";

        document.getElementById("retorno").innerHTML = xmlhttp.responseText;
    }

    xmlhttp.open("POST", "../server/incluir.php");
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("incluir=" + stringFunc);
}

function excluirFunc(matricula) {
    const funcionario = {
        "matricula": document.getElementById("matricula" + (matricula ?? '')).value
    };

    const stringFunc = JSON.stringify(funcionario);

    const xmlhttp = new XMLHttpRequest();

    xmlhttp.onload = function() {
        document.getElementById("form").style.display = "none";

        document.getElementById("retorno").innerHTML = xmlhttp.responseText;
    }

    xmlhttp.open("POST", "../server/excluir.php");
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("excluir=" + stringFunc);
}

function listarFunc(matricula) {
    const funcionario = {
        "matricula": document.getElementById("matricula" + (matricula ?? '')).value
    };

    const func = JSON.stringify(funcionario);

    const xmlhttp = new XMLHttpRequest();

    xmlhttp.onload = function() {
        document.getElementById("form").style.display = "none";

        const retorno = xmlhttp.responseText;

        const arrayFunc = toJSON(retorno);

        if (arrayFunc === null) {
            document.getElementById("retorno").innerHTML = retorno;
        }
        else {
            document.getElementById("retorno").innerHTML = retornaListaFunc(arrayFunc);
        }
    }

    xmlhttp.open("GET","../server/listar.php?matr=" + func);
    xmlhttp.send();
}

function listarTodosFunc() {

    const xmlhttp = new XMLHttpRequest();

    xmlhttp.onload = function() {

        const retorno = xmlhttp.responseText;

        const arrayFunc = toJSON(retorno);

        if (arrayFunc === null) {
            document.getElementById("retorno").innerHTML = retorno;
        }
        else {
            document.getElementById("retorno").innerHTML = retornaListaFunc(arrayFunc);
        }
    }

    xmlhttp.open("GET","../server/listar_todos.php");
    xmlhttp.send();
}

function geraFormAlteracao(matricula) {
    const funcionario = {
        "matricula": document.getElementById("matricula" + (matricula ?? '')).value
    };

    const func = JSON.stringify(funcionario);

    const xmlhttp = new XMLHttpRequest();

    xmlhttp.onload = function() {
        document.getElementById("form").style.display = "none";

        const retorno = xmlhttp.responseText;

        const funcionario = toJSON(retorno);

        if (funcionario === null) {
            document.getElementById("retorno").innerHTML = retorno;
        }
        else {
            const stringRetorno = `
                <br><br>
                <div id="form2">
                <form method="GET" action="../listar/listar.php">
                Nome: <input type="text" name="nome" id="nome" value="${funcionario[0].nome}"><br>
                Matrícula: <input type="text" name="dummy" id="dummy" value="${funcionario[0].matricula}" disabled><br>
                Função: <input type="text" name="funcao" id="funcao" value="${funcionario[0].funcao}"><br>
                Senha Atual: <input type="password" name="senhaAtual" id="senhaAtual" value=""><br>
                Nova Senha: <input type="password" name="senhaNova" id="senhaNova" value=""><br>
                <input type="hidden" name="id" id="id" value="${funcionario[0].id}">
                <input type="hidden" name="matriculaALT" id="matriculaALT" value="${funcionario[0].matricula}">
                <input type="button" name="alterar" id="alterar" value="Alterar" onClick="alterarFunc();">
                </form>
                </div>
                <br><br>
            `;

            document.getElementById("retorno").innerHTML = stringRetorno;
        }
    }

    console.log(func);

    xmlhttp.open("GET","../server/listar.php?matr=" + func);
    xmlhttp.send();
}

function alterarFunc() {
    const funcionario = {
        "id": document.getElementById("id").value,
        "nome": document.getElementById("nome").value,
        "matricula": document.getElementById("matriculaALT").value,
        "funcao": document.getElementById("funcao").value,
        "senhaAtual": document.getElementById("senhaAtual").value,
        "senhaNova": document.getElementById("senhaNova").value
    };

    const stringFunc = JSON.stringify(funcionario);

    const xmlhttp = new XMLHttpRequest();

    xmlhttp.onload = function() {
        document.getElementById("form2").style.display = "none";

        document.getElementById("retorno").innerHTML = xmlhttp.responseText;
    }

    xmlhttp.open("POST", "../server/alterar.php");
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("alterar=" + stringFunc);
}