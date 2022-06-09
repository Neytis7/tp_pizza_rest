function chargement(){
  fetch('http://localhost:8080/rest/pizzas')
  .then(resp => resp.json())
  .then(createList)
}

const listePizza = document.getElementById('listPizza');

const btnAjout = document.getElementById("btnAjoutPizza");

function createList(pizzas){
	listePizza.innerHTML= ""
	pizzas.forEach(function (pizza) {
		listePizza.innerHTML += `
		<div class="card mb-12">
		  <h3 class="card-header text-center">${pizza.nom}</h3>
		  
		  <div class="card-body">
		    <p class="card-text text-center">${pizza.description}</p>
		  </div>
		  
		  <img width="300" src="/img/${pizza.image}" style="position:relative;left:400px;" alt="une pizza"/>
		  
		  <div class="card-footer text-muted text-center">
		    ${pizza.prix} €
		  </div>
		</div>`
	})
}

chargement();


btnAjout.addEventListener('click', event => {
  listePizza.style.display = "none";
});