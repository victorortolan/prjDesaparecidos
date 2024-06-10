const botao_add = document.getElementById("botao_add_desaparecido");
const text = document.getElementById("texto_feedback");
botao_add.addEventListener("click", async (e) => {
  e.preventDefault();
  // const genero = document.getElementById("genero");
  const formData = {
    nome: document.getElementById("firstname").value,
    idade: document.getElementById("Idade").value,
    cor: document.getElementById("cor").value,
    cabelos: document.getElementById("cabelos").value,
    documento: document.getElementById("documento").value,
    cidade: document.getElementById("cidade").value,
  };
  const response = await fetch("http://localhost:8080/api/v1/adiciona", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(formData),
  });

  const response_text = await response.text();
  if (response_text == "Adicionado.") {
    text.innerHTML = `<h3 style="color:green;margin-top:70px;">Desaparecido Adicionado.</h3>`;
  } else {
    text.innerHTML = `<h3 style="color:red;margin-top:70px;"}}>Não é possível cadastrar desaparecido.</h3>`;
  }
});
