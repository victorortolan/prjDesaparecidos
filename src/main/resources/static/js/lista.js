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
    const tr = document.createElement("tr");
    Object.values(pessoa).forEach((valor) => {
      const td = document.createElement("td");
      td.textContent = valor;
      tr.appendChild(td);
    });
    document.getElementById("lista").appendChild(tr);
  });
}
