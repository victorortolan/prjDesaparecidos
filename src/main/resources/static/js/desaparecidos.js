const botao_add = document.getElementById("botao_add_desaparecido");

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
  console.log(JSON.stringify(formData));
  const response = await fetch("http://localhost:8080/api/v1/adiciona", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(formData),
  });
});
