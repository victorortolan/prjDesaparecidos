const container = document.getElementById("container");
const registerBtn = document.getElementById("register");
const loginBtn = document.getElementById("login");

registerBtn.addEventListener("click", () => {
  container.classList.add("active");
});

loginBtn.addEventListener("click", () => {
  container.classList.remove("active");
});

const cadastroForm = document.getElementById("cadastroForm");
const textC = document.getElementById("text_visual_cadastro");
const textL = document.getElementById("text_visual_login");

cadastroForm.addEventListener("submit", async (e) => {
  e.preventDefault();
  const formData = {
    nome: document.getElementById("nomeC").value,
    email: document.getElementById("emailC").value,
    password: document.getElementById("senhaC").value,
  };

  const response = await fetch(
    "http://localhost:8080/api/v1/usuario/cadastro",
    {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formData),
    }
  );
  const response_text = await response.text();
  if (response_text == "Usuário Criado com Sucesso!") {
    textC.innerHTML = `<h3 style="color:green;margin-top:50px;">Usuário Cadastrado com Sucesso.</h3>`;
  } else {
    textC.innerHTML = `<h3 style="color:red;margin-top:50px;"}}>Não foi possível cadastrar usuário.</h3>`;
  }
});

const loginForm = document.getElementById("loginForm");

loginForm.addEventListener("submit", async (e) => {
  e.preventDefault();
  console.log(e);
  const formData = {
    email: document.getElementById("emailL").value,
    password: document.getElementById("senhaL").value,
  };

  const response = await fetch("http://localhost:8080/api/v1/usuario/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(formData),
  });

  const response_text = await response.text();
  if (response_text != "Não Autorizado") {
    textL.innerHTML = `<h3 style="color:green;margin-top:50px;">Usuário Logado com Sucesso.</h3>`;
    setTimeout(() => {
      window.location.href = "/desaparecido";
    }, 2500);
  } else {
    textL.innerHTML = `<h3 style="color:red;margin-top:50px;"}}>Não foi possível fazer login.</h3>`;
  }
});
