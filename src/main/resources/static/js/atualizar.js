const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const id = urlParams.get("id");
const back_btn = document.getElementById("back_btn");
back_btn.addEventListener("click", (e) => {
  e.preventDefault();
  window.location = "/";
});
const nome = document.getElementById("firstname");
const idade = document.getElementById("Idade");
const cor = document.getElementById("cor");
const cabelos = document.getElementById("cabelos");
const documento = document.getElementById("documento");
const cidade = document.getElementById("cidade");
async function main() {
  const data = await fetch(`http://localhost:8080/api/v1/des/${id}`);
  const dataJSON = await data.json();
  console.log(dataJSON);
  nome.value = dataJSON.nome;
  idade.value = dataJSON.idade;
  cor.value = dataJSON.cor;
  cabelos.value = dataJSON.cabelos;
  documento.value = dataJSON.documento;
  cidade.value = dataJSON.cidade;
}
const btn = document.getElementById("botao_update_desaparecido");
btn.addEventListener("click", (e) => {
  e.preventDefault();
  const formData = {
    nome: nome.value,
    idade: idade.value,
    cor: cor.value,
    cabelos: cabelos.value,
    documento: documento.value,
    cidade: cidade.value,
  };
  fetch(`http://localhost:8080/api/v1/des/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(formData),
  });
  window.location = "/lista";
});
main();
