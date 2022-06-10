function chargement(){
  fetch('http://localhost:8080/rest/pizzas')
  .then(resp => resp.json())
  .then(createList)
}

const listePizza = document.getElementById('listPizza');
const formDiv = document.getElementById('pizzaForm');
const btnToggle = document.getElementById("btnToggle");
const form = document.getElementById("formAjoutPizza");
const btnForm = document.getElementById("btnFormAjoutPizza");
const btnSupprimerForm = document.getElementById("btnSupprimerForm");

function createList(pizzas){
	listePizza.innerHTML= ""
	pizzas.forEach(function (pizza) {
		listePizza.innerHTML += `
		<div class="card mb-12 card-pizza" style="margin-bottom: 2%;" id="${pizza.id}">
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

btnToggle.addEventListener('click', event => {
	if (listePizza.style.display === "none") {
		chargement();
	    listePizza.style.display = "contents";
	    formDiv.style.display = "none";
	    btnToggle.value = "Ajouter une pizza";
	  } else {
	    listePizza.style.display = "none";
	    btnSupprimerForm.style.display = "none";
	    formDiv.style.display = "contents";
	    form.reset();
	    btnToggle.value = "Lister les pizzas";
	  }
});

btnRetourForm.addEventListener('click', event => {
	chargement();
	    listePizza.style.display = "contents";
	    formDiv.style.display = "none";
	    btnToggle.style.display = "block";
	    legendForm.innerText = "Ajouter une pizza";
});


form.addEventListener('submit', function (event) {

	event.preventDefault();
	const formData = new FormData(event.target);
	
	let method = "POST";
	
	if (formData.get('id') !== null) {
		method = "PUT";
	}
	
	fetch('http://localhost:8080/rest/pizzas', {
		method: method,
		body: JSON.stringify(Object.fromEntries(new FormData(event.target))),
		headers: {
			'Content-type': 'application/json; charset=UTF-8'
		}
	}).then(function (response) {
		if (response.ok) {
			return response.json();
		}
		return Promise.reject(response);
	}).then(function (data) {
		btnRetourForm.click();
	}).catch(function (error) {
		console.warn(error);
	});
});

document.addEventListener('click', function(e) {  
	if(e.target.closest('.card-pizza')){
		const divClick = e.target.closest('.card-pizza');
		const legendForm = document.getElementById("legendForm");
		
		listePizza.style.display = "none";
		formDiv.style.display = "contents";
		btnSupprimerForm.style.display = "block";
		
		legendForm.innerText = "Modifier une pizza";
		btnToggle.style.display = "none";
		
		fetch(`http://localhost:8080/rest/pizzas/${divClick.id}`)
			.then(resp => resp.json())
			.then((data) =>{
			    document.getElementById('id').value = data["id"];
				document.getElementById('nom').value = data["nom"];
				document.getElementById('description').value = data["description"];
				document.getElementById('prix').value = data["prix"];
				document.getElementById('image').value = data["image"];
		})
	}
});

btnSupprimerForm.addEventListener('click', event => {
	event.preventDefault();
	
	const idPizza = form.elements['id'].value;
	
	fetch(`http://localhost:8080/rest/pizzas/${idPizza}`, {
		method: "DELETE",
		body: JSON.stringify(Object.fromEntries(new FormData(form))),
		headers: {
			'Content-type': 'application/json; charset=UTF-8'
		}
	}).then(function (response) {
		if (response.ok) {
			btnRetourForm.click();
		}
	}).catch(function (error) {
		console.warn(error);
	});
});
