const btn = document.getElementById("btn");
function botao(e) {
  const texto = document.getElementById("texto");
  console.log("exec");
  e.preventDefault();
  texto.textContent = "tchau!";
}

btn.addEventListener("click", botao);
