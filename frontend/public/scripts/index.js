const btn_1_create = document.querySelector(".btn-1");
const btn_2_convert = document.querySelector(".btn-2");
const btn_search = document.querySelector("#searchBtn");


btn_1_create.addEventListener("click", () => {
  window.location.href = "./create.html";
});

btn_2_convert.addEventListener("click", () => {
  window.location.href = "./convert.html";
});

btn_search.addEventListener("click", () => {
  window.location.href = "./fetch-results.html";
});
