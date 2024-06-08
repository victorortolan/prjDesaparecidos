async function getLista() {
  const response = await fetch("http://localhost:8080/api/v1/lista");
  const responseJSON = await response.json();
  console.log(responseJSON, typeof responseJSON); //lista de obj
}

document.addEventListener("DOMContentLoaded", getLista());
