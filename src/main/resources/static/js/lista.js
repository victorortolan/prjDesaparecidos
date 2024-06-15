async function getLista() {
  const response = await fetch(
    "http://localhost:8080/api/v1/desaparecidos/lista"
  );
  const responseJSON = await response.json();
  return responseJSON;
}

document.addEventListener("DOMContentLoaded", carregarLista());

async function carregarLista() {
  const responseJSON = await getLista();
  responseJSON.map((pessoa) => {
    const tr = document.createElement("tr");
    const td = document.createElement("td");
    const delete_btn = document.createElement("button");
    delete_btn.className = "delete-button";
    delete_btn.id = pessoa.id;
    delete_btn.style = "color:red; border: none; background-color: #fff4";
    const deleteIcon = document.createElement("i");
    deleteIcon.className = "fa-solid fa-x";
    delete_btn.appendChild(deleteIcon);
    const edit_btn = document.createElement("button");
    edit_btn.className = "edit-button";
    edit_btn.id = pessoa.id;
    edit_btn.style =
      "margin-left:10px; color:green; border: none; background-color: #fff4";
    const editIcon = document.createElement("i");
    editIcon.className = "fa-solid fa-user-pen";
    edit_btn.appendChild(editIcon);
    delete_btn.addEventListener("click", (event) => {
      // Lógica para deletar
      const alvo = event.target.closest("button").id;
      const response = fetch(
        `http://localhost:8080/api/v1/desaparecidos/delete/${alvo}`,
        {
          method: "DELETE",
          headers: { "Content-Type": "application/json" },
        }
      );
      window.location = "/lista";
    });

    edit_btn.addEventListener("click", (event) => {
      const alvo = event.target.closest("button").id;
      window.location = `/atualizar?id=${alvo}`;
    });
    td.appendChild(delete_btn);
    td.appendChild(edit_btn);
    tr.appendChild(td);
    const { id, ...filteredPessoa } = pessoa;
    console.log(filteredPessoa);
    Object.entries(filteredPessoa).forEach(([chave, valor]) => {
      const td = document.createElement("td");
      if (chave == "encontrado") {
        td.textContent = valor == "true" ? "Localizado" : "Desaparecido";
      } else {
        td.textContent = valor;
      }
      tr.appendChild(td);
    });

    document.getElementById("lista").appendChild(tr);
  });
}
