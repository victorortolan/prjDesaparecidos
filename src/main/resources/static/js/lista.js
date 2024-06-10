async function getLista() {
  const response = await fetch("http://localhost:8080/api/v1/lista");
  const responseJSON = await response.json();
  return responseJSON;
}

document.addEventListener("DOMContentLoaded", carregarLista());

async function carregarLista() {
  const responseJSON = await getLista();
  responseJSON.map((pessoa) => {
    // cada atributo é um td dentro de tr
    const tr = document.getElementById;
    const deleteButton = document.createElement(".delete-button");
    const editButton = document.createElement(".edit-button");
    tr.innerHTML = `
                <td>
                <button class="delete-button">
                  <i class="fa-solid fa-x"></i>
                </button>
                <button class="edit-button">
                  <i class="fa-solid fa-user-pen"></i>
                </button>
              </td>
`;
    Object.values(pessoa).forEach((valor) => {
      const td = document.createElement("td");
      td.textContent = valor;
      tr.appendChild(td);
    });
    document.getElementById("lista").appendChild(tr);
  });
}
