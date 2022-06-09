function chargement(){
  fetch('http://localhost:8080/rest/pizzas')
  .then(resp => resp.json())
  .then(createList)
}

const listePizza = document.getElementById('listPizza')
function createList(pizzas){
	listePizza.innerHTML= ""
	pizzas.forEach(function (pizza) {
		listePizza.innerHTML += `
		<div class="card" data-id=${pizza.id}>
			<h2>${pizza.nom}</h2>
			<img src="/img/${pizza.image}"/>
		</div>
		`
		})
}

chargement();