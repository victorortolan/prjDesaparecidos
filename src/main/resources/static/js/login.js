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

cadastroForm.addEventListener("submit", async (e) => {
  console.log(e);
  const formData = {
    nome: document.getElementById("nomeC").value,
    email: document.getElementById("emailC").value,
    password: document.getElementById("senhaC").value,
  };

  const response = await fetch("http://localhost:8080/api/v1/cadastro", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(formData),
  });
});

const loginForm = document.getElementById("loginForm");

loginForm.addEventListener("submit", async (e) => {
  e.preventDefault();
  console.log(e);
  const formData = {
    email: document.getElementById("emailL").value,
    password: document.getElementById("senhaL").value,
  };

  const response = await fetch("http://localhost:8080/api/v1/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(formData),
  });
});
